(ns zuul.session.sql-token-source
  (:require [zuul.session.token-proto :as token-proto]
            [zuul.db.core :as db]
            [com.stuartsierra.component :as component]
            [taoensso.timbre :as timbre])
  (:gen-class))

(defrecord SqlTokenSource []
  component/Lifecycle

  (start [component ]
    (timbre/info "Started SqlTokenSource Component"))
  (stop [component ]
    (timbre/info "Stopped SqlTokenSource Component"))

  token-proto/PersistentTokenSource

  (get-token [component username]
    (db/get-token username))
  (get-user-by-token [component token]
    (db/get-user-by-token token))
  (remove-token! [component token])
  (add-token! [component token ttl-sec])
  (create-token! [component ])
  (update-token-ttl! [component token ttl-sec])
  (is-token-expired? [component token]))

(defn new-sql-token-source []
  (map->SqlTokenSource {}))

(defn get-token [ts-cmp username]
  (let [_ (timbre/debug "Getting token for username: " username)
        token (first (token-proto/get-token ts-cmp username))
        _ (timbre/debug "Token : " token)]
    token))

(defn get-user-by-token [ts-cmp token]
  (let [_ (timbre/debug "Getting user associated to token: " token)
        user (first (token-proto/get-user-by-token ts-cmp token))
        _ (timbre/debug "User : " user)]
    user))
