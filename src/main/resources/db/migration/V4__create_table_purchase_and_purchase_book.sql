CREATE TABLE public.purchase (
	id BIGSERIAL NOT NULL PRIMARY KEY,
	customer_id INT NOT NULL,
	nfe varchar(255) NULL,
	price DECIMAL(15,2) NOT NULL,
	created_at TIMESTAMP NOT NULL,
	FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE public.purchase_book (
	purchase_id INT NOT NULL,
	book_id INT NOT NULL,
	FOREIGN KEY (purchase_id) REFERENCES purchase(id),
	FOREIGN KEY (book_id) REFERENCES book(id),
	PRIMARY KEY(purchase_id, book_id)
);