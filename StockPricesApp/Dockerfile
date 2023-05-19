FROM openjdk:11 as build
ADD target/StockPricesApp-0.0.1-SNAPSHOT.jar StockPricesApp.jar
ENTRYPOINT ["java", "-jar", "StockPricesApp.jar"]
EXPOSE 9999
ENV spring.datasource.url=jdbc:mysql://database-1.cyiteo93yipv.eu-north-1.rds.amazonaws.com:3306/Stockprices