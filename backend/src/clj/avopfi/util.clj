(ns avopfi.util
  (:require
    [java-time :refer [local-date]]))

(def not-nil? (complement nil?))

(defn to-local-date [date-map]
  (local-date (:year date-map) (:month date-map) (:day date-map)))

(defn is-date-valid? [date-map]
  (or
    (.isBefore (local-date) (to-local-date date-map))
    (.isEqual (local-date) (to-local-date date-map))))

(defn in? [coll elem]
  (some #(= elem %) coll))

(defn retry [f cond args]
  (when (seq args)
    (let [res (f (first args))]
      (if (cond res)
        res
        (retry f cond (rest args))))))