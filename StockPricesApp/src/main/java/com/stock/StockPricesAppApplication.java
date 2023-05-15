package com.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StockPricesAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockPricesAppApplication.class, args);
	}

}
