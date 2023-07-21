CREATE TABLE public.customer (
	id BIGSERIAL NOT NULL PRIMARY KEY,
	name varchar(255) NOT NULL,
	email varchar(255) NOT NULL UNIQUE
);