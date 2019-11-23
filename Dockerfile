FROM openjdk:12-alpine

COPY target/library-demo-*.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]