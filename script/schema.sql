IF (SELECT 1 FROM pg_database WHERE datname = 'mydb') <> 1 THEN
    CREATE DATABASE testdb;
END IF;

CREATE TABLE IF NOT EXISTS sas_user
(
	id BIGSERIAL,
	name varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	PRIMARY KEY (id)
);