(ns kyselyynohjaus.integration.virta
  (:require
    [kyselyynohjaus.consts :refer :all]
    [kyselyynohjaus.util :refer :all]
    [config.core :refer [env]]
    [clojure.string :refer [trim join]]
    [clojure.java.data :refer [from-java]]
    [kyselyynohjaus.integration.arvo :refer [get-kaikki-oidit]]
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


(defn extract-opintosuoritukset-data
  "Note: Confusingly one opiskeluoikeudetLaajennettuTyyppi instance
  is returned with .getOpiskeluoikeudet and multiple OpiskeluoikeusTyyppis
  with getOpiskeluoikeus"
  [^OpintosuorituksetResponse opintosuoritukset-response]
  (let [results (some-> opintosuoritukset-response
                    (.getOpintosuoritukset)
                    (.getOpintosuoritus))
        opintosuoritukset (map #(from-java %) results)]
    (log/info "Saatiin Virrasta" (count opintosuoritukset) "opintosuoritusta")
    opintosuoritukset))

(defn extract-opiskeluoikeus-data
  "Note: Confusingly one opiskeluoikeudetLaajennettuTyyppi instance
  is returned with .getOpiskeluoikeudet and multiple OpiskeluoikeusTyyppis
  with getOpiskeluoikeus"
  [^OpiskeluoikeudetResponse opiskeluoikeudet-response]
  (let [results (some-> opiskeluoikeudet-response
                    (.getOpiskeluoikeudet)
                    (.getOpiskeluoikeus))
        opiskeluoikeudet (map #(from-java %) results)]
    (log/info "Saatiin Virrasta" (count opiskeluoikeudet) "opiskeluoikeutta")
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

(defn get-opintosuoritukset! [set-id-query]
  (let [service (get-ws-service)
        request (build-ws-request-from (OpintosuorituksetRequest.) set-id-query)]
    (extract-opintosuoritukset-data (.opintosuoritukset service request))))

(defn get-opiskeluoikeudet! [set-id-query]
  (let [service (get-ws-service)
        request (build-ws-request-from (OpiskeluoikeudetRequest.) set-id-query)]
    (extract-opiskeluoikeus-data (.opiskeluoikeudet service request))))

(defn get-from-virta-by-pid [person-id virta-fetcher oppilaitos]
  (log/info "Haetaan Virrasta henkilötunnuksella")
  (try
    (virta-fetcher #(do (.setHenkilotunnus % (trim person-id))
                        (.setOrganisaatio % oppilaitos)))
    (catch com.sun.xml.internal.ws.fault.ServerSOAPFaultException e
      (log/error (.getMessage e))))
  )

(defn get-from-virta-by-oid [oid virta-fetcher oppilaitos]
  (virta-fetcher #(do (.setKansallinenOppijanumero % oid)
                   (.setOrganisaatio % oppilaitos))))

(defn get-from-virta-by-oids [oid virta-fetcher oppilaitos]
  (log/info "Haetaan Virrasta oppijanumerolla")
  (let [oids (get-kaikki-oidit oid)]
    (try-until not-empty
               (map #(fn [] (get-from-virta-by-oid % virta-fetcher oppilaitos)) oids))))

(defn get-from-virta-with [virta-fetcher oppilaitos user-data]
  (match [user-data]
         [{:learner-id lid}]
         (get-from-virta-by-oids lid virta-fetcher oppilaitos)
         [{:national-identification-number nin}]
         (get-from-virta-by-pid nin virta-fetcher oppilaitos)
         [{:unique-id uid}]
         (get-from-virta-by-pid (extract-hetu-from-shibbo uid) virta-fetcher oppilaitos)
         :else nil))

(defn get-from-virta-with-retry [virta-fetcher user-data oppilaitos]
  (let [fetch-with #(get-from-virta-with virta-fetcher oppilaitos (select-keys user-data [%]))]
    (try-until not-empty
      [#(fetch-with :learner-id)
       #(fetch-with :national-identification-number)
       #(fetch-with :unique-id)])))

(defn get-virta-suoritukset [user-data oppilaitos]
  (get-from-virta-with-retry get-opintosuoritukset! user-data oppilaitos))

(defn get-virta-opiskeluoikeudet [user-data oppilaitos]
  (get-from-virta-with-retry get-opiskeluoikeudet! user-data oppilaitos))
