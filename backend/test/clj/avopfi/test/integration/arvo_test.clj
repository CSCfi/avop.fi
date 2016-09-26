(ns avopfi.test.integration.arvo-test
  (:use
    [clojure.test :refer :all]
    [avopfi.integration.arvo])
  (:require
    [avopfi.test.fixtures :refer [opiskeluoikeus-data-fixture]]
    [clj-http.fake :as fake]
    [java-time :refer [as local-date]]
    [environ.core :refer [env]]
    [clj-http.client :as client]))

(deftest cleanup
  (testing "cleaning of data"
    (is (=
          (clean-opiskeluoikeus-data opiskeluoikeus-data-fixture)
          {:koulutus   (-> opiskeluoikeus-data-fixture :koulutus :id)
           :kunta      (-> opiskeluoikeus-data-fixture :kunta :id)
           :oppilaitos (-> opiskeluoikeus-data-fixture :oppilaitos :id)
           :koulutusmuoto "paivaopiskelu"
           :laajuus (:laajuus opiskeluoikeus-data-fixture)
           :opiskeluoikeustyyppi (:opiskeluoikeustyyppi opiskeluoikeus-data-fixture)
           :kyselykerran_nimi (str "AUTOMAATTI AVOP-AMK " (as (local-date) :year))})))

  (testing "cleaning of data should set kyselykerran_nimi to AUTOMAATTI KANDI for opiskeluoikeustyyppi 2"
    (let [kandi-opiskeluoikeus-data (assoc opiskeluoikeus-data-fixture :opiskeluoikeustyyppi "2")]
      (is (= (:kyselykerran_nimi (clean-opiskeluoikeus-data kandi-opiskeluoikeus-data))
             (str "AUTOMAATTI KANDI " (as (local-date) :year)))))))

(deftest cleanup-fail
  (testing "cleaning of empty data"
    (let [cleaned (clean-opiskeluoikeus-data {})]
      (is (every? nil? (vals cleaned))))))

(def arvo-api-endpoint (:arvo-api-url env))
(def arvo-hash "THLJWM")

(deftest succesful-arvo-call
  (testing "Call to Arvo is proper"
    (fake/with-fake-routes
      {
       arvo-api-endpoint
       (fn [req]
        (do (is
             (re-matches #"Bearer ([A-Za-z0-9-_=.]+)"
               (-> req :headers :Authorization)))
         {:status 200 :headers {} :body (str "{\"tunnus\": \"" arvo-hash "\"}")}))}

      (is (= arvo-hash (generate-questionnaire-credentials!
                        opiskeluoikeus-data-fixture (:kieli opiskeluoikeus-data-fixture)))))))

;(deftest erroneous-arvo-call
;  (testing "Call to Arvo throws exception when wrong body"
;    (fake/with-fake-routes
;      {
;       arvo-api-endpoint
;       (fn [req]
;        {:status 200 :headers {} :body "{}"})}
;
;      (is (thrown? clojure.lang.ExceptionInfo (generate-questionnaire-credentials!
;                                               opiskeluoikeus-data-fixture (:kieli opiskeluoikeus-data-fixture)))))))

