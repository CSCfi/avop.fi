(ns avopfi.validator
  (:require [avopfi.util :refer :all]
            [avopfi.consts :refer :all]
            [avopfi.db.core :as db]
            [clojure.core.match :refer :all]
            [clojure.tools.logging :as log]))


(def valvira-virheet [:no-patevyys :invalid-date :invalid-type])

(def kandi-virheet [:not-enough-opintosuoritus :not-enough-lukukausi :no-kandi :not-active :invalid-date :invalid-type])

(def valid {:status :valid})

(defn invalid [msg]
  {:status :invalid :message msg})

(def ignored-errors [:invalid-organization :no-jakso])

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

(defn tila-active? [tila]
  (let [active (= "1" (:koodi tila))
        alku-valid (in-past? (:alkuPvm tila))
        loppu-valid (or (nil? (:loppuPvm tila)) (in-future? (:loppuPvm tila)))]
    (and active alku-valid loppu-valid)))

(defn is-active? [opiskeluoikeus]
  (if (some tila-active? (:tila opiskeluoikeus))
    valid
    (invalid :not-active)))

(defn jakso-active? [jakso]
  (let [alku-valid (and (not-nil? (:alkuPvm jakso)) (in-past? (:alkuPvm jakso)))
        loppu-valid (or (nil? (:loppuPvm jakso)) (in-future? (:loppuPvm jakso)))]
    (and alku-valid loppu-valid)))

(defn jakso-valid? [opiskeluoikeus]
  (if (empty? (:jakso opiskeluoikeus))(invalid :no-jakso) valid))

(defn date-valid? [opiskeluoikeus]
  (let [alku (:alkuPvm opiskeluoikeus)
        loppu (:loppuPvm opiskeluoikeus)]
    (if (and (in-past? alku) (or (nil? loppu) (in-future? loppu)))
      valid
      (invalid :invalid-date))))

(defn check-opintosuoritukset [oo-tyyppi pisteet laajuus]
  (let [vaaditut-pisteet (get tutkintoon-vaaditut-pisteet oo-tyyppi)]
    (if (and (not-nil? vaaditut-pisteet) (< 0 vaaditut-pisteet))
      (>= (vals->pct pisteet (float laajuus)) vaaditut-pisteet)
      false)))


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

