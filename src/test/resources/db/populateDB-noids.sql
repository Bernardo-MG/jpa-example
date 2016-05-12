INSERT INTO simple_entities (name) VALUES ('entity_1');
INSERT INTO simple_entities (name) VALUES ('entity_2');
INSERT INTO simple_entities (name) VALUES ('entity_3');
INSERT INTO simple_entities (name) VALUES ('entity_4');
INSERT INTO simple_entities (name) VALUES ('entity_5');
INSERT INTO simple_entities (name) VALUES ('entity_6');
INSERT INTO simple_entities (name) VALUES ('entity_7');
INSERT INTO simple_entities (name) VALUES ('entity_8');
INSERT INTO simple_entities (name) VALUES ('entity_9');
INSERT INTO simple_entities (name) VALUES ('entity_10');
INSERT INTO simple_entities (name) VALUES ('entity_11');
INSERT INTO simple_entities (name) VALUES ('entity_12');
INSERT INTO simple_entities (name) VALUES ('entity_13');
INSERT INTO simple_entities (name) VALUES ('entity_14');
INSERT INTO simple_entities (name) VALUES ('entity_15');
INSERT INTO simple_entities (name) VALUES ('entity_16');
INSERT INTO simple_entities (name) VALUES ('entity_17');
INSERT INTO simple_entities (name) VALUES ('entity_18');
INSERT INTO simple_entities (name) VALUES ('entity_19');
INSERT INTO simple_entities (name) VALUES ('entity_20');
INSERT INTO simple_entities (name) VALUES ('entity_21');
INSERT INTO simple_entities (name) VALUES ('entity_22');
INSERT INTO simple_entities (name) VALUES ('entity_23');
INSERT INTO simple_entities (name) VALUES ('entity_24');
INSERT INTO simple_entities (name) VALUES ('entity_25');
INSERT INTO simple_entities (name) VALUES ('entity_26');
INSERT INTO simple_entities (name) VALUES ('entity_27');
INSERT INTO simple_entities (name) VALUES ('entity_28');
INSERT INTO simple_entities (name) VALUES ('entity_29');
INSERT INTO simple_entities (name) VALUES ('entity_30');

INSERT INTO boolean_converter_entities (flag) VALUES ('T');
INSERT INTO boolean_converter_entities (flag) VALUES ('B');
INSERT INTO boolean_converter_entities (flag) VALUES ('F');
INSERT INTO boolean_converter_entities (flag) VALUES ('F');
INSERT INTO boolean_converter_entities (flag) VALUES ('T');
INSERT INTO boolean_converter_entities (flag) VALUES ('T');
INSERT INTO boolean_converter_entities (flag) VALUES ('B');
INSERT INTO boolean_converter_entities (flag) VALUES ('B');
INSERT INTO boolean_converter_entities (flag) VALUES ('B');

INSERT INTO enum_entities (enum_string, enum_ordinal) VALUES ('TWO', 2);
INSERT INTO enum_entities (enum_string, enum_ordinal) VALUES ('ONE', 0);
INSERT INTO enum_entities (enum_string, enum_ordinal) VALUES ('THREE', 1);
INSERT INTO enum_entities (enum_string, enum_ordinal) VALUES ('TWO', 2);

INSERT INTO date_entities (calendar_date, java_date, sql_date) VALUES ('1990-02-03', '1990-02-03', '1990-02-03');
INSERT INTO date_entities (calendar_date, java_date, sql_date) VALUES ('1991-05-02', '1991-05-02', '1991-05-02');
INSERT INTO date_entities (calendar_date, java_date, sql_date) VALUES ('1990-02-03', '1990-02-03', '1990-02-03');
INSERT INTO date_entities (calendar_date, java_date, sql_date) VALUES ('1995-01-02', '1995-01-02', '1995-01-02');
INSERT INTO date_entities (calendar_date, java_date, sql_date) VALUES ('1992-01-01', '1992-01-01', '1992-01-01');
INSERT INTO date_entities (calendar_date, java_date, sql_date) VALUES ('1996-12-24', '1996-12-24', '1996-12-24');

INSERT INTO time_entities (calendar_time, java_time, sql_time) VALUES ('11:22:33', '11:22:33', '11:22:33');
INSERT INTO time_entities (calendar_time, java_time, sql_time) VALUES ('11:11:11', '11:11:11', '11:11:11');
INSERT INTO time_entities (calendar_time, java_time, sql_time) VALUES ('11:22:33', '11:22:33', '11:22:33');
INSERT INTO time_entities (calendar_time, java_time, sql_time) VALUES ('03:15:10', '03:15:10', '03:15:10');
INSERT INTO time_entities (calendar_time, java_time, sql_time) VALUES ('12:00:00', '12:00:00', '12:00:00');
INSERT INTO time_entities (calendar_time, java_time, sql_time) VALUES ('01:10:10', '01:10:10', '01:10:10');

INSERT INTO timestamp_entities (calendar_timestamp, java_timestamp, sql_timestamp) VALUES ('1990-02-03 11:22:33', '1990-02-03 11:22:33', '1990-02-03 11:22:33');
INSERT INTO timestamp_entities (calendar_timestamp, java_timestamp, sql_timestamp) VALUES ('1991-05-02 11:11:11', '1991-05-02 11:11:11', '1991-05-02 11:11:11');
INSERT INTO timestamp_entities (calendar_timestamp, java_timestamp, sql_timestamp) VALUES ('1990-02-03 11:22:33', '1990-02-03 11:22:33', '1990-02-03 11:22:33');
INSERT INTO timestamp_entities (calendar_timestamp, java_timestamp, sql_timestamp) VALUES ('1995-01-02 03:15:10', '1995-01-02 03:15:10', '1995-01-02 03:15:10');
INSERT INTO timestamp_entities (calendar_timestamp, java_timestamp, sql_timestamp) VALUES ('1992-01-01 12:00:00', '1992-01-01 12:00:00', '1992-01-01 12:00:00');
INSERT INTO timestamp_entities (calendar_timestamp, java_timestamp, sql_timestamp) VALUES ('1996-12-24 01:10:10', '1996-12-24 01:10:10', '1996-12-24 01:10:10');

