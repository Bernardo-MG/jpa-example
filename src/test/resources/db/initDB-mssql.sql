DROP TABLE IF EXISTS simple_entities;
DROP TABLE IF EXISTS boolean_converter_entities;
DROP TABLE IF EXISTS enum_entities;

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

CREATE TABLE date_entities (
	id				INTEGER IDENTITY PRIMARY KEY,
	calendar_date	DATE NOT NULL,
	java_date		DATE NOT NULL,
	sql_date		DATE NOT NULL
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
