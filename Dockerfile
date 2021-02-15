FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/*.jar
ARG OPEN_NLP_DIR=opennlp
COPY ${JAR_FILE} app.jar
COPY ${OPEN_NLP_DIR} opennlp

ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar
