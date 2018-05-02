(ns avopfi.routes.public
  (:require
    [buddy.auth :refer [throw-unauthorized]]
    [avopfi.db.core :as db]
    [compojure.core :refer :all]
    [ring.util.http-response :refer :all]
    [avopfi.layout :as layout]))

(defn get-visitor [identity study-right-id organisation]
  (if (not (= "valid" identity))
    (throw-unauthorized)
    (ok (db/get-visitor {:opiskeluoikeus-id study-right-id
                         :oppilaitos-id organisation}))))

(defroutes public-routes
  (context "/public" []
   (GET "/students/:opiskeluoikeus-id{.{0,100}/:domain}" [opiskeluoikeus-id domain :as {i :identity}]
     (get-visitor i opiskeluoikeus-id domain))))