(ns avopfi.validator
  (:require [avopfi.util :refer :all]
            [avopfi.consts :refer :all]
            [avopfi.db.core :as db]
            [clojure.core.match :refer :all]
            [clojure.tools.logging :as log]))


(def valid {:status :valid})

(defn invalid [msg]
  {:status :invalid :message msg})

(def ignored-errors [:invalid-type :invalid-organization])

(defn vals->pct [f s]
  (int (* (/ f s) 100)))

(defn get-oppilaitos-code-by-domain [domain]
  (let [mapping (db/get-mapping-by-domain {:domain domain})]
    (:code mapping)))

(defn has-type? [types opiskeluoikeus]
  (if (in? types (:tyyppi opiskeluoikeus))
    valid
    (invalid :invalid-type)))

(defn laajuus-valid? [opiskeluoikeus]
  (if (< 0 (get-in opiskeluoikeus [:laajuus :opintopiste] 0))
    valid
    (invalid :invalid-laajuus)))

(defn has-organization? [home-organization {org-koodi :myontaja}]
  (let
    [code (get-oppilaitos-code-by-domain home-organization)]
    (if (= code org-koodi)
      valid
      (invalid :invalid-organization))))

(defn is-active? [{tila :tila}]
  (let [active (= "1" (:koodi tila))
        alku-valid (in-past? (:alkuPvm tila))
        loppu-valid (or (nil? (:loppuPvm tila)) (in-future? (:loppuPvm tila)))]
    (if (and active alku-valid loppu-valid)
      valid
      (invalid :not-active))))

(defn jakso-active? [{jakso :jakso}]
  (let [alku-valid (and (not-nil? (:alkuPvm jakso)) (in-past? (:alkuPvm jakso)))
        loppu-valid (or (nil? (:loppuPvm jakso))(in-future? (:loppuPvm jakso)))]
    (if( and alku-valid loppu-valid)
      valid
      (invalid :jakso-invalid))))

(defn has-patevyys? [virta-suoritukset opiskeluoikeus]
  (if (some #(in? [laaketieteen-lisensiaatti hammaslaaketieteen-lisensiaatti] (:patevyys %)) virta-suoritukset)
    valid
    (invalid :no-patevyys)))

(defn date-valid? [opiskeluoikeus]
  (let [loppu (:loppuPvm opiskeluoikeus)]
    (if (or (nil? loppu) (in-future? loppu))
      valid
      (invalid :invalid-date))))

(defn check-opintosuoritukset [oo-tyyppi pisteet laajuus]
  (>= (vals->pct pisteet (float laajuus)) (get tutkintoon-vaaditut-pisteet oo-tyyppi)))

(defn has-enough-opintosuoritus? [virta-suoritukset {oo-tyyppi :tyyppi oo-avain :avain
                                                     {oo-laajuus :opintopiste} :laajuus}]
  (let [pisteet
        (->> virta-suoritukset
             (filter #(and
                       (= (:opiskeluoikeusAvain %) oo-avain)
                       (= (:laji %) opintosuoritus-muu-laji)
                       (empty? (:sisaltyvyys %))))
             (reduce #(+ %1 (int (-> %2 :laajuus :opintopiste))) 0))]
    (if (and (not-nil? oo-laajuus)
             (> oo-laajuus 0)
             (check-opintosuoritukset oo-tyyppi pisteet oo-laajuus))
      valid
      (invalid :not-enough-opintosuoritus))))

(defn has-kandi? [virta-suoritukset {oo-tyyppi :tyyppi oo-avain :avain}]
  (let [has-tutkinto (some #(and
                             (= (:opiskeluoikeusAvain %) oo-avain)
                             (= (:laji %) opintosuoritus-tutkinto)) virta-suoritukset)
        is-kandi (= "2" oo-tyyppi)]
    (if (and is-kandi has-tutkinto)
      valid
      (invalid :no-kandi))))

(defn amk-vaatimukset [virta-suoritukset home-org]
  (juxt (partial has-type? [amk-alempi-tyyppi amk-ylempi-tyyppi])
        (partial has-organization? home-org)
        date-valid?
        laajuus-valid?
        (partial has-enough-opintosuoritus? virta-suoritukset)))

(defn kandi-vaatimukset [virta-suoritukset home-org]
  (juxt (partial has-type? [alempi-korkeakoulututkinto])
        (partial has-organization? home-org)
        (partial has-kandi? virta-suoritukset)))

(defn valvira-vaatimukest [virta-suoritukset home-org]
  (juxt
    (partial has-type? [alempi-korkeakoulututkinto ylempi-korkeakoulututkinto])
    (partial has-organization? home-org)
    is-active?
    jakso-active?
    (partial has-patevyys? virta-suoritukset)))



(defn vaatimukset [tyyppi opiskeluoikeus]
  (tyyppi {:avop amk-vaatimukset
           :kandi (let [tavoitetutkinto (-> opiskeluoikeus :jakso :koulutuskoodi)]
                    (if (in? lisensiaatti-tutkinnot tavoitetutkinto)
                      valvira-vaatimukest
                      kandi-vaatimukset))}))

(defn format-errors [oikeus]
  (str ((:messages oikeus))))

(defn log-validation-results [results]
  (let [format-oikeus (fn [oikeus] (str (-> oikeus :oikeus :myontaja ) " - " (-> oikeus :oikeus :avain)))]
    (log/info "Löytyi" (-> results :valid count) "validia oikeutta: " (apply str (interpose "," (map format-oikeus (:valid results)))))
    (log/info (-> results :invalid count) "oikeutta hylätty" (apply str (interpose "," (map #(str (format-oikeus %) " : " (:messages %))(:invalid results)))))))

(defn merge-results [acc result]
  (match [(:status result) (:message result)]
         [:valid _] acc
         [:invalid msg] {:status :invalid :messages (conj (:messages acc) msg)}))

(defn ignore? [processed-oikeus] (not(some #(in? ignored-errors %) (:messages processed-oikeus))))
(defn remove-ignored [grouped]
  (update grouped :invalid #(filter ignore? %)))

(defn validate [virta-oikeudet virta-suoritukset home-organization tyyppi]
  (let [process (fn [oikeus]
                  (let [vaatimukset ((vaatimukset tyyppi oikeus) virta-suoritukset home-organization)]
                    (->> (vaatimukset oikeus)
                      (reduce merge-results {:status :valid :messages []})
                      (merge {:oikeus oikeus}))))
        results (->> virta-oikeudet
                     (map process)
                     (group-by :status))
        final-results (remove-ignored results)]
    (log-validation-results results)
    final-results))