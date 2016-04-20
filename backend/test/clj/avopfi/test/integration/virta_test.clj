(ns avopfi.test.integration.virta-test
  (:use
    [clojure.test :refer :all]
    [avopfi.integration.virta])
  (:require [config.core :refer [env]]))

(deftest conclude-study-types
  (testing "Concludes study type as 1"
    (is (= (conclude-study-type "1" ["3"]) 1)))
  (testing "Concludes study type as 0"
    (is (= (conclude-study-type "1" ["2"]) 0))))

(deftest timespans
   (testing "Timespan having no loppuPvm is selected"
     (let [timespans [{:loppuPvm nil}
                      {:loppuPvm {:year 2015 :month 12 :day 1}}]]
       (is (= (select-active-timespan timespans) {:loppuPvm nil})))))
