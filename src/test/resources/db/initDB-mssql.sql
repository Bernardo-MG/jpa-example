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
DROP TABLE IF EXISTS element_collection_entities;
DROP TABLE IF EXISTS element_collection_entities_values;
DROP TABLE IF EXISTS multiple_table_inherit_root_entities;
DROP TABLE IF EXISTS multiple_table_inherit_value_entities;
DROP TABLE IF EXISTS multiple_table_inherit_description_entities;
DROP TABLE IF EXISTS per_class_table_inherit_value_entities;
DROP TABLE IF EXISTS per_class_table_inherit_description_entities;
DROP TABLE IF EXISTS single_table_inherit_entities;
DROP TABLE IF EXISTS super_class_table_inherit_description_entities;
DROP TABLE IF EXISTS super_class_table_inherit_value_entities;
DROP TABLE IF EXISTS composite_key_idclass_entities;
DROP TABLE IF EXISTS two_tables_entities_a;
DROP TABLE IF EXISTS two_tables_entities_b;

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

CREATE TABLE collection_entities (
	id		INTEGER IDENTITY PRIMARY KEY,
	name	VARCHAR(30) DEFAULT '' NOT NULL
);

CREATE TABLE collection_entities_values (
	collection_id	INTEGER DEFAULT 0 NOT NULL,
	value_col		INTEGER DEFAULT 0 NOT NULL
);

CREATE TABLE map_entities (
	id		INTEGER IDENTITY PRIMARY KEY,
	name	VARCHAR(30) DEFAULT '' NOT NULL
);

CREATE TABLE map_entities_values (
	map_id			INTEGER DEFAULT 0 NOT NULL,
	name			VARCHAR(30) DEFAULT '' NOT NULL,
	number			INTEGER DEFAULT 0 NOT NULL
);

CREATE TABLE embedded_entities (
	id			INTEGER IDENTITY PRIMARY KEY,
	name		VARCHAR(30) DEFAULT '' NOT NULL,
	description	VARCHAR(30) DEFAULT '' NOT NULL
);

CREATE TABLE element_collection_entities (
	id		INTEGER IDENTITY PRIMARY KEY,
	name	VARCHAR(30) DEFAULT '' NOT NULL
);

CREATE TABLE element_collection_entities_values (
	collection_id	INTEGER DEFAULT 0 NOT NULL,
	name		VARCHAR(30) DEFAULT '' NOT NULL,
	description	VARCHAR(30) DEFAULT '' NOT NULL
);

CREATE TABLE multiple_table_inherit_root_entities (
	id				INTEGER IDENTITY PRIMARY KEY,
	name			VARCHAR(30) DEFAULT '' NOT NULL,
	discriminator	VARCHAR(30) DEFAULT '' NOT NULL
);

CREATE TABLE multiple_table_inherit_value_entities (
	id		INTEGER DEFAULT 0 NOT NULL,
	value	INTEGER DEFAULT 0 NOT NULL
);

CREATE TABLE multiple_table_inherit_description_entities (
	id				INTEGER DEFAULT 0 NOT NULL,
	description		VARCHAR(30) DEFAULT '' NOT NULL
);

CREATE TABLE per_class_table_inherit_value_entities (
	id		INTEGER IDENTITY PRIMARY KEY,
	name	VARCHAR(30) DEFAULT '' NOT NULL,
	value	INTEGER DEFAULT 0 NOT NULL
);

CREATE TABLE per_class_table_inherit_description_entities (
	id				INTEGER IDENTITY PRIMARY KEY,
	name			VARCHAR(30) DEFAULT '' NOT NULL,
	description		VARCHAR(30) DEFAULT '' NOT NULL
);

CREATE TABLE single_table_inherit_entities (
	id				INTEGER IDENTITY PRIMARY KEY,
	discriminator	VARCHAR(4) DEFAULT '' NOT NULL,
	name			VARCHAR(30) DEFAULT '' NOT NULL,
	description		VARCHAR(30),
	value			INTEGER
);

CREATE TABLE super_class_table_inherit_value_entities (
	id		INTEGER IDENTITY PRIMARY KEY,
	name	VARCHAR(30) DEFAULT '' NOT NULL,
	value	INTEGER DEFAULT 0 NOT NULL
);

CREATE TABLE super_class_table_inherit_description_entities (
	id				INTEGER IDENTITY PRIMARY KEY,
	name			VARCHAR(30) DEFAULT '' NOT NULL,
	description		VARCHAR(30) DEFAULT '' NOT NULL
);

CREATE TABLE composite_key_idclass_entities (
	id1				INTEGER NOT NULL,
	id2				INTEGER NOT NULL,
	name			VARCHAR(30) DEFAULT '' NOT NULL,
	PRIMARY KEY (id1, id2)
);

CREATE TABLE two_tables_entities_a (
	id				INTEGER IDENTITY PRIMARY KEY,
	field1			VARCHAR(30) DEFAULT '' NOT NULL
);

CREATE TABLE two_tables_entities_b (
	entity_id		INTEGER NOT NULL,
	field2			VARCHAR(30) DEFAULT '' NOT NULL,
	FOREIGN KEY (entity_id) REFERENCES two_tables_entities_a(id)
);
