(ns avopfi.test.util_test
  (:use
    [clojure.test :refer :all]
    [avopfi.util]))

(deftest test-try-until
  (testing "Retry returns first answer filling the condition"
    (let [fs [#(identity {}) #(identity {:first 1}) #(identity {:second 2})]
          res (try-until seq fs)]
      (is (contains? res :first)))))
