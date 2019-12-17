(ns avopfi.integration.arvo
  (:require
    [config.core :refer [env]]
    [avopfi.consts :refer :all]
    [buddy.sign.jwt :as jwt]
    [java-time :refer [as local-date]]
    [clojure.tools.logging :as log]
    [clj-http.client :as client]
    [avopfi.util :refer [in?]]
    [clojure.core.match :refer [match]]
    [avopfi.validator :refer [lisensiaatti? jakso-active?]]
    [cheshire.core :as cheshire]))


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
                         (jwt/sign {:caller "avopfi"} (:arvo-jwt-secret env)))]
    (log/info "Pyydetään vastaajatunnusta tiedoille: " json-data)
    (let [resp (client/post
                (str (:arvo-api-url env) "/luovastaajatunnus")
                {
                 :debug (:is-dev env)
                 :form-params (assoc json-data :kieli kieli)
                 :basic-auth ["kyselyynohjaus" (:arvo-jwt-secret env)]
                 :content-type :json
                 :as :json
                 :socket-timeout 2000
                 :conn-timeout 1000})
             hash (-> resp :body :tunnus)]
      (if (nil? hash)
        (throw resp) hash))))

;TODO: refactor
(defn generate-rekry-credentials! [oppilaitos henkilonumero]
  (log/info "Pyydetään rekrykyselyn vastaajatunnus" oppilaitos henkilonumero)
  (let [resp (client/post (str (:arvo-api-url env) "/luovastaajatunnus/rekry")
                          {:debug (:is-dev env)
                           :form-params {:oppilaitos oppilaitos :henkilonumero henkilonumero :vuosi (as (local-date) :year)}
                           :content-type :json
                           :as :json
                           :socket-timeout 2000
                           :conn-timeout 1000
                           :basic-auth ["kyselyynohjaus" (:arvo-jwt-secret env)]})
        hash (-> resp :body :tunnus)]
    (if (nil? hash)
      (throw resp) hash)))

(defn get-kaikki-oidit [oid]
  (let [resp (client/get (str (:arvo-api-url env) (format "/henkilo/kaikki-oidit/%s" oid))
                         {:basic-auth ["kyselyynohjaus" (:arvo-jwt-secret env)]
                          :socket-timeout 2000
                          :conn-timeout 1000
                          })]
    (if (nil? (:body resp))
      (throw resp)
      (cheshire/parse-string (:body resp)))))

(defn get-oppilaitos-data [oppilaitos]
  (let [resp (client/get (str (:arvo-api-url env) "/koodisto/oppilaitos/" oppilaitos)
                         {:basic-auth ["kyselyynohjaus" (:arvo-jwt-secret env)]})]
       (if (nil? (:body resp))
         (throw resp)
         (cheshire/parse-string (:body resp)))))

(defn get-koulutus-data [koulutuskoodi]
  (let [resp (client/get (str (:arvo-api-url env) "/koodisto/koulutus/" koulutuskoodi)
                         {:basic-auth ["kyselyynohjaus" (:arvo-jwt-secret env)]})]
    (if (nil? (:body resp))
      (throw resp)
      (cheshire/parse-string (:body resp)))))

