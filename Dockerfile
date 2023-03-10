# FROM: Define the base image, parent image
FROM eclipse-temurin:17

# LABEL: Metadata
LABEL mentainer="sametibis"

# WORKDIR: In Docker container, this folder will be the main folder
WORKDIR /app

# COPY: to get jar file into Docker (from - to)
COPY target/springboot-restful-web-services-0.0.1-SNAPSHOT.jar /app/springboot-restful-web-services.jar

# That will configure the command to run jar file in Docker cotainer
ENTRYPOINT ["java", "-jar", "springboot-restful-web-services.jar"]