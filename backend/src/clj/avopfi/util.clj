(ns avopfi.util
  (:require
    [java-time :refer [local-date]]
    [clojure.tools.logging :as log]))

(def not-nil? (complement nil?))

(defn to-local-date [date-map]
  (local-date (:year date-map) (:month date-map) (:day date-map)))

(defn to-date-map [date]
  {:year (.getYear date)
   :month (.getMonthValue date)
   :day (.getDayOfMonth date)})

(defn local-date-map []
  (to-date-map (local-date)))

(defn earlier [date_a date_b]
  (let [a (to-local-date date_a)
        b (to-local-date date_b)]
    (if (.isBefore (to-local-date a) (to-local-date b)) date_a date_b)))


(defn in-future? [date-map]
  (if (nil? date-map)
    false
    (or
      (.isBefore (local-date) (to-local-date date-map))
      (.isEqual (local-date) (to-local-date date-map)))))

(defn in-past? [date-map]
  (if (nil? date-map)
    false
    (or
      (.isAfter (local-date) (to-local-date date-map))
      (.isEqual (local-date) (to-local-date date-map)))))

(defn in? [coll elem]
  (some #(= elem %) coll))

(defn retry [f cond args]
  (when (seq args)
    (let [res (f (first args))]
      (if (cond res)
        res
        (retry f cond (rest args))))))