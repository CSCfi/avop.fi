(ns avopfi.integration.arvo
  (:require
    [config.core :refer [env]]
    [avopfi.consts :refer :all]
    [buddy.sign.jws :as jws]
    [java-time :refer [as local-date]]
    [slingshot.slingshot :refer [try+ throw+]]
    [clojure.tools.logging :as log]
    [clj-http.client :as client]))

(defn build-kyselykerran-nimi
  [opiskeluoikeustyyppi vuosi]
  (if (nil? opiskeluoikeustyyppi)
      nil
      (str
        (condp = opiskeluoikeustyyppi
          amk-alempi-tyyppi "AUTOMAATTI AVOP-AMK"
          amk-ylempi-tyyppi "AUTOMAATTI AVOP-YAMK"
          alempi-korkeakoulututkinto "AUTOMAATTI KANDI"
          "") " " vuosi)))

(defn clean-opiskeluoikeus-data
  [{:keys [kieli koulutusmuoto opiskeluoikeustyyppi laajuus]
    {oppilaitos-id :id} :oppilaitos
    {koulutus-id :id} :koulutus
    {kunta-id :id} :kunta}]
  {
   :oppilaitos oppilaitos-id
   :koulutus   koulutus-id
   :kunta      kunta-id
   :koulutusmuoto (condp = koulutusmuoto
                    0 "paivaopiskelu"
                    1 "monimuoto"
                    nil)
   :opiskeluoikeustyyppi opiskeluoikeustyyppi
   :laajuus laajuus
   :kyselykerran_nimi 
   (build-kyselykerran-nimi opiskeluoikeustyyppi 
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
