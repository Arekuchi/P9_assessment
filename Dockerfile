FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} assessment.jar
CMD ["java","-jar","/assessment.jar"]
EXPOSE 8282