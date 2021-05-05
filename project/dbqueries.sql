CREATE TABLE store.customer_rocks (
	"type" varchar NULL,
	weight float4 NULL,
	price float8 NULL,
	rock_id int2 NOT NULL,
	customer_id int4 NULL,
	CONSTRAINT customer_rocks_pk PRIMARY KEY (rock_id)
);

INSERT INTO store.customer_rocks
("type", weight, price, rock_id, customer_id)
VALUES('', 0, 0, 0, 0);

SELECT "type", weight, price, rock_id, customer_id
FROM store.customer_rocks;

-- store.customers definition

-- Drop table

-- DROP TABLE store.customers;

CREATE TABLE store.customers (
	firstname varchar NULL,
	lastname varchar NULL,
	email varchar NULL,
	phonenumber varchar NULL,
	customer_id serial NOT NULL,
	usernames varchar NULL,
	passwords varchar NULL,
	balance float8 NULL,
	CONSTRAINT customers_pk PRIMARY KEY (customer_id)
);

INSERT INTO store.customers
(firstname, lastname, email, phonenumber, usernames, passwords, balance)
VALUES('', '', '', '', '', '', 0);

CREATE TABLE store.employees (
	firstname varchar NULL,
	lastname varchar NULL,
	username varchar NULL,
	"password" varchar NULL,
	employee_type int4 NULL DEFAULT 1,
	manager_id serial NOT NULL,
	employee_id serial NOT NULL,
	CONSTRAINT employees_un UNIQUE (username)
);

INSERT INTO store.employees
(firstname, lastname, username, "password", employee_type)
VALUES('', '', '', '', 1);

CREATE TABLE store.managers (
	firstname varchar NULL,
	lastname varchar NULL,
	username varchar NULL,
	"password" varchar NULL,
	manager_id int2 NOT NULL,
	employee_type int2 NULL,
	CONSTRAINT managers_pk PRIMARY KEY (manager_id)
);

INSERT INTO store.managers
(firstname, lastname, username, "password", manager_id, employee_type)
VALUES('', '', '', '', 0, 0);

CREATE TABLE store.offers (
	customer_id int4 NOT NULL,
	rock_id int4 NOT NULL,
	offer_id serial NOT NULL,
	offeramount float8 NULL,
	status int2 NULL DEFAULT 2
);

INSERT INTO store.offers
(customer_id, rock_id, offeramount, status)
VALUES(0, 0, 0, 2);

CREATE TABLE store.rocks (
	"type" varchar NULL,
	weight float8 NULL,
	price float8 NULL,
	rock_id serial NOT NULL,
	status int2 NULL,
	CONSTRAINT rocks_pk PRIMARY KEY (rock_id)
);

INSERT INTO store.rocks
("type", weight, price, status)
VALUES('', 0, 0, 0);

CREATE TABLE store.salerecords (
	saleamount float8 NULL,
	"timestamp" timestamp(0) NULL,
	rock_id int8 NULL,
	customer_id int2 NULL,
	sales_id serial NOT NULL,
	CONSTRAINT salerecords_pk PRIMARY KEY (sales_id)
);

INSERT INTO store.salerecords
(saleamount, "timestamp", rock_id, customer_id)
VALUES(0, '', 0, 0);


