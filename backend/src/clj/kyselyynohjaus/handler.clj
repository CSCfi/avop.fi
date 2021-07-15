(ns kyselyynohjaus.handler
  (:require [compojure.core :refer [defroutes routes wrap-routes]]
            [kyselyynohjaus.layout :refer [error-page]]
            [kyselyynohjaus.routes.api :refer [api-routes vipunen-routes rekry-routes common-routes export-routes]]
            [kyselyynohjaus.routes.public :refer [public-routes]]
            [kyselyynohjaus.middleware :as middleware]
            [kyselyynohjaus.db.migrations :as migrations]
            [clojure.tools.logging :as log]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [config.core :refer [env]]
            [kyselyynohjaus.config :refer [defaults]]
            [mount.core :as mount]
            [luminus.logger :as logger]))

(defn init
  "init will be called once when
   app is deployed."
  []
  (logger/init env)
  (migrations/migrate ["migrate"])
  (doseq [component (:started (mount/start))]
    (log/info component "started"))
  ((:init defaults)))

(defn destroy
  "destroy will be called when your application
   shuts down, put any clean up code here"
  []
  (log/info "kyselyynohjaus is shutting down...")
  (doseq [component (:stopped (mount/stop))]
    (log/info component "stopped"))
  (log/info "shutdown complete!"))

(defroutes haka-routes api-routes public-routes)

(defroutes app-routes
           (wrap-routes haka-routes middleware/wrap-palaute)
           (wrap-routes rekry-routes middleware/wrap-rekry)
           (wrap-routes common-routes middleware/wrap-common)
           (wrap-routes export-routes middleware/wrap-basic-auth)
 (route/not-found
    (:body
      (error-page {:status 404
                   :title "page not found"}))))

(def app (middleware/wrap-base #'app-routes))
