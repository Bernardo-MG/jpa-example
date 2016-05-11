DROP TABLE IF EXISTS simple_entities;
DROP TABLE IF EXISTS boolean_converter_entities;
DROP TABLE IF EXISTS enum_entities;
DROP TABLE IF EXISTS date_entities;
DROP TABLE IF EXISTS time_entities;
DROP TABLE IF EXISTS timestamp_entities;
DROP TABLE IF EXISTS collection_entities;
DROP TABLE IF EXISTS collection_entities_values;
DROP TABLE IF EXISTS map_entities;
DROP TABLE IF EXISTS map_entities_values;
DROP TABLE IF EXISTS embedded_entities;

CREATE TABLE simple_entities (
	id		INTEGER PRIMARY KEY AUTO_INCREMENT,
	name	VARCHAR(30) DEFAULT '' NOT NULL
);

CREATE TABLE boolean_converter_entities (
	id		INTEGER PRIMARY KEY AUTO_INCREMENT,
	flag	VARCHAR(1) DEFAULT 'F' NOT NULL
);

CREATE TABLE enum_entities (
	id				INTEGER PRIMARY KEY AUTO_INCREMENT,
	enum_ordinal	INTEGER DEFAULT 0 NOT NULL,
	enum_string		VARCHAR(20) DEFAULT '' NOT NULL
);

CREATE TABLE date_entities (
	id				INTEGER PRIMARY KEY AUTO_INCREMENT,
	calendar_date	DATE NOT NULL,
	java_date		DATE NOT NULL,
	sql_date		DATE NOT NULL
);

CREATE TABLE time_entities (
	id				INTEGER PRIMARY KEY AUTO_INCREMENT,
	calendar_time	TIME NOT NULL,
	java_time		TIME NOT NULL,
	sql_time		TIME NOT NULL
);

CREATE TABLE timestamp_entities (
	id					INTEGER PRIMARY KEY AUTO_INCREMENT,
	calendar_timestamp	TIMESTAMP NOT NULL,
	java_timestamp		TIMESTAMP NOT NULL,
	sql_timestamp		TIMESTAMP NOT NULL
);

CREATE TABLE collection_entities (
	id		INTEGER PRIMARY KEY AUTO_INCREMENT,
	name	VARCHAR(30) DEFAULT '' NOT NULL
);

CREATE TABLE collection_entities_values (
	collection_id	INTEGER DEFAULT 0 NOT NULL,
	value_col		INTEGER DEFAULT 0 NOT NULL
);

CREATE TABLE map_entities (
	id		INTEGER PRIMARY KEY AUTO_INCREMENT,
	name	VARCHAR(30) DEFAULT '' NOT NULL
);

CREATE TABLE map_entities_values (
	map_id			INTEGER DEFAULT 0 NOT NULL,
	name			VARCHAR(30) DEFAULT '' NOT NULL,
	number			INTEGER DEFAULT 0 NOT NULL
);

CREATE TABLE embedded_entities (
	id			INTEGER DEFAULT 0 NOT NULL,
	name		VARCHAR(30) DEFAULT '' NOT NULL,
	description	VARCHAR(30) DEFAULT '' NOT NULL
);
