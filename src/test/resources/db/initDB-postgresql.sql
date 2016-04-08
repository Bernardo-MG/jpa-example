DROP TABLE IF EXISTS simple_entities;
DROP TABLE IF EXISTS boolean_converter_entities;

CREATE TABLE simple_entities (
	id		SERIAL PRIMARY KEY,
	name	TEXT DEFAULT '' NOT NULL
);

CREATE TABLE boolean_converter_entities (
	id		SERIAL PRIMARY KEY,
	flag	TEXT DEFAULT 'F' NOT NULL
);

CREATE TABLE enum_entities (
	id				SERIAL PRIMARY KEY,
	enum_ordinal	INTEGER DEFAULT 0 NOT NULL,
	enum_string		VARCHAR(20) DEFAULT '' NOT NULL
);
