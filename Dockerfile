# Dockerfile
FROM maven:3.8.4-openjdk-8 AS build

COPY . /usr/src/app
WORKDIR /usr/src/app

RUN mvn clean package

FROM openjdk:8-jdk-alpine

COPY --from=build /usr/src/app/target/my-java-app-1.0-SNAPSHOT-jar-with-dependencies.jar /app/app.jar
WORKDIR /app

CMD ["java", "-jar", "app.jar"]
