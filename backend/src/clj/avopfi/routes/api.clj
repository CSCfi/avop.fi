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
            [clojure.tools.logging :as log]
            [avopfi.validator :refer [validate]]
            [clojure.walk :refer [stringify-keys]]
            [avopfi.middleware :refer [wrap-basic-auth]]
            [cats.core :as m]
            [cats.monad.either :as either]
            [io.clj.logging :refer [with-logging-context]]
            [java-time :refer [as local-date]]))


(defn home-page []
  (layout/render
   "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn opiskeluoikeus->ui-map
  [messages {:keys [avain myontaja tyyppi alkuPvm] jaksot :jakso {laajuus :opintopiste} :laajuus}]
  (let [{kunta-id :koulutuskunta :keys [luokittelu koulutuskoodi koulutuskieli]}
        (virta/select-active-timespan jaksot)
        kunta (op/extract-metadata (op/get-kunta-data kunta-id))
        koulutus (arvo/get-koulutus-data koulutuskoodi)
        koulutustyyppi (virta/conclude-study-type tyyppi luokittelu)
        oppilaitos (arvo/get-oppilaitos-data myontaja)]
    {
     :id avain
     :aloituspvm alkuPvm
     :kunta {:id kunta-id :nimi kunta}
     :kieli koulutuskieli
     :koulutus {:id koulutuskoodi :nimi koulutus}
     :koulutusmuoto koulutustyyppi
     :opiskeluoikeustyyppi tyyppi
     :laajuus laajuus
     :jakso jaksot
     :oppilaitos {:id myontaja :nimi oppilaitos}
     :virheet (map #(clojure.string/replace (name %) "-" "_") messages)}))

(defn to-ui [type oikeudet]
  (let [oikeudet (get oikeudet type)]
    (map #(opiskeluoikeus->ui-map (:messages %) (:oikeus %)) oikeudet)))

(defn get-oppilaitos-code-by-domain [domain]
  (let [mapping (db/get-mapping-by-domain {:domain domain})]
    (:code mapping)))

(defn validate-oikeudet [tyyppi virta-data]
  (let [{oikeudet :oikeudet suoritukset :suoritukset oppilaitos-id :oppilaitos-id} virta-data
        validated-oikeudet (validate oikeudet suoritukset oppilaitos-id tyyppi)]
    (either/right
      {:valid (to-ui :valid validated-oikeudet)
       :invalid (to-ui :invalid validated-oikeudet)
       :oppilaitos_id oppilaitos-id})))

(defn get-virta-oikeudet [shibbo-vals]
  (try-or :virta_error
     (let [home-organization (:home-organization shibbo-vals)
           oppilaitos-id (get-oppilaitos-code-by-domain home-organization)
           virta-oikeudet (virta/get-virta-opiskeluoikeudet shibbo-vals oppilaitos-id)
           virta-suoritukset (virta/get-virta-suoritukset shibbo-vals oppilaitos-id)]
       {:oikeudet virta-oikeudet :suoritukset virta-suoritukset :oppilaitos-id oppilaitos-id})))

(defn debug-status [{:keys [session headers identity] :as request}]
  (if (:is-dev env)
    (ok {
         :headers headers
         :shibbo identity
         :oo (:opiskeluoikeudet-data session)})
    (not-found {})))

(defn jslog [{params :body-params}]
  (log/error "JS Error:" (:message params)))

(defn get-hash-from-arvo [kieli opiskeluoikeus]
  (try-or :arvo_error
    (arvo/generate-questionnaire-credentials! opiskeluoikeus kieli)))

(defn create-visitor-entry [opiskeluoikeus arvo-hash]
  (try-or :general_error
    (db/create-visitor! {:taustatiedot {:opiskeluoikeus (-> opiskeluoikeus :id)
                                        :oppilaitos (-> opiskeluoikeus :oppilaitos :id)
                                        :kunta (-> opiskeluoikeus :kunta :id)
                                        :aloituspvm (-> opiskeluoikeus :aloituspvm)
                                        :kieli (-> opiskeluoikeus :kieli)
                                        :koulutus (-> opiskeluoikeus :koulutus :id)
                                        :koulutusmuoto (-> opiskeluoikeus :koulutusmuoto)}
                         :vastaajatunnus arvo-hash})
    arvo-hash))

(defn create-vastaajatunnus [opiskeluoikeus kieli]
  (m/>>= (get-hash-from-arvo kieli opiskeluoikeus)
         (partial create-visitor-entry opiskeluoikeus)))


;TODO: Split this into two parts, API and get-answer-url, add sessionid in API
(defn process-registration [{params :body-params session :session}]
  (let [current-srid (:opiskeluoikeus_id params)
        oppilaitos (:oppilaitos_id params)
        kieli (:kieli params)
        opiskeluoikeudet-data (:opiskeluoikeudet-data session)
        opiskeluoikeus (some #(when (= current-srid (:id %)) %) opiskeluoikeudet-data)
        sessionid (:sessionid session)]
    (log/info "Siirrytään kyselyyn. Opiskeluoikeus:" (:id opiskeluoikeus) "Oppilaitos:" oppilaitos)
    (if opiskeluoikeus
      (if-let [visitor-entry (db/get-visitor {:opiskeluoikeus_id (:id opiskeluoikeus) :oppilaitos_id oppilaitos})]
        (ok {:kysely_url (str (:arvo-answer-url env) (:vastaajatunnus visitor-entry)) ;"/" kieli
             :sessionid sessionid})
        (let [res (create-vastaajatunnus opiskeluoikeus kieli)]
          (if (either/right? res)
            (ok {:kysely_url (str (:arvo-answer-url env) (m/extract res));  "/" kieli
                 :sessionid sessionid})
            (not-found {:error (m/extract res) :sessionid sessionid}))))
      (throw-unauthorized))))

(defn get-rekry-hash [oppilaitos identity]
  (try-or :arvo_error
    (let [eppn (-> identity :eppn)
          employeeNumber (-> identity :employeeNumber)
          henkilonumero (or (:employeeNumber identity) (:eppn identity))
          vuosi (as (local-date) :year)
          vanha-tunnus (or (when employeeNumber (db/get-rekry-visitor {:oppilaitos oppilaitos
                                                                       :employeeNumber employeeNumber
                                                                       :vuosi vuosi}))
                           (when eppn (db/get-rekry-visitor {:oppilaitos oppilaitos
                                                             :eppn eppn
                                                             :vuosi vuosi})))]
      (or (:vastaajatunnus vanha-tunnus)
        (arvo/generate-rekry-credentials! oppilaitos henkilonumero)))))

(defn create-rekry-visitor [request oppilaitos tunnus]
  (try-or :general_error
    (let [employeeNumber (-> request :identity :employeeNumber)
          eppn (-> request :identity :eppn)
          vuosi (as (local-date) :year)
          taustatiedot (-> {:oppilaitos oppilaitos :vuosi vuosi}
                           (cond-> employeeNumber (assoc :employeeNumber employeeNumber))
                           (cond-> eppn (assoc :eppn eppn)))]
      (db/create-visitor! {:taustatiedot taustatiedot
                           :vastaajatunnus tunnus}))
    tunnus))

(defn validate-haka [request]
  (if (not-nil? (:identity request))
    (either/right(:identity request))
    (either/left :haka_error)))


(defn validate-rekry-haka [request]
  (if (or (-> request :identity :employeeNumber) (-> request :identity :eppn))
    (either/right (:identity request))
    (either/left :haka_error)))

(defn process-rekry [request]
  (let [oppilaitos (get-oppilaitos-code-by-domain (get-in request [:identity :home-organization]))
        sessionid (get-in request [:session :sessionid])
        tunnus (m/>>= (either/right request)
                      validate-rekry-haka
                      (partial get-rekry-hash oppilaitos)
                      (partial create-rekry-visitor request oppilaitos))]
    (if (either/right? tunnus)
      (ok {:kysely_url (str (:arvo-answer-url env) (m/extract tunnus))
           :sessionid sessionid})
      (not-found {:error (m/extract tunnus) :sessionid sessionid}))))

(defn validate-virta-data[virta-data]
  (if (and (not-nil? (:oikeudet virta-data))
           (not-nil? (:suoritukset virta-data)))
    (either/right virta-data)
    (either/left :no_data_in_virta)))

(defn get-opiskeluoikeudet [request]
  (let [tyyppi (-> request :route-params :tyyppi keyword)]
    (m/>>= (either/right request)
           validate-haka
           get-virta-oikeudet
           validate-virta-data
           (partial validate-oikeudet tyyppi))))

(defn opiskeluoikeudet [request]
  (let [session (:session request)
        result (get-opiskeluoikeudet request)]
    (if (either/right? result)
      (-> (ok (assoc (m/extract result) :sessionid (:sessionid session)))
          (assoc :session
            (-> session
              (assoc :opiskeluoikeudet-data (:valid (m/extract result)))
              (assoc :sessionid (:sessionid session)))))
      (not-found {:error (m/extract result)
                  :sessionid (:sessionid session)}))))

(defn get-visitors [request]
  (ok (db/get-visitors)))

(defroutes api-routes
  (context
      "/api" []
    (GET "/" [] (forbidden))
    (GET "/opiskeluoikeudet/:tyyppi" request
      (with-logging-context {:sessionid (format "[%s]"(get-in request [:session :sessionid]))}
        (opiskeluoikeudet request)))
    (POST "/rekisteroidy" request
      (with-logging-context {:sessionid (format "[%s]"(get-in request [:session :sessionid]))}
        (process-registration request)))
    (GET "/status" request
      (debug-status request))))


(defroutes common-routes
  (context
    "/api" []
    (POST "/log" request
      (with-logging-context {:sessionid (format "[%s]"(get-in request [:session :sessionid]))}
        (jslog request)))))

(defroutes rekry-routes
  (context
    "/api" []
    (POST "/rekry" request
      (with-logging-context {:sessionid (format "[%s]"(get-in request [:session :sessionid]))}
        (process-rekry request)))))


(defroutes vipunen-routes
  (context "/api/vipunen" []
    (GET "/" request
      (get-visitors request))))

(defroutes export-routes
  (context "/api/export/v1" []
    (POST "/opiskeluoikeudet" request
      (let [oppilaitokset (-> request :params :oppilaitokset)]
        (ok (db/get-opiskeluoikeus {:oppilaitokset oppilaitokset}))))))