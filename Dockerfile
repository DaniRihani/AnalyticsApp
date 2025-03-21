# Use a lightweight OpenJDK image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the built JAR file into the container
COPY target/auth-mongodb-app-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar

# Expose a port (if your app runs on a specific port, e.g., 8080)
EXPOSE 8084

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
