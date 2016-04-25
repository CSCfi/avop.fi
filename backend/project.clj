(defproject avopfi "0.1.0-SNAPSHOT"

  :description "Avop.fi backend"
  :url "https://www.avop.fi"

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [selmer "1.0.0"]
                 [markdown-clj "0.9.85"]
                 [luminus/config "0.8"]
                 [ring-middleware-format "0.7.0"]
                 [metosin/ring-http-response "0.6.5"]
                 [bouncer "1.0.0"]
                 [org.clojure/tools.logging "0.3.1"]
                 [org.clojure/tools.namespace "0.2.11"]
                 [org.clojure/java.data "0.1.1"] 
                 [com.taoensso/tower "3.0.2"]
                 [compojure "1.4.0"]
                 [org.clojure/core.match "0.3.0-alpha4"]
                 [clojure.java-time "0.2.0"]
                 [clj-http "2.0.1"]
                 [clj-http-fake "1.0.2"]
                 [com.novemberain/validateur "2.5.0"]
                 [slingshot "0.12.2"]
                 [ring/ring-defaults "0.1.5"]
                 [ring-ttl-session "0.3.0"]
                 [ring "1.4.0" :exclusions [ring/ring-jetty-adapter]]
                 [mount "0.1.9"]
                 [luminus-nrepl "0.1.2"]
                 [migratus "0.8.13"]
                 [conman "0.4.5"]
                 [buddy/buddy-auth "0.13.0"]
                 [org.postgresql/postgresql "9.4-1206-jdbc4"]
                 [luminus-jetty "0.1.0"]
                 [luminus-log4j "0.1.2"]]

  :min-lein-version "2.0.0"

  :jvm-opts ["-server"]
  :source-paths ["src/clj" "src/java"]
  :java-source-paths ["src/java"]
  :javac-options ["-target" "1.8" "-source" "1.8"]
  :resource-paths ["resources"]

  :main avopfi.core
  :migratus {:store :database}
  :uberwar {:handler avopfi.handler/app
            :init avopfi.handler/init
            :destroy avopfi.handler/destroy
            :name "avopfi.war"}

  :test-selectors {:default (complement :integration)
                   :integration :integration
                   :all (constantly true)}

  :plugins [[lein-environ "1.0.1"]
            [migratus-lein "0.2.6"]
            [lein-uberwar "0.2.0"]]
  :profiles
  {:uberjar {:omit-source true
             :env {:production true}
             :aot :all
             :uberjar-name "avopfi.jar"
             :source-paths ["env/prod/clj"]
             :resource-paths ["env/prod/resources"]}
   :dev           [:project/dev :profiles/dev]
   :test          [:project/test :profiles/test]
   :project/dev  {:dependencies [[prone "1.0.2"]
                                 [ring/ring-mock "0.3.0"]
                                 [ring/ring-devel "1.4.0"]
                                 [pjstadig/humane-test-output "0.7.1"]
                                 [mvxcvi/puget "1.0.0"]
                                 [midje "1.8.3"]]
                  :plugins [[lein-midje "3.2"]
                            [lein-test-out "0.3.1"]]
                  :source-paths ["env/dev/clj" "test/clj"]
                  :resource-paths ["env/dev/resources"]
                  :repl-options {:init-ns user}
                  :injections [(require 'pjstadig.humane-test-output)
                               (pjstadig.humane-test-output/activate!)]
                  ;;when :nrepl-port is set the application starts the nREPL server on load
                  :env {:dev        true
                        :port       3000
                        :nrepl-port 7000}}
   :project/test {:env {:test       true
                        :port       3001
                        :nrepl-port 7001}}
   :profiles/dev {}
   :profiles/test {}})
