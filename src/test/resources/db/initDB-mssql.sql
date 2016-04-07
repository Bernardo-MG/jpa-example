DROP TABLE IF EXISTS simple_entities;
DROP TABLE IF EXISTS boolean_converter_entities;

CREATE TABLE simple_entities (
	id		INTEGER IDENTITY PRIMARY KEY,
	name	VARCHAR(30) DEFAULT '' NOT NULL
);

CREATE TABLE boolean_converter_entities (
	id		INTEGER IDENTITY PRIMARY KEY,
	flag	VARCHAR(1) NOT NULL
);
