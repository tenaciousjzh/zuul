(ns zuul.session.token-proto
  (:gen-class))

(defprotocol PersistentTokenSource
  "Manages the storage and retrieval of valid session tokens"
  (get-token [this username] "Retrieves the token associated with the
authenticated user")
  (get-user [this token] "Retrieves the authenticated user associated
with the token")
  (remove-token [this token] "Removes the token from persistent storage")
  (add-token [this token username ttl-sec] "Adds the token to storage")
  (create-token [this ] "Generates a unique token for a newly authenticated user")
  (update-token-ttl [this token ttl-sec]))
