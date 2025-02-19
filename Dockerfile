FROM openjdk:21-ea-1-jdk

WORKDIR /app
COPY target/api-consumer-db-1.0.0.jar app.jar
COPY Wallet_U5AUF0AX47A4JWYS /app/oracle_wallet
EXPOSE 8081

CMD [ "java", "-jar", "app.jar" ]
