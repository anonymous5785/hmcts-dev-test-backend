FROM openjdk:21-jdk
ARG JAR_FILE=./build/libs/test-backend.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "/application.jar"]
