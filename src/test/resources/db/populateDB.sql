INSERT INTO simple_entities (id, name) VALUES (1, 'entity_1');
INSERT INTO simple_entities (id, name) VALUES (2, 'entity_2');
INSERT INTO simple_entities (id, name) VALUES (3, 'entity_3');
INSERT INTO simple_entities (id, name) VALUES (4, 'entity_4');
INSERT INTO simple_entities (id, name) VALUES (5, 'entity_5');
INSERT INTO simple_entities (id, name) VALUES (6, 'entity_6');
INSERT INTO simple_entities (id, name) VALUES (7, 'entity_7');
INSERT INTO simple_entities (id, name) VALUES (8, 'entity_8');
INSERT INTO simple_entities (id, name) VALUES (9, 'entity_9');
INSERT INTO simple_entities (id, name) VALUES (10, 'entity_10');
INSERT INTO simple_entities (id, name) VALUES (11, 'entity_11');
INSERT INTO simple_entities (id, name) VALUES (12, 'entity_12');
INSERT INTO simple_entities (id, name) VALUES (13, 'entity_13');
INSERT INTO simple_entities (id, name) VALUES (14, 'entity_14');
INSERT INTO simple_entities (id, name) VALUES (15, 'entity_15');
INSERT INTO simple_entities (id, name) VALUES (16, 'entity_16');
INSERT INTO simple_entities (id, name) VALUES (17, 'entity_17');
INSERT INTO simple_entities (id, name) VALUES (18, 'entity_18');
INSERT INTO simple_entities (id, name) VALUES (19, 'entity_19');
INSERT INTO simple_entities (id, name) VALUES (20, 'entity_20');
INSERT INTO simple_entities (id, name) VALUES (21, 'entity_21');
INSERT INTO simple_entities (id, name) VALUES (22, 'entity_22');
INSERT INTO simple_entities (id, name) VALUES (23, 'entity_23');
INSERT INTO simple_entities (id, name) VALUES (24, 'entity_24');
INSERT INTO simple_entities (id, name) VALUES (25, 'entity_25');
INSERT INTO simple_entities (id, name) VALUES (26, 'entity_26');
INSERT INTO simple_entities (id, name) VALUES (27, 'entity_27');
INSERT INTO simple_entities (id, name) VALUES (28, 'entity_28');
INSERT INTO simple_entities (id, name) VALUES (29, 'entity_29');
INSERT INTO simple_entities (id, name) VALUES (30, 'entity_30');

INSERT INTO boolean_converter_entities (id, flag) VALUES (1, 'T');
INSERT INTO boolean_converter_entities (id, flag) VALUES (2, 'B');
INSERT INTO boolean_converter_entities (id, flag) VALUES (3, 'F');
INSERT INTO boolean_converter_entities (id, flag) VALUES (4, 'F');
INSERT INTO boolean_converter_entities (id, flag) VALUES (5, 'T');
INSERT INTO boolean_converter_entities (id, flag) VALUES (6, 'T');
INSERT INTO boolean_converter_entities (id, flag) VALUES (7, 'B');
INSERT INTO boolean_converter_entities (id, flag) VALUES (8, 'B');
INSERT INTO boolean_converter_entities (id, flag) VALUES (9, 'B');

INSERT INTO enum_entities (id, enum_string, enum_ordinal) VALUES (1, 'TWO', 2);
INSERT INTO enum_entities (id, enum_string, enum_ordinal) VALUES (2, 'ONE', 0);
INSERT INTO enum_entities (id, enum_string, enum_ordinal) VALUES (3, 'THREE', 1);
INSERT INTO enum_entities (id, enum_string, enum_ordinal) VALUES (4, 'TWO', 2);

INSERT INTO date_entities (id, calendar_date, java_date, sql_date) VALUES (1, '1990-02-03', '1990-02-03', '1990-02-03');
INSERT INTO date_entities (id, calendar_date, java_date, sql_date) VALUES (2, '1991-05-02', '1991-05-02', '1991-05-02');
INSERT INTO date_entities (id, calendar_date, java_date, sql_date) VALUES (3, '1990-02-03', '1990-02-03', '1990-02-03');
INSERT INTO date_entities (id, calendar_date, java_date, sql_date) VALUES (4, '1995-01-02', '1995-01-02', '1995-01-02');
INSERT INTO date_entities (id, calendar_date, java_date, sql_date) VALUES (5, '1992-01-01', '1992-01-01', '1992-01-01');
INSERT INTO date_entities (id, calendar_date, java_date, sql_date) VALUES (6, '1996-12-24', '1996-12-24', '1996-12-24');

INSERT INTO time_entities (id, calendar_time, java_time, sql_time) VALUES (1, '11:22:33', '11:22:33', '11:22:33');
INSERT INTO time_entities (id, calendar_time, java_time, sql_time) VALUES (2, '11:11:11', '11:11:11', '11:11:11');
INSERT INTO time_entities (id, calendar_time, java_time, sql_time) VALUES (3, '11:22:33', '11:22:33', '11:22:33');
INSERT INTO time_entities (id, calendar_time, java_time, sql_time) VALUES (4, '03:15:10', '03:15:10', '03:15:10');
INSERT INTO time_entities (id, calendar_time, java_time, sql_time) VALUES (5, '12:00:00', '12:00:00', '12:00:00');
INSERT INTO time_entities (id, calendar_time, java_time, sql_time) VALUES (6, '01:10:10', '01:10:10', '01:10:10');

