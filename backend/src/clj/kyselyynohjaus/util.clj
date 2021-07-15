(ns kyselyynohjaus.util
  (:require
    [java-time :refer [local-date]]
    [cats.monad.either :as either]
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
    (if (.isBefore a b) date_a date_b)))

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

(defn after? [compared-date-map date-map]
  (and (some? date-map)
       (.isAfter (to-local-date date-map) (to-local-date compared-date-map))))

(defn in? [coll elem]
  (some #(= elem %) coll))

(defn deprefixize [p m]
  (into {}
        (map #(vector
               (clojure.string/replace (first %) p "") (second %)) m)))

(defmacro try-or [err-type & exprs]
  `(try
     (either/right (do ~@exprs))
     (catch Exception ex#
       (log/error ~err-type ex#)
       (either/left ~err-type))))

(defn try-until [pred fs]
  (when (seq fs)
    (let [f (first fs)
          res (f)]
      (if (pred res)
        res
        (try-until pred (rest fs))))))
