FROM maven:3.8.3-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn verify clean --fail-never

COPY . .

RUN mvn clean install -DskipTests

FROM openjdk:17-alpine AS run
COPY --from=build /app/target/*.jar app.jar
EXPOSE 9002
ENTRYPOINT ["java", "-jar", "app.jar"]