# Fhirest example project

### Create database if needed:
```
docker run -d --restart=unless-stopped --name fhirest-postgres -e POSTGRES_PASSWORD=postgres -p 5151:5432 postgres:14

docker exec -i fhirest-postgres psql -U postgres <<-EOSQL
CREATE ROLE fhirest_admin LOGIN PASSWORD 'test' NOSUPERUSER INHERIT NOCREATEDB CREATEROLE NOREPLICATION;
CREATE ROLE fhirest_app   LOGIN PASSWORD 'test' NOSUPERUSER INHERIT NOCREATEDB CREATEROLE NOREPLICATION;
CREATE DATABASE fhirestdb WITH OWNER = fhirest_admin ENCODING = 'UTF8' TABLESPACE = pg_default CONNECTION LIMIT = -1;
grant temp on database fhirestdb to fhirest_app;
grant connect on database fhirestdb to fhirest_app;
EOSQL
```

### Run application:
```
./gradlew run
```
Env variables:
```
DB_URL #database jdbc url (jdbc:postgresql://localhost:5151/fhirestdb)
DB_POOL_SIZE
DB_APP_USER #database app user, for data read and insert
DB_APP_PASSWORD
DB_ADMIN_USER #database admin user, for altering database (migration, new resource definitions, new indexes)
DB_ADMIN_PASSWORD
DEFS_URL #link to definitions zip.
```
