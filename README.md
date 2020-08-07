# Online-Store
This is a demo/bare-bones project to help others get things up & running in a minimal amount of time.

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

## TODO
- Implement some spring cloud feature.
- Increase test coverage. 
- Implement more realistic business logic. 
- Implement validation.
- Implement this solution with Docker.
- Implement a CI/CD solution of some sort.
- etc.

