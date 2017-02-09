(ns avopfi.handler
  (:require [compojure.core :refer [defroutes routes wrap-routes]]
            [avopfi.layout :refer [error-page]]
            [avopfi.routes.api :refer [api-routes vipunen-routes]]
            [avopfi.routes.public :refer [public-routes]]
            [avopfi.middleware :as middleware]
            [avopfi.db.migrations :as migrations]
            [clojure.tools.logging :as log]
            [compojure.route :as route]
            [config.core :refer [env]]
            [avopfi.config :refer [defaults]]
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
  (log/info "avopfi is shutting down...")
  (doseq [component (:stopped (mount/stop))]
    (log/info component "stopped"))
  (log/info "shutdown complete!"))

(def app-routes
  (routes
    (wrap-routes #'api-routes middleware/wrap-restricted)
    (wrap-routes #'vipunen-routes middleware/wrap-basic-auth)
    (wrap-routes #'public-routes middleware/wrap-restricted)
   (route/not-found
      (:body
        (error-page {:status 404
                     :title "page not found"})))))

(def app (middleware/wrap-base #'app-routes))
