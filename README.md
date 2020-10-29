# Online-Store
This is a demo/bare-bones project to help others get things up & running in a minimal amount of time.

## Requirements
In order to run this code base, you'll need to use Java 11+, to keep it simple, if you'd like this to run in Java 8, you'll just need to change some cases where I've used [Optional.isEmpty](https://dzone.com/articles/optionalisempty-available-in-jdk-11-ea-builds).

## Run
In order to run this application locally, all that's needed is to have your Java development environment setup, with the assumption that you have [maven](https://maven.apache.org/) installed.

##### Maven
Open your CLI & enter the following command:

```bash 
$ mvn spring-boot:run
```

##### Docker
Open your CLI & enter the following command(s):

```bash 
$ docker build -t online-shop -t online-shop:0.0.1 .
$ docker run -p 80:80 online-shop
```

## The Code
This code has been developed in such a way where I've tried to implement a REST API, using ideas that come from practices such as defensive programming. In the event that you decide to use this code in any scenario, be sure to change or update the values related to unit test coverage in the POM & CVE values. You may find that any CVE(s) with a CVSS of *'x'* is acceptable, I've only used 7 in this example because that's considered quite high.

## TODO
- Implement some spring cloud feature.
- Increase test coverage. 
- Implement more realistic business logic. 
- Implement validation.
- Implement this solution with Docker.
- Implement a CI/CD solution of some sort.
- Add some DB migration code, i.e. liquibase.	
- etc.

