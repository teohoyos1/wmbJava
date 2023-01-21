CREATE TABLE IF NOT EXISTS Person
(
    id serial NOT NULL,
    username varchar (50) NOT NULL,
	first_name varchar (50) NOT NULL,
	last_name varchar (50) NOT NULL,
	email varchar (100) NOT NULL,
	phone varchar (50) NOT NULL,
	password varchar (60) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS Payment_category
(
    id serial NOT NULL,
    name varchar (100) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS Bank
(
    id serial NOT NULL,
    name varchar (50) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS Wallet
(
    id serial NOT NULL,
    name varchar (50) NOT NULL,
	balance INTEGER NOT NULL,
	id_person INTEGER NOT NULL,
	id_bank INTEGER NOT NULL,
    PRIMARY KEY (id),
	CONSTRAINT fk_person
      FOREIGN KEY(id_person)
	  REFERENCES Person(id)
	  ON DELETE CASCADE,
	CONSTRAINT fk_bank
      FOREIGN KEY(id_bank)
	  REFERENCES Bank(id)
	  ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS Movement_wallet
(
    id serial NOT NULL,
    description varchar (100) NOT NULL,
	actual_value INTEGER NOT NULL,
	record_date timestamp without time zone NOT NULL,
	id_payment_category INTEGER NOT NULL,
	id_wallet INTEGER NOT NULL,
    PRIMARY KEY (id),
	CONSTRAINT fk_payment_category
      FOREIGN KEY(id_payment_category)
	  REFERENCES Payment_category(id)
	  ON DELETE CASCADE,
	CONSTRAINT fk_wallet
      FOREIGN KEY(id_wallet)
	  REFERENCES Wallet(id)
	  ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Integration
(
    id serial NOT NULL,
    token varchar (100) NOT NULL,
	creation_date timestamp without time zone NOT NULL,
	id_person INTEGER NOT NULL,
    PRIMARY KEY (id),
	CONSTRAINT fk_person
      FOREIGN KEY(id_person)
	  REFERENCES Person(id)
	  ON DELETE CASCADE
);