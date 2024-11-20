FROM openjdk:21-jdk-slim
VOLUME /tmp
EXPOSE 8100
ADD ./target/currency-conversion-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]