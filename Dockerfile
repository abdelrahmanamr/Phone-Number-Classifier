FROM openjdk:15-alpine
VOLUME /tmp
ADD target/task-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]