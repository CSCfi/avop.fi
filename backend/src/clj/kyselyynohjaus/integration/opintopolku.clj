(ns kyselyynohjaus.integration.opintopolku
  (:require
    [clojure.string :as str]
    [config.core :refer [env]]
    [clj-http.client :as client]
    [clojure.tools.logging :as log]))

(def rest-path "koodisto-service/rest/codeelement/latest/")

(defn build-url [code code-type]
  (str (:opintopolku-base-url env) rest-path code-type "_" code))

(defn get-code-data! [code code-type]
  (try
    (:body (client/get
            (build-url code code-type)
            {:as :json :socket-timeout 2000 :conn-timeout 1000 :headers {"Caller-Id" "1.2.246.562.10.2013112012294919827487.arvo"}}))
    (catch Exception e
      (log/info "Koodin" code "Haku epäonnistui:" (.getMessage e)))))


(defn get-oppilaitos-data [code]
  (get-code-data! code "oppilaitosnumero"))

(defn get-kunta-data [code]
  (get-code-data! code "kunta"))

(defn get-koulutus-data [code]
  (get-code-data! code "koulutus"))

(defn ^:deprecated get-oppilaitos-code-by-domain
  "Koodisto service mapping from HAKA home-organization domain name 
  to VIRTA's oppilaitos code"
  [domain]
  (if (nil? domain)
    nil
    (-> 
     (get-code-data! (str/replace domain "." "")
                     "oppilaitosdomain")
     :metadata first :nimi)))

(defn extract-metadata [body] 
  (into {} 
        (map 
         #(vector (str/lower-case (:kieli %)) (:nimi %)) 
         (:metadata body))))














