FROM openjdk:8-jdk-alpine
#ARG JAR_FILE=target/*.jar
COPY target/assessment.jar assessment.jar
ENTRYPOINT ["java", "-jar", "/assessment.jar"]