(ns kyselyynohjaus.middleware
  (:require [kyselyynohjaus.layout :refer [*app-context* error-page]]
            [clojure.tools.logging :as log]
            [config.core :refer [env]]
            [ring-ttl-session.core :refer [ttl-memory-store]]
            [ring.middleware.defaults :refer [site-defaults wrap-defaults]]
            [ring.middleware.anti-forgery :refer [wrap-anti-forgery]]
            [ring.middleware.format :refer [wrap-restful-format]]
            [kyselyynohjaus.config :refer [defaults]]
            [buddy.auth.middleware :refer [wrap-authentication wrap-authorization]]
            [buddy.auth.backends.token :refer [token-backend]]
            [buddy.auth.accessrules :refer [restrict]]
            [buddy.auth :refer [authenticated?]]
            [clojure.string :as str]
            [config.core :refer [env]]
            [haka-buddy.backend :as backends]
            [kyselyynohjaus.util :refer [deprefixize]]
            [io.clj.logging :refer [with-logging-context]]
            [clojure.set :as set])
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

(def user-data #{"learner-id" "national-identification-number" "unique-id"})
(def home-org "home-organization")
(def org-data #{home-org})
(def employee-data #{"employeeNumber" "eppn"})

(defn haka-login-valid? [shibbo-vals ids]
  (let [ids-in-shibbo (clojure.set/intersection ids (set (keys shibbo-vals)))
        has-id (not (empty? ids-in-shibbo))
        has-org (contains? shibbo-vals home-org)
        valid (and has-org has-id)
        _ (log/info "Tarkistetaan Haka-kirjautuminen, vaaditut tiedot:" ids "löytyi:" (set (keys shibbo-vals)))]
    (if (and has-org (not valid))
      (log/info "Puutteelliset Haka-tiedot, organisaatio:" (get shibbo-vals home-org)))
    valid))

(defn palaute-haka-valid? [shibbo-vals]
  (haka-login-valid? shibbo-vals user-data))

(defn rekry-haka-valid? [shibbo-vals]
  (haka-login-valid? shibbo-vals employee-data))

(defn shibbo-backend [checkfn]
  (backends/shibbo-backend {:names (set/union user-data org-data employee-data)
                            :checkfn checkfn
                            :use-headers? (:is-dev env)}))

(defn authenticate [request token]
  (if (= token "secret") "valid" nil))


(defn parse-haka [handler]
  (fn [req]
    (handler (update-in req [:identity] clojure.walk/keywordize-keys))))

(defn generate-sessionid []
  (let [chars (map char (concat (range 65 91) (range 97 123)))
        id (apply str (take 8 (repeatedly #(rand-nth chars))))]
    id))

(defn attach-sessionid [handler]
  (fn [req]
    (handler
      (if (nil? (get-in req [:session :sessionid]))
        (let [user-agent (get-in req [:headers "user-agent"])
              sessionid (generate-sessionid)]
          (with-logging-context {:sessionid (format "[%s]" sessionid)}
            (log/info  "Session started, user agent: " user-agent "organization:" (->> req :identity :home-organization)))
          (assoc-in req [:session :sessionid] sessionid))
        req))))

(defn wrap-haka [handler checkfn]
  (-> ((:middleware defaults) handler)
      attach-sessionid
      parse-haka
      (wrap-authentication (shibbo-backend checkfn)
                           (token-backend {:authfn authenticate}))))
(defn wrap-palaute [handler]
  (wrap-haka handler palaute-haka-valid?))

(defn wrap-rekry [handler]
  (wrap-haka handler rekry-haka-valid?))

(defn wrap-common [handler]
  (wrap-haka handler #(haka-login-valid? % #{home-org})))

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
