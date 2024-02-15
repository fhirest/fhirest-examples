# Fhirest experiments project:
total 3 separate databases: store, search, patient

### Create database if needed:
```
docker rm -vf fhirest-store-postgres fhirest-search-postgres

docker run -d -e TZ=Europe/Tallinn -e POSTGRES_PASSWORD=postgres --restart=unless-stopped --name fhirest-store-postgres -p 5190:5432 postgres:16
docker exec -e "DB_NAME=fhirestdb" -e "USER_PREFIX=fhirest" fhirest-store-postgres /opt/scripts/createdb.sh

docker run -d -e TZ=Europe/Tallinn -e POSTGRES_PASSWORD=postgres --restart=unless-stopped --name fhirest-search-postgres -p 5191:5432 postgres:16
docker exec -e "DB_NAME=fhirestdb" -e "USER_PREFIX=fhirest" fhirest-search-postgres /opt/scripts/createdb.sh

docker run -d -e TZ=Europe/Tallinn -e POSTGRES_PASSWORD=postgres --restart=unless-stopped --name fhirest-patient-postgres -p 5192:5432 postgres:16
docker exec -e "DB_NAME=fhirestdb" -e "USER_PREFIX=fhirest" fhirest-patient-postgres /opt/scripts/createdb.sh
```

### Run application:
```
./gradlew bootRun
```
