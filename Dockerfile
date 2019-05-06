FROM openjdk:11-jre-slim

ADD target/hello-world-*.jar /opt/app.jar

EXPOSE 8080

ENV JAVA_PARAMS=""

ENV JAVA_OPTS=""

ENTRYPOINT exec java $JAVA_OPTS -jar /opt/app.jar $JAVA_PARAMS
