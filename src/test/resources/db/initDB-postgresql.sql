DROP TABLE IF EXISTS simple_entities;

CREATE TABLE simple_entities (
	id		SERIAL PRIMARY KEY,
	name	TEXT DEFAULT '' NOT NULL
);
