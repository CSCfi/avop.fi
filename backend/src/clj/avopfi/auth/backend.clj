(ns avopfi.auth.backend 
  "The Shibbileth NativeSP based authentication and authorization backend(s)."
  (:require [config.core :refer [env]]
            [buddy.auth.protocols :as proto]
            [avopfi.integration.shibbo-utils :as shibbo]))

(defn- handle-unauthorized-default
  "A default response constructor for an unathorized request."
  [_]
  {:status 401 :headers {"Content-Type" "application/json"}
   :body "{\"status\": 401, \"detail\": \"Unauthorized\"}"})

;TODO: have shibbo-backend validate credentials for Virta integration compatibility

(defn haka-login-valid? [shibbo-vals]
  (let [user-ids #{"learner-id" "national-identification-number" "unique-id"}
        ids-in-shibbo (clojure.set/intersection user-ids (set (keys shibbo-vals)))
        has-id (not (empty? ids-in-shibbo))
        has-org (contains? shibbo-vals "home-organization")]
    (and has-org has-id)))

(defn shibbo-backend
  "Create an instance of the Shibbo backend."
  []
  (reify
    proto/IAuthentication
    (-parse [_ request]
      (shibbo/get-attributes request env))
    (-authenticate [_ request shib-attribs]
      (let [identity
            (if (haka-login-valid? shib-attribs) shib-attribs nil)]
        identity))))

(defn authz-backend
  []
  (reify
    proto/IAuthorization
    (-handle-unauthorized [_ request metadata]
      (handle-unauthorized-default request))))