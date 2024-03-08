FROM eclipse-temurin:17-jdk-alpine
LABEL authors="rami.ben-dhia"

VOLUME /tmp
COPY target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
