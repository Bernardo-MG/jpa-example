DROP TABLE IF EXISTS example_entities;

CREATE TABLE example_entities (
	id		SERIAL PRIMARY KEY,
	name	TEXT DEFAULT '' NOT NULL
);
