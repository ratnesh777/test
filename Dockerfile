FROM openjdk:8-jdk-alpine
COPY mspoc-0.0.1.jar /usr/src/poc/
WORKDIR /usr/src/poc
EXPOSE 8443
CMD ["java", "-jar", "mspoc-0.0.1.jar"]