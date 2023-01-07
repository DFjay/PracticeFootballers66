create role admin_database with CREATEDB CREATEROLE;
create SCHEMA IF NOT EXISTS ${flyway:defaultSchema} AUTHORIZATION admin_database;