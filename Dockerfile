# Dockerfile
FROM docker.io/library/openjdk:8-jdk-alpine

RUN mkdir /app
COPY . /app
WORKDIR /app

RUN javac src/main/java/HelloWorld.java

CMD ["java", "-cp", "src/main/java", "HelloWorld"]