(defn all-of [vaatimukset opiskeluoikeus]
  (let [v (apply juxt vaatimukset)
        result (v opiskeluoikeus)]
    (if (some #(= :invalid (:status %)) result)
      result
      valid)))

(defn one-of [vaatimukset opiskeluoikeus]
  (let [v (apply juxt vaatimukset)
        result (v opiskeluoikeus)]
    (if (some #(= :valid (:status %)) result)
      valid
      result)))

(defn sisaltyvyydet [virta-suoritukset suoritus]
  (if (empty? (:sisaltyvyys suoritus))
    (:avain suoritus)
    (let [sisaltyvat-koodit (map :sisaltyvaOpintosuoritusAvain (:sisaltyvyys suoritus))
          sisaltyvat-suoritukset (filter #(in? sisaltyvat-koodit (:avain %)) virta-suoritukset)]
      (map (partial sisaltyvyydet virta-suoritukset) sisaltyvat-suoritukset))))


(defn lehti-suoritus? [suoritus]
  (and (= (:laji suoritus) "2") (empty? (:sisaltyvyys suoritus))))

(defn has-160op [virta-suoritukset opiskeluoikeus]
  (let [lehti-suoritukset (->> virta-suoritukset
                               (filter lehti-suoritus?)
                               (filter #(= (:myontaja opiskeluoikeus) (:myontaja %))))
        tutkinnot (->> virta-suoritukset (filter #(= "1" (:laji %))))
        tutkintoon-sisaltyvat (mapcat (partial sisaltyvyydet virta-suoritukset) tutkinnot)
        hyvaksyttavat (filter #(not(in? tutkintoon-sisaltyvat (:avain %))) lehti-suoritukset)
        yhteispisteet (->> hyvaksyttavat
                           (map #(-> % :laajuus :opintopiste))
                           (reduce +))]
    (if (and (= alempi-korkeakoulututkinto (:tyyppi opiskeluoikeus))(<= 160 yhteispisteet))
      valid
      (invalid :not-enough-opintosuoritus))))

(defn get-alkupvm [opiskeluoikeus]
  (let [alkuPvm (:alkuPvm opiskeluoikeus)
        siirtoPvm (-> opiskeluoikeus :siirtoOpiskelija :siirtoPvm)]
    (if (nil? siirtoPvm)
      (if (nil? alkuPvm) {:year 1970 :month 1 :day 1} alkuPvm)
      (earlier alkuPvm siirtoPvm))))

(defn get-loppupvm [opiskeluoikeus]
  (let [loppuPvm (:loppuPvm opiskeluoikeus)]
    (if (in-past? loppuPvm)
      loppuPvm
      (local-date-map))))

(defn has-enough-lukukausi [opiskeluoikeus]
  (let [alkuPvm (get-alkupvm opiskeluoikeus)
        loppuPvm (get-loppupvm opiskeluoikeus)
        vuodet (- (:year loppuPvm) (:year alkuPvm))
        taysiVuosi (< (:month alkuPvm) (:month loppuPvm))
        alku-loppu-kausi (and (< (:month alkuPvm) 8) (>= (:month loppuPvm) 8))
        lukukaudet (+ (* vuodet 2) (if taysiVuosi 1 0) (if alku-loppu-kausi 1 0))]
    (if (>= lukukaudet 4)
      valid
      (invalid :not-enough-lukukausi))))

(defn has-kandi-suoritukset [virta-suoritukset]
  (partial all-of[date-valid?
                  is-active?
                  (partial has-160op virta-suoritukset)
                  (partial has-enough-lukukausi)]))


(defn has-kandi [virta-suoritukset {oo-tyyppi :tyyppi oo-avain :avain}]
  (let [has-tutkinto (some #(and
                             (= (:opiskeluoikeusAvain %) oo-avain)
                             (= (:laji %) opintosuoritus-tutkinto)) virta-suoritukset)
        is-kandi (= alempi-korkeakoulututkinto oo-tyyppi)]
    (if (and is-kandi has-tutkinto)
      valid
      (invalid :no-kandi))))

(defn amk-vaatimukset [virta-suoritukset home-org]
  (juxt (partial has-type? [amk-alempi-tyyppi amk-ylempi-tyyppi])
        (partial has-organization? home-org)
        date-valid?
        laajuus-valid?
        (partial has-enough-opintosuoritus? virta-suoritukset)))

(defn has-patevyys? [virta-suoritukset opiskeluoikeus]
  (let [aktiiviset-jaksot (filter jakso-active? (:jakso opiskeluoikeus))
        koulutuskoodit (map :koulutuskoodi aktiiviset-jaksot)
        hyvaksytyt-patevyydet (remove nil? (map #(get tutkinto-patevyys %) koulutuskoodit))
        patevyydet (mapcat :patevyys virta-suoritukset)]
    (if (some #(in? hyvaksytyt-patevyydet %) patevyydet)
      valid
      (invalid :no-patevyys))))

(defn lisensiaatti? [opiskeluoikeus]
  (let [aktiiviset-jaksot (filter jakso-active? (:jakso opiskeluoikeus))
        koulutuskoodit (map :koulutuskoodi aktiiviset-jaksot)]
    (some #(in? laakis-koodit %) koulutuskoodit)))

(defn is-lisensiaatti? [opiskeluoikeus]
  (if (lisensiaatti? opiskeluoikeus)
    valid
    (invalid :not-lisensiaatti)))

(defn valvira-vaatimukset [virta-suoritukset home-org]
  (partial all-of [(partial is-lisensiaatti?)
                   (partial has-type? [ylempi-korkeakoulututkinto])
                   (partial has-organization? home-org)
                   is-active?
                   (partial has-patevyys? virta-suoritukset)]))


(defn kandipalaute-vaatimukset [virta-suoritukset home-organization]
  (partial one-of [(partial has-kandi virta-suoritukset)
                   (has-kandi-suoritukset virta-suoritukset)
                   (valvira-vaatimukset virta-suoritukset home-organization)]))

(defn common-vaatimukset [opiskeluoikeus]
  (jakso-valid?  opiskeluoikeus))


(defn vaatimukset [tyyppi virta-suoritukset home-organization]
  (let [tyyppi-vaatimukset (match [tyyppi]
                            [:avop] (amk-vaatimukset virta-suoritukset home-organization)
                            [:kandi] (kandipalaute-vaatimukset virta-suoritukset home-organization))]
    (partial all-of [common-vaatimukset
                     tyyppi-vaatimukset])))

(defn oo-tyypit [tyyppi]
  (tyyppi {:avop  [amk-alempi-tyyppi amk-ylempi-tyyppi]
           :kandi [alempi-korkeakoulututkinto ylempi-korkeakoulututkinto]}))

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

(defn filter-messages [processed-oikeus]
  (let [msgs (:messages processed-oikeus)
        oikeus (:oikeus processed-oikeus)
        msg-order (if (lisensiaatti? oikeus) valvira-virheet kandi-virheet)]
    (assoc processed-oikeus :messages (filter #(in? msgs %) msg-order))))

(defn process-messages [tyyppi grouped]
  (if (= tyyppi :kandi)
    (update-in grouped [:invalid] #(map filter-messages %))
    grouped))

(defn validate [virta-oikeudet virta-suoritukset home-organization tyyppi]
  (let [oikeudet (filter #(in? (oo-tyypit tyyppi) (:tyyppi % ))virta-oikeudet)
        process (fn [oikeus]
                  (let [vaatimukset (vaatimukset tyyppi virta-suoritukset home-organization)]
                    (->> (vaatimukset oikeus)
                      (flatten)
                      (reduce merge-results {:status :valid :messages []})
                      (merge {:oikeus oikeus}))))
        results (->> oikeudet
                     (map process)
                     (group-by :status))
        final-results (process-messages tyyppi (remove-ignored results))]
    (log-validation-results results)
    final-results))