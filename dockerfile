FROM gradle:9.4-jdk21 AS build
WORKDIR /app
COPY build.gradle.kts settings.gradle.kts ./
COPY src ./src

RUN gradle bootJar

FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app/jar

EXPOSE 80
ENTRYPOINT ["java", "-jar", "app.jar"]