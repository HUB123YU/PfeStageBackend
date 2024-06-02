 # Use a lightweight Alpine OpenJDK runtime as a base image
#FROM openjdk:17-alpine

# Copy the packaged JAR file from the build stage
#COPY target/*.jar app.jar

# Expose the port
#EXPOSE 8036

# Define the command to run the application
#CMD ["java", "-jar", "app.jar"]

FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/demo-0.0.1-SNAPCHOT.jar demo.jar
EXPOSE 8036
ENTRYPOINT ["java", "-jar", "app.jar"]