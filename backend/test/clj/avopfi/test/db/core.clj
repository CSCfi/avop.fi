(ns avopfi.test.db.core
  (:require [avopfi.db.core :refer [*db*] :as db]
            [avopfi.db.migrations :as migrations]
            [clojure.test :refer :all]
            [clojure.java.jdbc :as jdbc]
            [clojure.core.match :refer [match]]
            [config.core :refer [env]]
            [mount.core :as mount]))

(comment 
  (use-fixtures
    :once
    (fn [f]
      (mount/start #'avopfi.db.core/*db*)
      (migrations/migrate ["migrate"])
      (f)))

  (deftest ^:integration test-users
    (jdbc/with-db-transaction [t-conn *db*]
      (jdbc/db-set-rollback-only! t-conn)
      (is (= 1 (db/create-visitor!
                t-conn
                {:study_right_id "foo" :arvo_answer_hash "XXX"})))
      (is (match
           (db/get-visitor-by-srid t-conn {:study_right_id "foo"})
           {:study_right_id "foo" :arvo_answer_hash "XXX"} true)))))

