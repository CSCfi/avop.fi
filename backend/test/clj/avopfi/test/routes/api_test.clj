(ns avopfi.test.routes.api-test
  (:require [config.core :refer [env]]
            [avopfi.consts :refer :all]
            [clojure.test :refer :all]
            [avopfi.routes.api :refer :all]
            [avopfi.integration.opintopolku :as op]
            [avopfi.integration.arvo :as arvo]
            [avopfi.db.core :as db]
            [avopfi.test.fixtures :refer :all]
            [avopfi.integration.virta :as virta]
            [avopfi.db.migrations :as migrations]))

;(deftest opiskeluoikeudet-mapping
;  (testing "Converts raw opiskeluoikeus data to proper JSON structure"
;    (with-redefs [has-organization? (fn [x y] (= "yliopisto.fi" x))
;                  virta/select-active-timespan (constantly {:loppuPvm nil})
;                  virta/conclude-study-type (constantly 0)
;                  op/extract-metadata (constantly {:fi "suomeksi" :sv "ruotsiksi"})
;                  op/get-kunta-data (constantly nil)
;                  op/get-koulutus-data (constantly nil)
;                  op/get-oppilaitos-data (constantly nil)]
;      (let [json (opiskeluoikeus->ui-map (first amk-opiskeluoikeus-fixture))]
;        (is (= (json :opiskeluoikeustyyppi) "1"))))))


;(deftest process-registrations
;  (testing "registration works"
;    (with-redefs
;      ;;does not hit Arvo nor db atm
;      [
;       arvo/generate-questionnaire-credentials! (constantly "FOO")
;       db/get-visitor-by-srid (constantly nil)
;       db/create-visitor! (constantly nil)]
;
;      (let [attribs {:body-params {:opiskeluoikeus_id "avopOa1" :kieli "fi"}}]
;        :session {:opiskeluoikeudet-data [opiskeluoikeus-data-fixture]}
;        (is (= (str (:arvo-answer-url env) "FOO/fi") (:kysely_url (:body (process-registration attribs)))))))))













