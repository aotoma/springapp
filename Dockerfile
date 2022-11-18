from openjdk:16
copy ./build/libs/demo-0.0.1-SNAPSHOT.jar ./app.jar
entrypoint ["java", "-jar", "./app.jar"]
