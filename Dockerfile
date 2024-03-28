FROM eclipse-temurin:17-jdk-alpine
LABEL authors="rami.bendhia"

#VOLUME /tmp
COPY target/springboot-mysql-0.0.2-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
