FROM openjdk:11
COPY target/lab1-0.0.1-SNAPSHOT.jar app.jar
CMD ["java","-jar","/app.jar"]

