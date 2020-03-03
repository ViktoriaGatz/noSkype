FROM openjdk:8
ADD build/libs/spring-rest-service-0.1.0.jar spring-rest-service-0.1.0.jar
COPY src/main/resources/templates src/main/resources/templates/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-rest-service-0.1.0.jar"]
