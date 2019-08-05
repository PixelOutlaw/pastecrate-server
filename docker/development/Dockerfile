FROM openjdk:8-jdk-slim
RUN mkdir /app
VOLUME /app
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["./gradlew", "bootRun"]
