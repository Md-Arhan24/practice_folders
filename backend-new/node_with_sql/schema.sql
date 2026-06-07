-- creating table user
-- SHOW DATABASES;
USE backend;

-- CREATE TABLE user(
--     id INT PRIMARY KEY,
--     user  VARCHAR(30) UNIQUE,
--     email VARCHAR(40) UNIQUE NOT NULL,
--     password VARCHAR(10) NOT NULL
-- );

CREATE TABLE practice(
    id VARCHAR(244) PRIMARY KEY,
    user  VARCHAR(30) UNIQUE,
    email VARCHAR(40) UNIQUE NOT NULL,
    password VARCHAR(10) NOT NULL
);