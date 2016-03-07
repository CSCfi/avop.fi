(ns avopfi.routes.api
  (:require [avopfi.layout :as layout]
            [buddy.auth :refer [throw-unauthorized]]
            [clojure.java.data :refer :all]
            [clojure.core.match :refer [match]]
            [avopfi.integration.virta :as virta]
            [avopfi.integration.opintopolku :as op]
            [avopfi.integration.arvo :as arvo]
            [avopfi.db.core :as db]
            [config.core :refer [env]]
            [compojure.core :refer :all]
            [ring.util.http-response :refer :all]
            [clojure.java.io :as io]))

(defn home-page []
  (layout/render
   "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn get-oppilaitos-code-by-domain [domain]
  (let [mapping
        (db/get-mapping-by-domain {:domain domain})] (:code mapping)))

(defn has-organization? [home-organization degree]
  (let
      [code (get-oppilaitos-code-by-domain home-organization)]
    (= code (-> degree :myontaja :koodi))))

(defn degree->ui-map
  [degree]
  (let [
        degree-id (:avain degree)
        timespan (virta/select-active-timespan (:jakso degree))
        municipality-id (:koulutuskunta timespan)
        education-id (:koulutuskoodi timespan)
        org-id (-> degree :myontaja :koodi)
        lang (:koulutuskieli timespan)
        municipality (op/extract-metadata (op/get-municipality-data municipality-id))
        education (op/extract-metadata (op/get-education-data education-id))
        education-type (virta/conclude-study-type
                        (degree :tyyppi)
                        (degree :aikuiskoulutus))
        school (op/extract-metadata (op/get-school-data org-id))]
    {
     :id degree-id
     :municipality {:id municipality-id :name municipality}
     :lang lang
     :degree {:id education-id :name education}
     :type education-type
     :school {:id org-id :name school}
     }))

(defn filter-degrees [virta-degrees home-organization]
  (try
    (->>
     virta-degrees
     (filter (partial has-organization? home-organization))
     (map degree->ui-map))
    (catch Exception e
      (let [msg (.getMessage e)]
        (println "caught exception: " msg)
        (throw e)))))

(defn get-virta-degrees [shibbo-vals]
  (match [shibbo-vals]
         [{"learner-id" lid}]
           (virta/get-pending-degrees-by-oid lid)
         [(:or {"national-identification-number" nin} {"unique-id" nin})]
           (virta/get-pending-degrees-by-pid nin)
         :else nil))

(defn shibbo-vals->study-rights [shibbo-vals]
  (let [virta-degrees (get-virta-degrees shibbo-vals)
        valid-rights
        (filter-degrees virta-degrees (shibbo-vals "home-organization"))]
    valid-rights))

(defn process-registration [{params :body-params session :session}]
  (let [current-srid (:study_right_id params) study-rights-data (:study-rights-data session)]
    (if (some #(= current-srid (:id %)) study-rights-data)
      (let [res (db/get-visitor-by-srid {:study_right_id current-srid})]
        (if (nil? res)
          (let [arvo-hash (arvo/generate-questionnaire! study-rights-data)]
            (db/create-visitor! {:study_right_id current-srid
                                 :arvo_answer_hash arvo-hash})
            (ok {:questionnaire_url (str (:arvo-answer-url env) arvo-hash)}))
            ;; No obviously obvious status code when entity is duplicate,
            ;; (mis)using 422 as some other application/frameworks here.
            (unprocessable-entity
              {:status 422 :detail "Entity already exists" :questionnaire_url
                       (str (:arvo-answer-url env) (:arvo_answer_hash res))})))
      (throw-unauthorized))))

(defn study-rights [request]
  (let [shibbo-vals (:identity request)]
    (if (not (map? shibbo-vals))
      (throw-unauthorized)
      (let [session (:session request)
            resp-data
            (shibbo-vals->study-rights shibbo-vals)]
        (-> (ok resp-data)
            (assoc :session
                   (assoc session :study-rights-data
                                  resp-data)))))))

(defroutes api-routes
  (context
      "/api" []
    (GET "/" [] (home-page))
    (GET "/opiskeluoikeudet" request
      (study-rights request))
    (POST "/submit-registration" request
      (process-registration request))
    (GET "/status"
         {:keys [headers] :as request}
      (let [shibbo-vals (:identity request)]
        (ok {:headers headers :shibbo shibbo-vals}))))
  (GET "/" [] (found "/api")))
