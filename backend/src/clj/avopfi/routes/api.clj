(ns avopfi.routes.api
  (:require [avopfi.layout :as layout]
            [buddy.auth :refer [throw-unauthorized]]
            [clojure.java.data :refer :all]
            [avopfi.consts :refer :all]
            [avopfi.util :refer :all]
            [avopfi.integration.virta :as virta]
            [avopfi.integration.opintopolku :as op]
            [avopfi.integration.arvo :as arvo]
            [avopfi.db.core :as db]
            [config.core :refer [env]]
            [compojure.core :refer :all]
            [ring.util.http-response :refer :all]
            [clojure.java.io :as io]
            [clojure.tools.logging :as log]))

(defn home-page []
  (layout/render
   "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn get-oppilaitos-code-by-domain [domain]
  (let [mapping
        (db/get-mapping-by-domain {:domain domain})]
    (:code mapping)))

(defn laajuus-valid? [opiskeluoikeus]
  (< 0 (get-in opiskeluoikeus [:laajuus :opintopiste] 0)))

(defn has-organization? [home-organization {org-koodi :myontaja}]
  (let
    [code (get-oppilaitos-code-by-domain home-organization)]
    (= code org-koodi)))

(defn vals->pct [f s] (int (* (float (/ f s)) 100)))

(defn check-opintosuoritukset [oo-tyyppi pisteet laajuus]
  (>= (vals->pct pisteet laajuus) (get tutkintoon-vaaditut-pisteet oo-tyyppi)))

(defn has-enough-opintosuoritus?
  [virta-suoritukset {oo-tyyppi :tyyppi oo-avain :avain
                      {oo-laajuus :opintopiste} :laajuus}]
  (let [pisteet
        (->> virta-suoritukset
             (filter #(and
                       (= (:opiskeluoikeusAvain %) oo-avain)
                       (= (:laji %) opintosuoritus-muu-laji)
                       (empty? (:sisaltyvyys %))))
             (reduce #(+ %1 (int (-> %2 :laajuus :opintopiste))) 0))]
    (check-opintosuoritukset oo-tyyppi pisteet (int oo-laajuus))))

(defn opiskeluoikeus->ui-map
  [{:keys [avain myontaja tyyppi] jaksot :jakso {laajuus :opintopiste} :laajuus}]
  (let [{kunta-id :koulutuskunta :keys [luokittelu koulutuskoodi koulutuskieli]}
          (virta/select-active-timespan jaksot)
        kunta (op/extract-metadata (op/get-kunta-data kunta-id))
        koulutus (op/extract-metadata (op/get-koulutus-data koulutuskoodi))
        koulutustyyppi (virta/conclude-study-type tyyppi luokittelu)
        oppilaitos (op/extract-metadata (op/get-oppilaitos-data myontaja))]
    {
     :id avain
     :kunta {:id kunta-id :nimi kunta}
     :kieli koulutuskieli
     :koulutus {:id koulutuskoodi :nimi koulutus}
     :koulutusmuoto koulutustyyppi
     :opiskeluoikeustyyppi tyyppi
     :laajuus laajuus
     :oppilaitos {:id myontaja :nimi oppilaitos}
     }))

(defn amk-vaatimukset [virta-suoritukset home-organization]
  [#(laajuus-valid? %)
   #(let [loppu (:loppuPvm %)] (or (nil? loppu) (is-date-valid? loppu)))
   (partial has-organization? home-organization)
   (partial has-enough-opintosuoritus? virta-suoritukset)])

(defn kandi-vaatimukset [virta-suoritukset home-organization]
  [#(= (:tyyppi %) alempi-korkeakoulututkinto)])

(defn vaatimukset [tyyppi]
  (tyyppi {:avop amk-vaatimukset
           :kandi kandi-vaatimukset}))

(defn filter-oikeudet [virta-oikeudet virta-suoritukset home-organization tyyppi]
  (try
    (filter (apply every-pred ((vaatimukset tyyppi) virta-suoritukset home-organization)) virta-oikeudet)
    (catch Exception e
      (let [msg (.getMessage e)]
        (log/error "Virhe valideja opiskeluoikeuksia rajattaessa: " msg)
        (throw e)))))

(defn shibbo-vals->opiskeluoikeudet [shibbo-vals tyyppi]
  (let [virta-oikeudet (virta/get-virta-opiskeluoikeudet shibbo-vals)
        virta-suoritukset
          (virta/get-virta-suoritukset shibbo-vals)
        valid-oikeudet
          (filter-oikeudet virta-oikeudet virta-suoritukset
                           (shibbo-vals "home-organization")
                           tyyppi)
        oikeudet (map opiskeluoikeus->ui-map valid-oikeudet)]
    (log/info "Löytyi" (count oikeudet) "validia oikeutta")
    oikeudet))

(defn debug-status [{:keys [session headers identity] :as request}]
  (if (:is-dev env)
    (ok {
         :headers headers
         :shibbo identity
         :oo (:opiskeluoikeudet-data session)})
    (not-found {})))

(defn process-registration [{params :body-params session :session}]
  (let [
        current-srid (:opiskeluoikeus_id params)
        kieli (:kieli params)
        opiskeluoikeudet-data (:opiskeluoikeudet-data session)
        opiskeluoikeus (some #(when (= current-srid (:id %)) %) opiskeluoikeudet-data)]
    (if opiskeluoikeus
      (let [res (db/get-visitor-by-srid {:opiskeluoikeus_id current-srid})]
        (if (nil? res)
          (let [arvo-hash
                (arvo/generate-questionnaire-credentials! opiskeluoikeus kieli)]
            (db/create-visitor! {
                                 :opiskeluoikeus_id current-srid
                                 :oppilaitos_id (-> opiskeluoikeus :oppilaitos :id)
                                 :arvo_answer_hash arvo-hash})
            (ok {:kysely_url (str
                              (:arvo-answer-url env) arvo-hash "/" kieli)}))
          ;; No obviously obvious status code when entity is duplicate,
          ;; (mis)using 422 as some other application/frameworks here.
          (unprocessable-entity
           {:status 422 :detail "Entity already exists" :kysely_url
            (str (:arvo-answer-url env) (:arvo_answer_hash res) "/" kieli)})))
      (throw-unauthorized))))

(defn opiskeluoikeudet [request]
  (let [shibbo-vals (:identity request)
        tyyppi (-> request :route-params :tyyppi keyword)]
    (if (not (map? shibbo-vals))
      (throw-unauthorized)
      (let [session (:session request)
            resp-data
            (shibbo-vals->opiskeluoikeudet shibbo-vals tyyppi)]
        (-> (ok resp-data)
            (assoc :session
                   (assoc session :opiskeluoikeudet-data
                                  resp-data)))))))

(defroutes api-routes
  (context
      "/api" []
    (GET "/" [] (home-page))
    (GET "/opiskeluoikeudet/:tyyppi" request
      (opiskeluoikeudet request))
    (POST "/rekisteroidy" request
      (process-registration request))
    (GET "/status" request
      (debug-status request)))
  (GET "/" [] (found "/api")))
