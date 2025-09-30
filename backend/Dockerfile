FROM maven:3.9-eclipse-temurin-21 AS builder

WORKDIR /app
COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21

WORKDIR /menu

COPY --from=builder /app/target/backend-0.0.1-SNAPSHOT.jar /backend.jar

ENTRYPOINT [ "java", "-jar", "/backend.jar"]

EXPOSE 8080