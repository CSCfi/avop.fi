(ns avopfi.middleware
  (:require [avopfi.layout :refer [*app-context* error-page]]
            [clojure.tools.logging :as log]
            [config.core :refer [env]]
            [ring-ttl-session.core :refer [ttl-memory-store]]
            [ring.middleware.defaults :refer [site-defaults wrap-defaults]]
            [ring.middleware.anti-forgery :refer [wrap-anti-forgery]]
            [ring.middleware.format :refer [wrap-restful-format]]
            [avopfi.config :refer [defaults]]            
            [buddy.auth.middleware :refer [wrap-authentication wrap-authorization]]
            [buddy.auth.backends.token :refer [token-backend]]
            [buddy.auth.accessrules :refer [restrict]]
            [buddy.auth :refer [authenticated?]]
            [clojure.string :as str]
            [config.core :refer [env]]
            [haka-buddy.backend :as backends]
            [avopfi.util :refer [deprefixize]])
  (:import [javax.servlet ServletContext]
           [java.util Base64]))

(def ^:const one-hour (* 60 60))

(defn wrap-context [handler]
  (fn [request]
    (binding [*app-context*
              (if-let [context (:servlet-context request)]
                ;; If we're not inside a servlet environment
                ;; (for example when using mock requests), then
                ;; .getContextPath might not exist
                (try (.getContextPath ^ServletContext context)
                     (catch IllegalArgumentException _ context))
                ;; if the context is not specified in the request
                ;; we check if one has been specified in the environment
                ;; instead
                (:app-context env))]
      (handler request))))

(defn wrap-internal-error [handler]
  (fn [req]
    (try
      (handler req)
      (catch Throwable t
        (log/error t)
        (error-page {:status 500
                     :title "Error 500"
                     :message "Server error."})))))

(defn wrap-csrf [handler]
  (wrap-anti-forgery
    handler
    {:error-response
     (error-page
       {:status 403
        :title "Invalid anti-forgery token"})}))

(defn wrap-formats [handler]
  (let [wrapped (wrap-restful-format
                  handler
                  {:formats [:json-kw :transit-json :transit-msgpack]})]
    (fn [request]
      ;; disable wrap-formats for websockets
      ;; since they're not compatible with this middleware
      ((if (:websocket? request) handler wrapped) request))))

(defn on-403 [request response]
  {:status  403
   :headers {"Content-Type" "application/json"}
   :body   {:status 403
            :detail  (str "Access to " (:uri request) " is forbidden")}})

(defn wrap-restricted [handler]
  (restrict handler {:handler authenticated?
                     :on-error on-403}))


(defn hae-tunnus [request]
  (when-let [auth-header (get-in request [:headers "authorization"])]
    (let [decoder (Base64/getMimeDecoder)
          [_ auth-encoded] (re-matches #"Basic ([A-z0-9+/=]*)" auth-header)]
      (when-not (str/blank? auth-encoded)
        (try
          (->
            (.decode decoder auth-encoded)
            (String. "UTF-8")
            (str/split #":"))
          (catch IllegalArgumentException _))))))


(defn wrap-basic-auth [handler]
  (fn [request]
    (let [username (env :basic-auth-username)
          password (env :basic-auth-password)]
      (if-not (and username password)
        (throw (IllegalStateException. "Basic-autentikaation tunnusta ja salasanaa ei ole asetettu"))
        (if (= (hae-tunnus request) [username password])
          (handler request)
          {:status 401
           :headers {"www-authenticate" "Basic realm=\"restricted\""}})))))

(def user-ids #{"shib-learner-id" "shib-national-identification-number" "shib-unique-id"})
(def home-org "shib-home-organization")

(defn haka-login-valid? [shibbo-vals]
  (let [ids-in-shibbo (clojure.set/intersection user-ids (set (keys shibbo-vals)))
        has-id (not (empty? ids-in-shibbo))
        has-org (contains? shibbo-vals "shib-home-organization")]
    (and has-org has-id)))

(def shibbo-backend (backends/shibbo-backend {:names (conj user-ids home-org)
                                              :checkfn haka-login-valid?
                                              :use-headers? (:is-dev env)}))
(defn authenticate [request token]
  (if (= token "secret") "valid" nil))

(def keywordize-haka (comp clojure.walk/keywordize-keys (partial deprefixize "shib-")))

(defn parse-haka [handler]
  (fn [req]
    (handler (update-in req [:identity] keywordize-haka))))

(defn wrap-haka [handler]
  (-> ((:middleware defaults) handler)
      parse-haka
      (wrap-authentication shibbo-backend
                           (token-backend {:authfn authenticate}))))

(defn wrap-base [handler]
  (-> ((:middleware defaults) handler)
      (wrap-authorization backends/authz-backend)
      wrap-formats
      (wrap-defaults
        (-> site-defaults
            (assoc-in [:security :anti-forgery] false)
            (assoc-in [:session :store] (ttl-memory-store one-hour))))
      wrap-context
      wrap-internal-error))
