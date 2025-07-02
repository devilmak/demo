# Use a lightweight OpenJDK base image
FROM openjdk:23-slim

# Set a working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar
#COPY . .

# Expose the port your app runs on (usually 8080)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]