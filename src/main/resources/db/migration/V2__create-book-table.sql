CREATE TABLE public.book (
	id BIGSERIAL NOT NULL PRIMARY KEY,
	name varchar(255) NOT NULL,
	price decimal(10,2) NOT NULL,
	status varchar(255) NOT NULL,
	customer_id int NOT NULL,
	FOREIGN KEY (customer_id) REFERENCES customer(id)
);