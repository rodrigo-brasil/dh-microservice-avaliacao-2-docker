FROM openjdk:17-oracle
ARG JAR_FILE=target/catalogservice.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8003