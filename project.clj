(defproject zuul "0.0.1-1"

  :description "For those unfamiliar with the epic sci-fi movie, Ghostbusters,
Zuul was the Gatekeeper to the world of ghosts. Like the in the movie, Zuul
is a microservice that acts as a gatekeeper protecting private services
behind it. Zuul provides authentication, session management, and authorization.
Zuul also has an API gateway mode. When enabled, Zuul will authenticate and authorize
a RESTful request. If authorized, the request will forward to the request to the intended
endpoint."

  :url "https://github.com/tenaciousjzh/zuul"

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [selmer "0.9.4"]
                 [com.taoensso/timbre "4.1.4"]
                 [com.taoensso/tower "3.0.2"]
                 [markdown-clj "0.9.78"]
                 [environ "1.0.1"]
                 [compojure "1.4.0"]
                 [ring-webjars "0.1.1"]
                 [ring/ring-defaults "0.1.5"]
                 [ring "1.4.0"
                  :exclusions [ring/ring-jetty-adapter]]
                 [metosin/ring-middleware-format "0.6.0"]
                 [metosin/ring-http-response "0.6.5"]
                 [bouncer "0.3.3"]
                 [prone "0.8.2"]
                 [org.clojure/tools.nrepl "0.2.12"]
                 [org.webjars/bootstrap "3.3.5"]
                 [org.webjars/jquery "2.1.4"]
                 [org.clojars.pntblnk/clj-ldap "0.0.9"]
                 [buddy "0.7.2"]
                 [migratus "0.8.7"]
                 [conman "0.2.4"]
                 [org.postgresql/postgresql "9.4-1203-jdbc41"]
                 [org.immutant/web "2.1.0"]
                 [com.stuartsierra/component "0.3.0"]]

  :min-lein-version "2.0.0"
  :uberjar-name "zuul.jar"
  :jvm-opts ["-server"]

  :main zuul.core
  :migratus {:store :database}

  :plugins [[lein-environ "1.0.1"]
            [migratus-lein "0.2.0"]]
  :profiles
  {:uberjar {:omit-source true
             :env {:production true}
             :aot :all}
   :dev           [:project/dev :profiles/dev]
   :test          [:project/test :profiles/test]
   :project/dev  {:dependencies [[ring/ring-mock "0.3.0"]
                                 [ring/ring-devel "1.4.0"]
                                 [pjstadig/humane-test-output "0.7.0"]
                                 [mvxcvi/puget "1.0.0"]]


                  :repl-options {:init-ns zuul.core}
                  :injections [(require 'pjstadig.humane-test-output)
                               (pjstadig.humane-test-output/activate!)]
                  ;;when :nrepl-port is set the application starts the nREPL server on load
                  :env {:dev        true
                        :port       3000
                        :nrepl-port 7000
                        }}
   :project/test {:env {:test       true
                        :port       3001
                        :nrepl-port 7001
                        }}
   :profiles/dev {}
   :profiles/test {}})
