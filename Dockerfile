FROM maven:3.9.9-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim
COPY --from=build /target/bookms-0.0.1-SNAPSHOT.jar bookms.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/bookms.jar"]