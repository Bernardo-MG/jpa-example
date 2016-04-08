DROP TABLE IF EXISTS simple_entities;
DROP TABLE IF EXISTS boolean_converter_entities;

CREATE TABLE simple_entities (
	id		INTEGER IDENTITY PRIMARY KEY,
	name	VARCHAR(30) DEFAULT '' NOT NULL
);

CREATE TABLE boolean_converter_entities (
	id		INTEGER IDENTITY PRIMARY KEY,
	flag	VARCHAR(1) DEFAULT 'F' NOT NULL
);

CREATE TABLE enum_entities (
	id				INTEGER IDENTITY PRIMARY KEY,
	enum_ordinal	INTEGER DEFAULT 0 NOT NULL,
	enum_string		VARCHAR(20) DEFAULT '' NOT NULL
);
