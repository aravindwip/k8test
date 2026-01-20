FROM openjdk:17.0.2-jdk

WORKDIR /app

COPY target/mvnproj-1.0.jar /app/app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]


