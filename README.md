# multiple-db-quarkus

A good way to train and explain the use of more than one data source in Quarkus <img src="https://quarkus.io/assets/images/brand/quarkus_icon_default.svg" alt="quarkus-logo" style="width:20px;"/>.


If you wanna create your own `multiple-db-quarkus` check this command out below. 
*You can change your groupId and ArtifactId to your preference.*

```
mvn io.quarkus.platform:quarkus-maven-plugin:3.9.5:create \
    -DprojectGroupId=dev.filipeabs \
    -DprojectArtifactId=multiple-db-quarkus \
    -Dextensions='quarkus-rest','quarkus-jdbc-h2','io.quarkus:quarkus-hibernate-orm'
cd multiple-db-quarkus
```

You can find more information about maven commands above at https://quarkus.io/guides/maven-tooling.

> **_NOTE:_** Additional quarkus extensions with good features that can help you:
> 1. 'quarkus-rest-jackson': support for JSON serialization/deserialization using the Jackson library 
> 2. 'quarkus-smallrye-openapi': expose an [OpenAPI v3 specification](https://github.com/OAI/OpenAPI-Specification/blob/main/versions/3.0.0.md) documentation
>
> _Obs: You can find more information about OpenAPI and Swagger at https://quarkus.io/guides/openapi-swaggerui ._


### H2 Database
We are using H2 database, and you can get valuables informations at https://www.h2database.com/

And some good features at https://www.h2database.com/html/features.html#database_url

## Quarkus <img src="https://quarkus.io/assets/images/brand/quarkus_icon_default.svg" alt="quarkus-logo" style="width:20px;"/>

As we can see, this project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Table of contents

> **_NOTE:_** I had one real scenario at work that challenged me to discovery how to deal with the same database tables but different sites. So, inspired by this Felipe Windmoller's project [poc-quarkus-multiple-datasources](https://github.com/felipewind/poc-quarkus-multiple-datasources), I tried to reach this scenario out with quarkus and microservice archtecture.

> **_NOTE:_** The H2 console should be available at http://localhost:8080/h2. Some good information about it you can get at CodeWithJuanco's Quarkus H2 Github codebase: [Quakus-H2] (https://github.com/CodeWithJuancho/Quarkus-H2).

### What do we need to keep in mind?

The most important set of subjects we need to study and understand is about [Quarkus JDBC](https://quarkus.io/guides/datasource) and [Quarkus Hibernate ORM](https://quarkus.io/guides/hibernate-orm) - *of course, those Quarkus implementations of them*.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/multiple-db-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- Hibernate ORM ([guide](https://quarkus.io/guides/hibernate-orm)): Define your persistent model with Hibernate ORM and Jakarta Persistence
- REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- JDBC Driver - H2 ([guide](https://quarkus.io/guides/datasource)): Connect to the H2 database via JDBC

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)



### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
