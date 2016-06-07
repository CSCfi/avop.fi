(ns avopfi.integration.virta
  (:require
    [avopfi.consts :refer :all]
    [avopfi.util :refer :all]
    [config.core :refer [env]]
    [clojure.string :refer [trim join]]
    [clojure.java.data :refer [from-java]]
    [clojure.core.match :refer [match]]
    [clojure.tools.logging :as log]
    [java-time :refer [local-date]])
  (:import
    (java.net URL)
    (fi.csc.virta OpiskelijanTiedotService OpiskeluoikeudetRequest
                  OpiskeluoikeudetResponse OpintosuorituksetRequest
                  OpintosuorituksetResponse HakuEhdotOrganisaatioVapaa
                  Kutsuja)))


(defn extract-hetu-from-shibbo
  "This format of personal id is prepended by
  somethig like 'urn:schac:personalUniqueID:fi:FIC:'.
  Rude way to extract hetu is find last colon."
  [shibbo-uid]
  (subs shibbo-uid (+ (.lastIndexOf shibbo-uid (int \:)) 1)))


(defn user-id [user-data]
  (match [user-data]
         [{"learner-id" lid}] lid
         [{"national-identification-number" nin}] nin
         [{"unique-id" uid}] (extract-hetu-from-shibbo uid)
         :else nil))

(defn extract-opintosuoritukset-data
  "Note: Confusingly one opiskeluoikeudetLaajennettuTyyppi instance
  is returned with .getOpiskeluoikeudet and multiple OpiskeluoikeusTyyppis
  with getOpiskeluoikeus"
  [^OpintosuorituksetResponse opintosuoritukset-response user-data]
  (let [results (some-> opintosuoritukset-response
                    (.getOpintosuoritukset)
                    (.getOpintosuoritus))
        opintosuoritukset (map #(from-java %) results)]
    (log/info "Saatiin Virrasta" (count opintosuoritukset) "opintosuoritusta käyttäjälle" (user-id user-data))
    opintosuoritukset))

(defn extract-opiskeluoikeus-data
  "Note: Confusingly one opiskeluoikeudetLaajennettuTyyppi instance
  is returned with .getOpiskeluoikeudet and multiple OpiskeluoikeusTyyppis
  with getOpiskeluoikeus"
  [^OpiskeluoikeudetResponse opiskeluoikeudet-response user-data]
  (let [results (some-> opiskeluoikeudet-response
                    (.getOpiskeluoikeudet)
                    (.getOpiskeluoikeus))
        opiskeluoikeudet (map #(from-java %) results)]
    (log/info "Saatiin Virrasta" (count opiskeluoikeudet) "opiskeluoikeutta käyttäjälle" (user-id user-data))
    (log/info "Opiskelu-oikeudet:" (join ", " (map #(:avain %) opiskeluoikeudet)))
    opiskeluoikeudet))

(defn ^:private compare-timespans [first-timespan second-timespan]
  (let [ld1 (to-local-date (:loppuPvm first-timespan)) ld2 (to-local-date (:loppuPvm second-timespan))]
    (if (> (.compareTo ld1 ld2) 0) first-timespan second-timespan)))

(defn select-active-timespan
  [timespans]
  (let [nonending
        (reduce
         #(when (nil? (:loppuPvm %2)) (reduced %2)) nil timespans)]
    (if (nil? nonending)
      (reduce compare-timespans timespans)
      nonending)))

(defn conclude-study-type
  "If Study type 1 and luokittelu has value for aikuiskoulutus (3)
  -> Monimuoto-opiskelu 1, else -> Päiväopiskelu 0"
  [study-type luokittelu]
  (if (and (= study-type "1") (some #(= "3" %) luokittelu)) 1 0))

(defn get-caller-obj
  "Object to include VIRTA credentials in WS call"
  []
  (doto (Kutsuja.)
    (.setAvain (:virta-salaisuus env))
    (.setJarjestelma (:virta-jarjestelma env))
    (.setTunnus (:virta-tunnus env))))

(defn get-ws-service []
  (-> (OpiskelijanTiedotService. (URL. (env :virta-url)))
      (.getOpiskelijanTiedotSoap11)))

(defn build-ws-request-from [request-inst set-id-query]
  (doto request-inst
    (.setKutsuja (get-caller-obj))
    (.setHakuehdot
      (doto (HakuEhdotOrganisaatioVapaa.)
        set-id-query))))

(defn get-opintosuoritukset!
  [user-data set-id-query]
  (let [service (get-ws-service)
        request (build-ws-request-from (OpintosuorituksetRequest.) set-id-query)]
    (extract-opintosuoritukset-data (.opintosuoritukset service request) user-data)))

(defn get-opiskeluoikeudet!
  [user-data set-id-query]
  (let [service (get-ws-service)
            request (build-ws-request-from (OpiskeluoikeudetRequest.) set-id-query)]
    (extract-opiskeluoikeus-data (.opiskeluoikeudet service request) user-data)))

(defn get-from-virta-by-pid [person-id virta-fetcher]
  (log/info "Haetaan Virrasta henkilötunnuksella:" person-id)
  (virta-fetcher #(.setHenkilotunnus % (trim person-id))))

(defn get-from-virta-by-oid [oid virta-fetcher]
  (log/info "Haetaan Virrasta oppijanumerolla:" oid)
  (virta-fetcher #(.setKansallinenOppijanumero % oid)))

(defn get-from-virta-with [virta-fetcher user-data]
  (match [user-data]
         [{"learner-id" lid}]
         (get-from-virta-by-oid lid virta-fetcher)
         [{"national-identification-number" nin}]
         (get-from-virta-by-pid nin virta-fetcher)
         [{"unique-id" uid}]
         (get-from-virta-by-pid (extract-hetu-from-shibbo uid) virta-fetcher)
         :else nil))


(defn get-from-virta-with-retry [virta-fetcher user-data]
  (retry (partial get-from-virta-with virta-fetcher)
         seq
         (map #(select-keys user-data [%]) ["learner-id"
                                            "national-identification-number"
                                            "unique-id"])))
(defn get-virta-suoritukset [user-data]
  (get-from-virta-with-retry (partial get-opintosuoritukset! user-data) user-data))

(defn get-virta-opiskeluoikeudet [user-data]
  (get-from-virta-with-retry (partial get-opiskeluoikeudet! user-data) user-data))
