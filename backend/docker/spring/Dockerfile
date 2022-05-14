FROM openjdk:11
WORKDIR /src
COPY . .
CMD ["gradlew" "build" "&&"  "java-" "-jar" "backend-0.0.1-SNAPSHOT.jar" ]