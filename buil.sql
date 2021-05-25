SELECT pg_terminate_backend(pid) FROM pg_stat_activity WHERE datname='ejemplo';

DROP DATABASE IF EXISTS "ejemplo";
CREATE DATABASE "ejemplo";
BEGIN;
\c ejemplo
\i create.sql
COMMIT;
grant all privileges on DATABASE ejemplo to jaime;
grant all privileges on all tables in schema public to jaime;
grant all privileges on all sequences in schema public to jaime;
grant all privileges on all functions in schema public to jaime;