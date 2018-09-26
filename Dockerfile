FROM openjdk:8-jre-alpine
VOLUME /tmp
COPY build/libs/rayson-service.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
