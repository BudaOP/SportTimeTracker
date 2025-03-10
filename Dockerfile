# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/sportstracker-1.0-SNAPSHOT.jar sportstracker.jar

# Command to run the application
CMD ["java", "-jar", "sportstracker.jar"]
