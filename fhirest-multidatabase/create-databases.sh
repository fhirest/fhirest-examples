docker rm -vf fhirest-store-postgres fhirest-search-postgres fhirest-patient-postgres

docker run -d -e TZ=Europe/Tallinn -e POSTGRES_PASSWORD=postgres --restart=unless-stopped --name fhirest-store-postgres -p 5190:5432 postgres:16
docker run -d -e TZ=Europe/Tallinn -e POSTGRES_PASSWORD=postgres --restart=unless-stopped --name fhirest-search-postgres -p 5191:5432 postgres:16
docker run -d -e TZ=Europe/Tallinn -e POSTGRES_PASSWORD=postgres --restart=unless-stopped --name fhirest-patient-postgres -p 5192:5432 postgres:16

sleep 3

for pgname in fhirest-store-postgres fhirest-search-postgres fhirest-patient-postgres; do
docker exec -i $pgname psql -U postgres <<-EOSQL
CREATE ROLE fhirest_admin LOGIN PASSWORD 'test' NOSUPERUSER INHERIT NOCREATEDB CREATEROLE NOREPLICATION;
CREATE ROLE fhirest_app   LOGIN PASSWORD 'test' NOSUPERUSER INHERIT NOCREATEDB CREATEROLE NOREPLICATION;
CREATE DATABASE fhirestdb WITH OWNER = fhirest_admin ENCODING = 'UTF8' TABLESPACE = pg_default CONNECTION LIMIT = -1;
grant temp on database fhirestdb to fhirest_app;
grant connect on database fhirestdb to fhirest_app;
EOSQL
done


