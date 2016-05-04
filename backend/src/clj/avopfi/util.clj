(ns avopfi.util
  (:require
    [java-time :refer [local-date]]))

(defn to-local-date [date-map]
  (local-date (:year date-map) (:month date-map) (:day date-map)))

(defn is-date-expired? [date-map]
  (.isBefore (local-date) (to-local-date date-map)))
