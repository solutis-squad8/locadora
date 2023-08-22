FROM maven:3.8.4-openjdk-17-slim AS builder

ARG jar_file=out/artifacts/locadora_jar/*.jar

COPY ${jar_file} app.jar

ENTRYPOINT ["java","-jar", "/app.jar"]

EXPOSE 8080