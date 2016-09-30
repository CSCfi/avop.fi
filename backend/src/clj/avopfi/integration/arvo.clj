(ns avopfi.integration.arvo
  (:require
    [config.core :refer [env]]
    [avopfi.consts :refer :all]
    [buddy.sign.jws :as jws]
    [java-time :refer [as local-date]]
    [slingshot.slingshot :refer [try+ throw+]]
    [clojure.tools.logging :as log]
    [clj-http.client :as client]
    [avopfi.validator :as validator :refer [lisensiaatti?]]))

(defn build-kyselykerran-nimi
  [opiskeluoikeus vuosi]
  (if (nil? (:tyyppi opiskeluoikeus))
      nil
      (str
        (condp = (:tyyppi opiskeluoikeus)
          amk-alempi-tyyppi "AUTOMAATTI AVOP-AMK"
          amk-ylempi-tyyppi "AUTOMAATTI AVOP-YAMK"
          alempi-korkeakoulututkinto "AUTOMAATTI KANDI"
          ylempi-korkeakoulututkinto (if (validator/lisensiaatti? opiskeluoikeus)
                                       "AUTOMAATTI LAAKIS"
                                       "AUTOMAATTI KANDI")
          "") " " vuosi)))

(defn clean-opiskeluoikeus-data [opiskeluoikeus]
  {
   :oppilaitos (-> opiskeluoikeus :oppilaitos :id)
   :koulutus   (-> opiskeluoikeus :koulutus :id)
   :kunta      (-> opiskeluoikeus :kunta :id)
   :koulutusmuoto (condp = (:koulutusmuoto opiskeluoikeus)
                    0 "paivaopiskelu"
                    1 "monimuoto"
                    nil)
   :opiskeluoikeustyyppi (:opiskeluoikeustyyppi opiskeluoikeus)
   :laajuus (:laajuus opiskeluoikeus)
   :kyselykerran_nimi 
   (build-kyselykerran-nimi opiskeluoikeus
                            (as (local-date) :year))})


(defn generate-questionnaire-credentials!
  "Generate Arvo questionnaire credentials with given data"
  [opiskeluoikeus-data kieli]
  (let [json-data (clean-opiskeluoikeus-data opiskeluoikeus-data)
        auth-header (str "Bearer " 
                         (jws/sign {:caller "avopfi"} (:arvo-jwt-secret env)))]
    (try+ 
     (let [resp (client/post
                 (:arvo-api-url env)
                 {
                  :debug (:is-dev env)
                  :form-params (assoc json-data :kieli kieli)
                  :headers {:Authorization auth-header}
                  :content-type :json
                  :as :json
                  :socket-timeout 2000
                  :conn-timeout 1000})
              hash (-> resp :body :tunnus)]       
       (if (nil? hash) 
         (throw+ resp) hash))
     (catch [:status 403] {:keys [request-time headers body]}
       (log/warn "403" request-time headers))
     (catch Object _
       (log/error (:throwable &throw-context) "unexpected error")
       (throw+)))))