INSERT INTO timestamp_entities (id, calendar_timestamp, java_timestamp, sql_timestamp) VALUES (1, '1990-02-03 11:22:33', '1990-02-03 11:22:33', '1990-02-03 11:22:33');
INSERT INTO timestamp_entities (id, calendar_timestamp, java_timestamp, sql_timestamp) VALUES (2, '1991-05-02 11:11:11', '1991-05-02 11:11:11', '1991-05-02 11:11:11');
INSERT INTO timestamp_entities (id, calendar_timestamp, java_timestamp, sql_timestamp) VALUES (3, '1990-02-03 11:22:33', '1990-02-03 11:22:33', '1990-02-03 11:22:33');
INSERT INTO timestamp_entities (id, calendar_timestamp, java_timestamp, sql_timestamp) VALUES (4, '1995-01-02 03:15:10', '1995-01-02 03:15:10', '1995-01-02 03:15:10');
INSERT INTO timestamp_entities (id, calendar_timestamp, java_timestamp, sql_timestamp) VALUES (5, '1992-01-01 12:00:00', '1992-01-01 12:00:00', '1992-01-01 12:00:00');
INSERT INTO timestamp_entities (id, calendar_timestamp, java_timestamp, sql_timestamp) VALUES (6, '1996-12-24 01:10:10', '1996-12-24 01:10:10', '1996-12-24 01:10:10');

INSERT INTO collection_entities (id, name) VALUES (1, 'col_entity_1');
INSERT INTO collection_entities (id, name) VALUES (2, 'col_entity_2');
INSERT INTO collection_entities (id, name) VALUES (3, 'col_entity_3');
INSERT INTO collection_entities (id, name) VALUES (4, 'col_entity_4');
INSERT INTO collection_entities (id, name) VALUES (5, 'col_entity_5');

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

INSERT INTO map_entities (id, name) VALUES (1, 'map_entity_1');
INSERT INTO map_entities (id, name) VALUES (2, 'map_entity_2');
INSERT INTO map_entities (id, name) VALUES (3, 'map_entity_3');
INSERT INTO map_entities (id, name) VALUES (4, 'map_entity_4');
INSERT INTO map_entities (id, name) VALUES (5, 'map_entity_5');

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

INSERT INTO embedded_entities (id, name, description) VALUES (1, 'embedded_entity_1', 'desc_1');
INSERT INTO embedded_entities (id, name, description) VALUES (2, 'embedded_entity_2', 'desc_2');
INSERT INTO embedded_entities (id, name, description) VALUES (3, 'embedded_entity_3', 'desc_3');
INSERT INTO embedded_entities (id, name, description) VALUES (4, 'embedded_entity_4', 'desc_4');
INSERT INTO embedded_entities (id, name, description) VALUES (5, 'embedded_entity_5', 'desc_5');

INSERT INTO element_collection_entities (id, name) VALUES (1, 'element_col_1');
INSERT INTO element_collection_entities (id, name) VALUES (2, 'element_col_2');
INSERT INTO element_collection_entities (id, name) VALUES (3, 'element_col_3');
INSERT INTO element_collection_entities (id, name) VALUES (4, 'element_col_4');
INSERT INTO element_collection_entities (id, name) VALUES (5, 'element_col_5');

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

INSERT INTO multiple_table_inherit_root_entities (id, name, discriminator) VALUES (1, 'multi_inherit_1', 'A');
INSERT INTO multiple_table_inherit_root_entities (id, name, discriminator) VALUES (2, 'multi_inherit_2', 'B');
INSERT INTO multiple_table_inherit_root_entities (id, name, discriminator) VALUES (3, 'multi_inherit_3', 'A');
INSERT INTO multiple_table_inherit_root_entities (id, name, discriminator) VALUES (4, 'multi_inherit_4', 'B');

INSERT INTO multiple_table_inherit_value_entities (id, value) VALUES (1, 11);
INSERT INTO multiple_table_inherit_value_entities (id, value) VALUES (3, 22);

INSERT INTO multiple_table_inherit_description_entities (id, description) VALUES (2, 'desc_2');
INSERT INTO multiple_table_inherit_description_entities (id, description) VALUES (4, 'desc_4');

INSERT INTO per_class_table_inherit_value_entities (id, name, value) VALUES (1, 'per_class_inherit_1', 11);
INSERT INTO per_class_table_inherit_value_entities (id, name, value) VALUES (3, 'per_class_inherit_3', 22);

INSERT INTO per_class_table_inherit_description_entities (id, name, description) VALUES (2, 'per_class_inherit_2', 'desc_2');
INSERT INTO per_class_table_inherit_description_entities (id, name, description) VALUES (4, 'per_class_inherit_4', 'desc_4');
