FROM openjdk:11



COPY scheduling-ms-ws/target/scheduling-spring-boot.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]


