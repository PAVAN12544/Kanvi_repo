FROM openjdk:11 as build
ADD target/StockPricesApp-0.0.1-SNAPSHOT.jar StockPricesApp.jar
ENTRYPOINT ["java", "-jar", "StockPricesApp.jar"]
EXPOSE 9999
ENV spring.datasource.url=jdbc:mysql://host.docker.internal:3306/stockprices