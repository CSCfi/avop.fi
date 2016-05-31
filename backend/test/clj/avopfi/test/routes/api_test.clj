(ns avopfi.test.routes.api-test
  (:require [config.core :refer [env]]
            [avopfi.consts :refer :all]
            [clojure.test :refer :all]
            [avopfi.routes.api :refer :all]
            [avopfi.integration.opintopolku :as op]
            [avopfi.integration.arvo :as arvo]
            [avopfi.db.core :as db]
            [avopfi.test.fixtures :refer [opiskeluoikeus-data-fixture]]
            [avopfi.integration.virta :as virta]
            [avopfi.db.migrations :as migrations]))

(def study-rights-fixture [{:avain "FOO"
                            :myontaja "123"
                            :laajuus {:opintopiste 235}
                            :jakso {
                                    :luokittelu ["3"]
                                    }
                            :tyyppi 1
                            }])
(def attainments-fixture [
                          {:opiskeluoikeusAvain "FOO" :laji "2" :sisaltyvyys [] :laajuus {:opintopiste 100}}
                          {:opiskeluoikeusAvain "FOO" :laji "2" :sisaltyvyys [] :laajuus {:opintopiste 90}}
                          ])

(deftest study-credit-checks
  (testing "Checking VIRTA study credits when there's enough credits"
    (with-redefs [opintopisteet-amk-alempi-min-pct 80]
      (is (has-enough-opintosuoritus? attainments-fixture (first study-rights-fixture)))))
  (testing "Checking VIRTA study credits when there's not enough credits"
    (is (not (has-enough-opintosuoritus? (rest attainments-fixture) (first study-rights-fixture))))))

(deftest filtering-rights
  (testing "Filters rights"
    (let [results (filter-oikeudet study-rights-fixture attainments-fixture "yliopisto.fi")]
      (is (= (:id results) (-> study-rights-fixture :avain)))
      (is (= (:type results) (-> study-rights-fixture :avain))))))

(deftest filter-missing-laajuus
  (testing "Checking that rights with missing laajuus are filtered"
    (let [missing-laajuus-fixture (map #(dissoc % :laajuus )study-rights-fixture )
          results (filter-oikeudet missing-laajuus-fixture attainments-fixture "yliopisto.fi")]
         (is (empty? results)))))

(deftest filter-zero-laajuus
  (testing "Checking that rights with zero laajuus are filtered"
    (let [zero-laajuus-fixture (map #(assoc % :laajuus 0) study-rights-fixture )
          results (filter-oikeudet zero-laajuus-fixture attainments-fixture "yliopisto.fi")]
      (is (empty? results)))))

(deftest opiskeluoikeudet-mapping
  (testing "Converts raw opiskeluoikeus data to proper JSON structure"
    (with-redefs [has-organization? (fn [x y] (= "yliopisto.fi" x))
                  virta/select-active-timespan (constantly {:loppuPvm nil})
                  virta/conclude-study-type (constantly 0)
                  op/extract-metadata (constantly {:fi "suomeksi" :sv "ruotsiksi"})
                  op/get-kunta-data (constantly nil)
                  op/get-koulutus-data (constantly nil)
                  op/get-oppilaitos-data (constantly nil)]
      (let [json (opiskeluoikeus->ui-map (first study-rights-fixture))]
        (is (= (json :opiskeluoikeustyyppi) 1))))))

;;(use-fixtures :once (fn [f] (migrations/migrate ["migrate"]) (f)))

(deftest process-registrations 
  (testing "registration works"
    (with-redefs
      ;;does not hit Arvo nor db atm
      [
        arvo/generate-questionnaire-credentials! (constantly "FOO")
        db/get-visitor-by-srid (constantly nil)
        db/create-visitor! (constantly nil)
      ]
      (let [attribs {:body-params {:opiskeluoikeus_id "avopOa1" :kieli "fi"}
        :session {:opiskeluoikeudet-data [opiskeluoikeus-data-fixture]}}]
        (is (= (:kysely_url (:body (process-registration attribs))) (str (:arvo-answer-url env) "FOO")))))))













