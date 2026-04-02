FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom.xml first
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build the jar
RUN mvn clean package -DskipTests

# Runtime image
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]