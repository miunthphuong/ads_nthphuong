# Build stage
FROM maven:3.9.9-amazoncorretto-24 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Run stage
FROM amazoncorretto:24
WORKDIR /app
COPY --from=builder /app/target/ads-appointment-cli-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]