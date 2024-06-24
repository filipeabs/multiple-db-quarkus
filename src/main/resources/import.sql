-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

-- When using with quarkus.hibernate-orm."persistence-unit-name".sql-load-script configuration, 
-- this script can contain any SQL Data Manipulation Language (DML) statements

-- In our project we use this script to generate both DDL and DML statements. 
-- And it is applied via 'INIT' parameter and option 'RUNSCRIPT FROM' in the JDBC URL for H2 database.  
CREATE SCHEMA IF NOT EXISTS MYDB AUTHORIZATION SA;

CREATE TABLE IF NOT EXISTS MYDB.INFORMACOES (
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    FIELD VARCHAR(255),
    TS_STAMP TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DELETE MYDB.INFORMACOES;

-- INSERT INTO MYDB.INFORMACOES (ID, FIELD, TS_STAMP) 
-- VALUES (1, 'INSERT DE TESTE 1', CURRENT_TIMESTAMP());

-- INSERT INTO MYDB.INFORMACOES (ID, FIELD, TS_STAMP) 
-- VALUES (2, 'INSERT DE TESTE 2', CURRENT_TIMESTAMP());