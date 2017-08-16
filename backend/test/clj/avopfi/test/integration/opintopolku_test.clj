(ns avopfi.test.integration.opintopolku-test
  (:use
    [clojure.test :refer :all]
    [avopfi.integration.opintopolku]))

(deftest ^:integration op-integrations
  (testing "Gets some kind of stuff"
    (is (not (nil? (get-koulutus-data "321902"))))))