INSERT INTO collection_entities (name) VALUES ('col_entity_1');
INSERT INTO collection_entities (name) VALUES ('col_entity_2');
INSERT INTO collection_entities (name) VALUES ('col_entity_3');
INSERT INTO collection_entities (name) VALUES ('col_entity_4');
INSERT INTO collection_entities (name) VALUES ('col_entity_5');

INSERT INTO collection_entities_values (collection_id, value_col) VALUES (1, 1);
INSERT INTO collection_entities_values (collection_id, value_col) VALUES (1, 2);
INSERT INTO collection_entities_values (collection_id, value_col) VALUES (2, 3);
INSERT INTO collection_entities_values (collection_id, value_col) VALUES (2, 2);
INSERT INTO collection_entities_values (collection_id, value_col) VALUES (3, 4);
INSERT INTO collection_entities_values (collection_id, value_col) VALUES (3, 5);
INSERT INTO collection_entities_values (collection_id, value_col) VALUES (4, 6);
INSERT INTO collection_entities_values (collection_id, value_col) VALUES (5, 7);
INSERT INTO collection_entities_values (collection_id, value_col) VALUES (5, 2);
INSERT INTO collection_entities_values (collection_id, value_col) VALUES (5, 8);
INSERT INTO collection_entities_values (collection_id, value_col) VALUES (5, 9);
INSERT INTO collection_entities_values (collection_id, value_col) VALUES (1, 10);

INSERT INTO map_entities (name) VALUES ('map_entity_1');
INSERT INTO map_entities (name) VALUES ('map_entity_2');
INSERT INTO map_entities (name) VALUES ('map_entity_3');
INSERT INTO map_entities (name) VALUES ('map_entity_4');
INSERT INTO map_entities (name) VALUES ('map_entity_5');

INSERT INTO map_entities_values (map_id, name, number) VALUES (1, 'value_1', 1);
INSERT INTO map_entities_values (map_id, name, number) VALUES (1, 'value_2', 2);
INSERT INTO map_entities_values (map_id, name, number) VALUES (2, 'value_2', 3);
INSERT INTO map_entities_values (map_id, name, number) VALUES (2, 'value_1', 2);
INSERT INTO map_entities_values (map_id, name, number) VALUES (3, 'value_1', 4);
INSERT INTO map_entities_values (map_id, name, number) VALUES (3, 'value_2', 5);
INSERT INTO map_entities_values (map_id, name, number) VALUES (4, 'value_1', 6);
INSERT INTO map_entities_values (map_id, name, number) VALUES (5, 'value_1', 7);
INSERT INTO map_entities_values (map_id, name, number) VALUES (5, 'value_2', 2);
INSERT INTO map_entities_values (map_id, name, number) VALUES (5, 'value_3', 8);
INSERT INTO map_entities_values (map_id, name, number) VALUES (5, 'value_4', 9);
INSERT INTO map_entities_values (map_id, name, number) VALUES (1, 'value_3', 10);

INSERT INTO embedded_entities (name, description) VALUES ('embedded_entity_1', 'desc_1');
INSERT INTO embedded_entities (name, description) VALUES ('embedded_entity_2', 'desc_2');
INSERT INTO embedded_entities (name, description) VALUES ('embedded_entity_3', 'desc_3');
INSERT INTO embedded_entities (name, description) VALUES ('embedded_entity_4', 'desc_4');
INSERT INTO embedded_entities (name, description) VALUES ('embedded_entity_5', 'desc_5');

INSERT INTO element_collection_entities (name) VALUES ('element_col_1');
INSERT INTO element_collection_entities (name) VALUES ('element_col_2');
INSERT INTO element_collection_entities (name) VALUES ('element_col_3');
INSERT INTO element_collection_entities (name) VALUES ('element_col_4');
INSERT INTO element_collection_entities (name) VALUES ('element_col_5');

INSERT INTO element_collection_entities_values (collection_id, name, description) VALUES (1, 'name_1', 'desc_1');
INSERT INTO element_collection_entities_values (collection_id, name, description) VALUES (1, 'name_2', 'desc_2');
INSERT INTO element_collection_entities_values (collection_id, name, description) VALUES (2, 'name_1', 'desc_1');
INSERT INTO element_collection_entities_values (collection_id, name, description) VALUES (2, 'name_2', 'desc_2');
INSERT INTO element_collection_entities_values (collection_id, name, description) VALUES (3, 'name_1', 'desc_1');
INSERT INTO element_collection_entities_values (collection_id, name, description) VALUES (3, 'name_2', 'desc_2');
INSERT INTO element_collection_entities_values (collection_id, name, description) VALUES (4, 'name_1', 'desc_1');
INSERT INTO element_collection_entities_values (collection_id, name, description) VALUES (5, 'name_1', 'desc_1');
INSERT INTO element_collection_entities_values (collection_id, name, description) VALUES (5, 'name_2', 'desc_2');
INSERT INTO element_collection_entities_values (collection_id, name, description) VALUES (5, 'name_3', 'desc_3');
INSERT INTO element_collection_entities_values (collection_id, name, description) VALUES (5, 'name_4', 'desc_4');
INSERT INTO element_collection_entities_values (collection_id, name, description) VALUES (1, 'name_3', 'desc_3');
