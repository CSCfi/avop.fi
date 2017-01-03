(ns avopfi.integration.arvo
  (:require
    [config.core :refer [env]]
    [avopfi.consts :refer :all]
    [buddy.sign.jws :as jws]
    [java-time :refer [as local-date]]
    [slingshot.slingshot :refer [try+ throw+]]
    [clojure.tools.logging :as log]
    [clj-http.client :as client]
    [avopfi.util :refer [in?]]
    [clojure.core.match :refer :all]
    [avopfi.validator :refer [lisensiaatti? jakso-active?]]))


(defn sisaltyy-koodeihin [koodit koulutuskoodit]
  (some #(in? koodit %) koulutuskoodit))

(defn vaatimukset [{tyypit :tyypit koodit :koodit} t k]
    (let [tyyppi-ok (or (nil? tyypit) (in? tyypit t))
          koodit-ok (or (nil? koodit) (sisaltyy-koodeihin koodit k))]
      (and tyyppi-ok koodit-ok)))


(defn build-kyselykerran-nimi [opiskeluoikeus vuosi]
  (let [aktiiviset-jaksot (:jakso opiskeluoikeus)
        koodit (map :koulutuskoodi aktiiviset-jaksot)
        tyyppi (:opiskeluoikeustyyppi opiskeluoikeus)
        kyselykerran-nimi (cond
                            (vaatimukset {:tyypit [ylempi-korkeakoulututkinto]
                                          :koodit laakis-koodit} tyyppi koodit) "AUTOMAATTI LAAKIS"
                            (vaatimukset {:koodit ekonomi-koodit} tyyppi koodit) "AUTOMAATTI EKONOMIT"
                            (vaatimukset {:koodit tek-koodit} tyyppi koodit) "AUTOMAATTI TEK"
                            (vaatimukset {:tyypit [amk-alempi-tyyppi]} tyyppi koodit) "AUTOMAATTI AVOP-AMK"
                            (vaatimukset {:tyypit [amk-ylempi-tyyppi]} tyyppi koodit) "AUTOMAATTI AVOP-YAMK"
                            (vaatimukset {:tyypit [alempi-korkeakoulututkinto ylempi-korkeakoulututkinto]} tyyppi koodit) "AUTOMAATTI KANDI")]
    (if (nil? kyselykerran-nimi)
      nil
      (str kyselykerran-nimi " " vuosi))))

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
