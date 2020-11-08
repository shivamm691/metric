FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/MetricCollector-0.0.1-SNAPSHOT.jar Metric.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","/Metric.jar"]
