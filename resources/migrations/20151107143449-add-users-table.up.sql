CREATE TABLE users (
       id BIGSERIAL PRIMARY KEY NOT NULL,
       user_name VARCHAR(30),
       first_name VARCHAR(30),
       last_name VARCHAR(30),
       email VARCHAR(30),
       last_login TIMESTAMP,
       last_login_address INET,
       is_active BOOLEAN,
       pass VARCHAR(100),
       roles VARCHAR(32) ARRAY
 );
