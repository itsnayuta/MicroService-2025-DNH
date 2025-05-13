# Use official OpenJDK base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/result_service-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that the service will run on
EXPOSE 8085

# Run the application
CMD ["java", "-jar", "app.jar"]
