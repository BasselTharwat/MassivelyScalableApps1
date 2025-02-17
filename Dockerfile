FROM openjdk:25-ea-4-jdk-oraclelinux9

WORKDIR /app

COPY target/ target/

ENV Name Docker_Bassel Tharwat

EXPOSE 8080

ENTRYPOINT ["java" ,"-jar" , "target/Lab2t23.jar"]
