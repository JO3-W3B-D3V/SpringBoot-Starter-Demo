# Build stage
FROM maven:3.6.0-jdk-11-slim AS build
COPY src ./src
COPY pom.xml ./
COPY suppress.xml ./
RUN mvn clean install

# Package stage
FROM openjdk:11-jre-slim
COPY /target/Online-Store*.jar app.jar
EXPOSE 80
ENTRYPOINT ["sh", "-c", "java -showversion -XshowSettings:vm -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=docker -jar /app.jar"]