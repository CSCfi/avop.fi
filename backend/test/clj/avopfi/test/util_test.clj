(ns avopfi.test.util_test
  (:use
    [clojure.test :refer :all]
    [avopfi.util]))

(deftest test-retry
  (testing "Retry returns first answer filling the condition"
    (let [args [{} {:first 1} {:second 2}]
          res (retry identity seq args)]
      (is (contains? res :first)))))
