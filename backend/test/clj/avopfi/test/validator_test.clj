(ns avopfi.test.validator-test
  (:require [clojure.test :refer :all]
            [avopfi.test.fixtures :refer :all]
            [avopfi.validator :refer :all]
            [clojure.core.match :refer [match]]
            [java-time :as t]))

(defn valid? [v]
  (= :valid (:status v)))

(defn invalid? [v] (complement valid?))

(defn inv-reason [reason v]
  (println "inv-reason " reason)
  (and (invalid? v)
       (some #(= reason %) (:messages v))))

(defn mock-mapping [domain]
  (match [domain]
         ["yliopisto.fi"] "10065"
         [_] "1234"))

(defn pvm [date] {:year (t/as date :year)
                  :month (t/as date :month-of-year)
                  :day (t/as date :day-of-month)})

(deftest opiskeluoikeus-type
  (with-redefs [avopfi.validator/get-oppilaitos-code-by-domain mock-mapping]
    (testing "Opiskeluoikeus with valid type is valid"
      (let [results (validate amk-opiskeluoikeus-fixture attainments-fixture "yliopisto.fi" :avop)]
        (is (-> results first valid?))))
    (testing "AMK opiskeluoikeus is invalid and not included when using Kandipalaute"
      (let [results (validate amk-opiskeluoikeus-fixture attainments-fixture "yliopisto.fi" :kandi)]
        (is (empty? results))))))

(deftest opiskeluoikeus-laajuus
  (with-redefs [avopfi.validator/get-oppilaitos-code-by-domain mock-mapping]
    (testing "AMK opiskeluoikeus with nonzero laajuus is valid"
      (let [results (validate amk-opiskeluoikeus-fixture attainments-fixture "yliopisto.fi" :avop)]
        (is (-> results first valid?))))
    (testing "AMK opiskeluoikeus with zero laajuus is invalid"
      (let [zero-laajuus-fixture (map #(assoc-in % [:laajuus :opintopiste] 0) amk-opiskeluoikeus-fixture)
            results (validate zero-laajuus-fixture attainments-fixture "yliopisto.fi" :avop)]
        (is (-> results first invalid?))
        (is (some #(= :invalid-laajuus %) (-> results first :messages)))))
    (testing "AMK opiskeluoikeus with missing laajuus is invalid"
      (let [zero-laajuus-fixture (map #(dissoc % :laajuus) amk-opiskeluoikeus-fixture)
            results (validate zero-laajuus-fixture attainments-fixture "yliopisto.fi" :avop)]
        (is (-> results first invalid?))
        (is (some #(= :invalid-laajuus %) (-> results first :messages)))))))

(deftest opiskeluoikeus-organization
  (with-redefs [avopfi.validator/get-oppilaitos-code-by-domain mock-mapping]
    (testing "Opiskeluoikeus from non matching domain is invalid and not included"
      (let [results (validate amk-opiskeluoikeus-fixture attainments-fixture "otherdomain.fi" :avop)]
        (is (empty? results))))))


(deftest opiskeluoikeus-opintosuoritus
  (with-redefs [avopfi.validator/get-oppilaitos-code-by-domain mock-mapping]
    (testing "AMK opiskeluoikeus with not enough opintosuoritus is invalid"
      (let [results (validate amk-opiskeluoikeus-fixture limited-attainments-fixture "yliopisto.fi" :avop)]
        (is (-> results first invalid?))
        (is (some #(= :not-enough-opintosuoritus %) (-> results first :messages)))))))

(deftest opiskeluoikeus-date
  (with-redefs [avopfi.validator/get-oppilaitos-code-by-domain mock-mapping]
    (testing "AMK opiskeluoikeus with expired loppuPvm is invalid"
      (let [lastYear (t/minus (t/local-date) (t/years 1))
            expired-opiskeluoikeus-fixture (map #(assoc % :loppuPvm (pvm lastYear)) amk-opiskeluoikeus-fixture)
            results (validate expired-opiskeluoikeus-fixture attainments-fixture "yliopisto.fi" :avop)]
        (is (-> results first invalid?))
        (is (some #(= :invalid-date %) (-> results first :messages)))))
    (testing "AMK opiskeluoikeus with future loppuPvm is valid"
      (let [lastYear (t/plus (t/local-date) (t/years 1))
            expired-opiskeluoikeus-fixture (map #(assoc % :loppuPvm (pvm lastYear)) amk-opiskeluoikeus-fixture)
            results (validate expired-opiskeluoikeus-fixture attainments-fixture "yliopisto.fi" :avop)]
        (is (-> results first valid?))))))

(deftest opiskeluoikeus-kandi
  (with-redefs [avopfi.validator/get-oppilaitos-code-by-domain mock-mapping]
    (testing "Kandipalaute opiskeluoikeus is invalid if it doesn't have opintosuoritus for kandi"
      (let [results (validate kandi-opiskeluoikeus-fixture kandi-attainments-without-tutkinto "otherdomain.fi" :kandi)]
        (is (-> results first invalid?))
        (is (some #(= :no-kandi %) (-> results first :messages)))))
    (testing "Kandipalaute opiskeluoikeus is valid if it has opintosuoritus for kandi"
      (let [results (validate kandi-opiskeluoikeus-fixture kandi-attainments-fixture "otherdomain.fi" :kandi)]
        (println results)
        (is (-> results first valid?))))))


