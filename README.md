# Tester matching app

App for serving testers experience data based on CSV data.

## Requirements

For building and running the application you need:

- JDK 1.11
- Maven 3


## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `pl.rek.testermatching.Application` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
Or run JAR file which will be generate as an output of one of the commands

```shell
mvn install
```
```shell
mvn package
```

## Data providing

CSV files should be put in application resources

## Example usage

The most basic usage of the app after running it locally is to perform http GET request like this

```shell
GET http://localhost:8081/testers/experience?countries={COUNTRIES}&deviceIds={DEVICE_IDS}

GET http://localhost:8081/testers/experience?countries=GB,US&deviceIds=1,2
```
