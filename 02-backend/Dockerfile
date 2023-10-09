# Use a lightweight base image with Java 17
FROM adoptopenjdk/openjdk17:jdk-17.0.0_35-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled Spring Boot JAR file into the container
COPY target/your-spring-boot-app.jar app.jar

# Install Maven (if not already installed)
RUN apk add --no-cache maven

# Build the Spring Boot application using Maven
RUN mvn clean install -DskipTests

# Expose the port that your Spring Boot application will run on
EXPOSE 8080

# Specify the command to run your Spring Boot application
CMD ["java", "-jar", "app.jar"]
