# FHIREST Demo Chart

## Installing PostgreSQL server

Postgresql can be installed via [Bitnami PostgreSQL Helm Chart](https://github.com/bitnami/charts/tree/master/bitnami/postgresql). It is required to create
database and base users. Remember to change `test` passwords.

```shell
helm install fhirest-pg oci://registry-1.docker.io/bitnamicharts/postgresql
```

## Installing the Chart

To install the chart with the release name `fhirest`:

```console
$ helm install fhirest https://github.com/fhirest/fhirest-examples/raw/master/fhirest-demo/etc/helm/fhirest-demo/fhirest-demo-1.0.0.tgz
```

These commands deploy FHIREST on the Kubernetes cluster in the default configuration. The [Parameters](#parameters) section lists the parameters that can be
configured during installation.

> **Tip**: List all releases using `helm list`

## Uninstalling the Chart

To uninstall/delete the `fhirest` release:

```console
$ helm delete fhirest
```

The command removes all the Kubernetes components associated with the chart and deletes the release. Remove also the chart using `--purge` option:

```console
$ helm delete --purge  fhirest
```

## Parameters

### FHIREST deployment parameters

| Name                      | Description                    | Value                                             |
|---------------------------|--------------------------------|---------------------------------------------------|
| `image.repository`        | FHIREST backend image          | `"ghcr.io/fhirest/fhirest-examples/fhirest-demo"` |
| `image.tag`               | FHIREST backend image  version | `"latest"`                                        |
| `replicas`                | Number of replicas             | `1`                                               |
| `fhirest.limits.cpu`      | CPU resource limit             | `2`                                               |
| `fhirest.limits.memory`   | Memory resource limit          | `3072Mi`                                          |
| `fhirest.requests.cpu`    | Requested CPU resource         | `200m`                                            |
| `fhirest.requests.memory` | Requested memory resource      | `512Mi`                                           |

### FHIR parameters

| Name                                         | Description          | Value                                                                     |
|----------------------------------------------|----------------------|---------------------------------------------------------------------------|
| `config.FHIREST_CONFORMANCE_DEFINITIONS_URL` | FHIR definitions url | `"https://kexus.kodality.com/repository/store-public/kefhir/defs-r5.zip"` |

### Ingress parameters

| Name           | Description                                 | Value             |
|----------------|---------------------------------------------|-------------------|
| `ingress.host` | FHIREST host                                | `"fhirest.local"` |
| `ingress.path` | FHIREST context path for ingress controller | `"/"`             |
| `ingress.tls`  | TLS configuration                           | `[]`              |

### PostgreSQL parameters

| Name                      | Description             | Value                                                      |
---------------------------|-------------------------|------------------------------------------------------------|
| `postgres.url`            | Postgres JDBC URL       | `"jdbc:postgresql://fhirest-pg-postgresql:5432/fhirestdb"` |
| `postgres.dbPoolSize`     | DB connection pool size | `10`                                                       |
| `postgres.admin.user`     | DB owner's user  name   | `fhirest_admin`                                            |
| `postgres.admin.password` | DB owner's password     | `test`                                                     |
| `postgres.user.user`      | DB user's username      | `fhirest_app`                                              |
| `postgres.user.password`  | DB user's password      | `test`                                                     |
