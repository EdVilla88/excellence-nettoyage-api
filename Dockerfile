FROM openjdk:17
COPY ./target/excellence-0.0.1-SNAPSHOT.jar /usr/src/excellence/
EXPOSE 8080
WORKDIR /usr/src/excellence/
CMD ["java", "-jar", "excellence-0.0.1-SNAPSHOT.jar"]