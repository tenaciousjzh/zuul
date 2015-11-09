(ns zuul.session.sql-token-source
  (:require [zuul.session.token-proto :as token-proto]
            [com.stuartsierra.component :as component])
  (:gen-class))

(defrecord SqlTokenSource [conninfo ]
  component/Lifecycle

  (start [component ])
  (stop [component ])

  token-proto/PersistentTokenSource
  (get-token [component username])
  (get-user [component token])
  (remove-token [component token])
  (add-token [component token ttl-sec])
  (create-token [component ])
  (update-token-ttl [component token ttl-sec]))
