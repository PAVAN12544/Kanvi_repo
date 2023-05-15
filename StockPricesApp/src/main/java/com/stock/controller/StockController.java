package com.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.entity.Stock;
import com.stock.service.StockService;

@RestController
public class StockController {
	
	@Autowired
	StockService stockService;
	

	@GetMapping("/stocks")
	@SendTo("/topic/stocks")
	public ResponseEntity<List<Stock>> getAllStocks(){
		List<Stock> stocks = stockService.getAllStocks();
		return new ResponseEntity<>(stocks,HttpStatus.OK);
	}
	
	@GetMapping("/hello")
	public String greet() {
		return "Hi, This app shows stock prices of various companies";
	}
}
