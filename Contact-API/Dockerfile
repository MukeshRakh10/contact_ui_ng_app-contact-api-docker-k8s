FROM eclipse-temurin:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} contact-api.jar
ENTRYPOINT ["java","-jar","/contact-api.jar"]
EXPOSE 1124
