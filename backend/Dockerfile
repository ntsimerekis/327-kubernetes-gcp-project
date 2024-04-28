FROM gradle:8.7.0-jdk-alpine AS TEMP_BUILD_IMAGE
WORKDIR /usr/app/
COPY . .
RUN gradle build

FROM openjdk:latest
ENV JAR_NAME=app.jar
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY --from=BUILD $APP_HOME .
EXPOSE 8080
ENTRYPOINT exec java -jar $APP_HOME/build/libs/$JAR_NAME
