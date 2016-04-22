DROP TABLE IF EXISTS simple_entities;
DROP TABLE IF EXISTS boolean_converter_entities;
DROP TABLE IF EXISTS enum_entities;
DROP TABLE IF EXISTS date_entities;
DROP TABLE IF EXISTS time_entities;
DROP TABLE IF EXISTS timestamp_entities;

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

CREATE TABLE date_entities (
	id				INTEGER IDENTITY PRIMARY KEY,
	calendar_date	DATE NOT NULL,
	java_date		DATE NOT NULL
);

CREATE TABLE time_entities (
	id				INTEGER IDENTITY PRIMARY KEY,
	calendar_time	TIME NOT NULL,
	java_time		TIME NOT NULL,
	sql_time		TIME NOT NULL
);

CREATE TABLE timestamp_entities (
	id					INTEGER IDENTITY PRIMARY KEY,
	calendar_timestamp	TIMESTAMP NOT NULL,
	java_timestamp		TIMESTAMP NOT NULL,
	sql_timestamp		TIMESTAMP NOT NULL
);
