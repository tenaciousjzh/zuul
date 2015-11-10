CREATE TABLE tokens (
       id BIGSERIAL PRIMARY KEY NOT NULL,
       token VARCHAR(64) NOT NULL,
       user_name VARCHAR(30),
       last_modified TIMESTAMP,
       expires TIMESTAMP,
       CONSTRAINT unique_token UNIQUE (token)
);

--;;

CREATE INDEX tokens_token_idx ON tokens(token);

--;;

CREATE INDEX tokens_user_name_idx ON tokens(user_name);

--;;

CREATE INDEX tokens_expires_idx ON tokens(expires);
