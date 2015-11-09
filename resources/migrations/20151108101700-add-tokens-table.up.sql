CREATE TABLE tokens (
       id BIGSERIAL PRIMARY KEY NOT NULL,
       token VARCHAR(64) NOT NULL,
       user_name VARCHAR(30),
       last_modified TIMESTAMP,
       expires TIMESTAMP,
       CONSTRAINT unique_token UNIQUE (token)
);
