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

#(let [loppu (:loppuPvm %)] (or (nil? loppu) (is-date-valid? loppu)))

(defn date-valid? [opiskeluoikeus]
  (let [loppu (:loppuPvm opiskeluoikeus)]
    (if (or (nil? loppu) (is-date-valid? loppu))
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

(defn vaatimukset [tyyppi]
  (tyyppi {:avop amk-vaatimukset
           :kandi kandi-vaatimukset}))

(defn merge-results [acc result]
  (match [(:status result) (:message result)]
         [:valid _] acc
         [:invalid msg] {:status :invalid :messages (conj (:messages acc) msg)}))

(defn ignore? [processed-oikeus] (not(some #(in? ignored-errors %) (:messages processed-oikeus))))


(defn validate [virta-oikeudet virta-suoritukset home-organization tyyppi]
  (let [vaatimukset ((vaatimukset tyyppi) virta-suoritukset home-organization)
        process (fn [oikeus]
                  (->> (vaatimukset oikeus)
                       (reduce merge-results {:status :valid :messages []})
                       (merge {:oikeus oikeus})))
        results (->> virta-oikeudet
                     (map process))]
    results))