# Start with a base image containing Java runtime
FROM openjdk:27-ea-jdk-slim

# Information around who mantains the image
LABEL authors="paco"

# Add the application's jar to the image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

# Exceute the application
ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]