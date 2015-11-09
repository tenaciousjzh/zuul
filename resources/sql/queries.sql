-- name: create-user!
-- creates a new user record
INSERT INTO users
(user_name, first_name, last_name, email, is_active, pass, roles)
VALUES (:user_name, :first_name, :last_name, :email, :is_active, :pass, :roles)

-- name: update-user!
-- update an existing user record
UPDATE users
SET first_name = :first_name, last_name = :last_name, email = :email
WHERE id = :id

-- name: update-user-login!
-- update an existing user's login
UPDATE users
SET last_login = :last_login, last_login_address = :last_login_address
WHERE id = :id

-- name: update-user-roles!
-- update an existing user's roles
UPDATE users
SET roles = :roles
WHERE id = :id

-- name: update-user-password!
-- update user password
UPDATE users
SET pass = :pass
WHERE id = :id

-- name: get-user
-- retrieve a user given the id.
SELECT * FROM users
WHERE id = :id

-- name: delete-user!
-- delete a user given the id
DELETE FROM users
WHERE id = :id

-- name: create-token!
-- creates a new session token
INSERT INTO tokens
(token, user_name, last_modified)
VALUES (:token, :user_name, :last_modified)

-- name: update-token-ttl!
-- updates the time-to-live/expiration on a session token
UPDATE tokens
SET last_modified = :last_modified, expires = :expires
WHERE id = :id

-- name: delete-token!
-- deletes a session token
DELETE FROM tokens
WHERE id = :id
