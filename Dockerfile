#Verwendung von jdk-alpine als Basis Image
FROM openjdk:12-jdk-alpine
#Port für Docker freigeben
EXPOSE 8020
#Kopieren der .jar auf den Container
COPY target/microservice_dementiell_veraenderter-0.0.1-SNAPSHOT.jar app.jar
#Startpunkt für den Service festlegen
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","./app.jar"]