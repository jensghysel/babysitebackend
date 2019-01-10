FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY target/babysite-0.0.1-SNAPSHOT.jar app.jar
# Make port 8080 available to the world outside this container
EXPOSE 8080
EXPOSE 8001
ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,address=8001,server=y,suspend=n","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]