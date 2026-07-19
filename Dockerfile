#Build
FROM maven:3.9.16-eclipse-temurin-26 AS build
COPY pom.xml .
COPY /src ./src
RUN mvn clean package

#Final
FROM eclipse-temurin:21
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
