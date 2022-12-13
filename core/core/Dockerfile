FROM openjdk:15
RUN mkdir -p app
ADD build/libs/core-0.0.1-SNAPSHOT.jar /app/core-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/core-0.0.1-SNAPSHOT.jar"]
