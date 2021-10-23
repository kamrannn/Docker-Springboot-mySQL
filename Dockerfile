FROM openjdk:8
COPY ./target/springbootproject-0.0.1-SNAPSHOT.jar springbootproject-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java","-jar","springbootproject-0.0.1-SNAPSHOT.jar"]