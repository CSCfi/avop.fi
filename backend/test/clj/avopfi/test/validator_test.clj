(ns avopfi.test.validator-test
  (:require [clojure.test :refer :all]
            [avopfi.test.fixtures :refer :all]
            [avopfi.validator :refer :all]
            [clojure.core.match :refer [match]]
            [java-time :as t]))

(defn valid? [v]
  (= :valid (:status v)))

(defn invalid? [v]
  (if (nil? v)
    false
    (complement valid?)))

(defn pvm [date] {:year (t/as date :year)
                  :month (t/as date :month-of-year)
                  :day (t/as date :day-of-month)})

(def lastYear (t/minus (t/local-date) (t/years 1)))

(defn has-error [results message]
  (some #(= message %) (-> results :invalid first :messages)))

(deftest opiskeluoikeus-type
  (testing "Opiskeluoikeus with valid type is valid"
    (let [results (validate amk-opiskeluoikeus-fixture attainments-fixture "10065" :avop)]
      (is (-> results :valid first valid?))))
  (testing "AMK opiskeluoikeus is invalid and not included when using Kandipalaute"
    (let [results (validate amk-opiskeluoikeus-fixture attainments-fixture "10065" :kandi)]
      (is (and (empty? (:invalid results))
               (empty? (:valid results)))))))

(deftest opiskeluoikeus-laajuus
  (testing "AMK opiskeluoikeus with nonzero laajuus is valid"
    (let [results (validate amk-opiskeluoikeus-fixture attainments-fixture "10065" :avop)]
      (is (-> results :valid first valid?))))
  (testing "AMK opiskeluoikeus with zero laajuus is invalid"
    (let [zero-laajuus-fixture (map #(assoc-in % [:laajuus :opintopiste] 0) amk-opiskeluoikeus-fixture)
          results (validate zero-laajuus-fixture attainments-fixture "10065" :avop)]
      (is (-> results first invalid?))
      (is (has-error results :invalid-laajuus))))
  (testing "AMK opiskeluoikeus with missing laajuus is invalid"
    (let [zero-laajuus-fixture (map #(dissoc % :laajuus) amk-opiskeluoikeus-fixture)
          results (validate zero-laajuus-fixture attainments-fixture "10065" :avop)]
      (is (-> results first invalid?))
      (is (has-error results :invalid-laajuus)))))

(deftest opiskeluoikeus-organization
  (testing "Opiskeluoikeus from non matching domain is invalid and not included"
    (let [results (validate amk-opiskeluoikeus-fixture attainments-fixture "1234" :avop)]
      (is (empty? (:invalid results))))))

(deftest opiskeluoikeus-opintosuoritus
  (testing "AMK opiskeluoikeus with not enough opintosuoritus is invalid"
    (let [results (validate amk-opiskeluoikeus-fixture limited-attainments-fixture "10065" :avop)]
      (is (-> results :invalid first invalid?))
      (is (has-error results :not-enough-opintosuoritus)))))

(deftest opiskeluoikeus-date
  (testing "AMK opiskeluoikeus with expired loppuPvm is invalid"
    (let [expired-opiskeluoikeus-fixture (map #(assoc % :loppuPvm (pvm lastYear)) amk-opiskeluoikeus-fixture)
          results (validate expired-opiskeluoikeus-fixture attainments-fixture "10065" :avop)]
      (is (-> results :invalid first invalid?))
      (is (has-error results :invalid-date))))
  (testing "AMK opiskeluoikeus with future loppuPvm is valid"
    (let [nextYear (t/plus (t/local-date) (t/years 1))
          valid-opiskeluoikeus (map #(assoc % :loppuPvm (pvm nextYear)) amk-opiskeluoikeus-fixture)
          results (validate valid-opiskeluoikeus attainments-fixture "10065" :avop)]
      (is (-> results :valid first valid?))))
  (testing "AMK opiskeluoikeus with missing loppuPvm is valid"
    (let [no-loppupvm-fixture (map #(dissoc % :loppuPvm) amk-opiskeluoikeus-fixture)
          results (validate no-loppupvm-fixture attainments-fixture "10065" :avop)]
      (is (-> results :valid first valid?)))))


(deftest opiskeluoikeus-kandi
  (testing "Kandipalaute opiskeluoikeus is invalid if it doesn't have opintosuoritus for kandi"
    (let [results (validate kandi-opiskeluoikeus-fixture kandi-attainments-without-tutkinto-or-points "1234" :kandi)]
      (is (-> results :invalid first invalid?))
      (is (has-error results :no-kandi))))
  (testing "Kandipalaute opiskeluoikeus is valid if it has opintosuoritus for kandi"
    (let [results (validate kandi-opiskeluoikeus-fixture kandi-attainments-fixture "1234" :kandi)]
      (is (-> results :valid first valid?)))))

(deftest opiskeluoikeus-active
  (testing "Kandipalaute opiskeluoikeus is invalid if licensiate opiskeluoikeus is not active"
    (let [expired-state-ll-fixture (map #(assoc-in % [:tila 0 :loppuPvm] (pvm lastYear)) kandi-ll-opiskeluoikeus-fixture)
          results (validate expired-state-ll-fixture attainments-fixture "1234" :kandi)]
      (is (-> results :invalid first invalid?))
      (is (has-error results :no-patevyys)))))

(deftest jakso-active
  (testing "Kandipalaute opiskeluoikeus is invalid if licensiate jakso is not active"
    (let [expired-jakso-ll-fixture (map #(assoc-in % [:jakso 0 :loppuPvm] (pvm lastYear)) kandi-ll-opiskeluoikeus-fixture)
          results (validate expired-jakso-ll-fixture attainments-fixture "1234" :kandi)]
      (is (-> results :invalid first invalid?)))))

(deftest has-patevyys
  (testing "Kandipalaute opiskeluoikeus is invalid if tavoite is licensiate and no patevyys is found"
    (let [results (validate kandi-ll-opiskeluoikeus-fixture attainments-fixture "1234" :kandi)]
      (is (-> results :invalid first invalid?))
      (is (has-error results :no-patevyys)))))

(deftest licensiate-target
  (testing "Kandipalaute opiskeluoikeus is invalid if licensiate opintooikeus has no target or opintosuoritus for kandi"
    (let [kandi-ll-opiskeluoikeus-without-target (map #(update-in % [:jakso 0] dissoc :koulutuskoodi) kandi-ll-opiskeluoikeus-fixture)
          kandi-ll-attainments-without-kandi (filter #(not= "1" (:laji %)) kandi-ll-attainments)
          results (validate kandi-ll-opiskeluoikeus-without-target kandi-ll-attainments-without-kandi "1234" :kandi)]
      (is (-> results :invalid first invalid?))
      (is (has-error results :no-kandi)))))


