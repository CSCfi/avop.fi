(ns kyselyynohjaus.config
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[kyselyynohjaus started successfully]=-"))
   :middleware identity})
