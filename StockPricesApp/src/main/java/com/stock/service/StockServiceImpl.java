package com.stock.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.stock.entity.Stock;
import com.stock.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;

	@Scheduled(fixedRate = 2000)
	public void updateAppleStockPrice() {
		Optional<Stock> stockOptional = stockRepository.findByStockName("Apple");

		if (stockOptional.isPresent()) {
			Stock stock = stockOptional.get();
			int newPrice = generateRandomPrice();
			stock.setStockPrice(newPrice);
			stockRepository.save(stock);
			
		}
	}
	
	@Scheduled(fixedRate = 3000)
	public void updateIBMStockPrice() {
		Optional<Stock> stockOptional = stockRepository.findByStockName("IBM");

		if (stockOptional.isPresent()) {
			Stock stock = stockOptional.get();
			int newPrice = generateRandomPrice();
			stock.setStockPrice(newPrice);
			stockRepository.save(stock);
		}
	}
	
	@Scheduled(fixedRate = 1000)
	public void updateInfosysStockPrice() {
		Optional<Stock> stockOptional = stockRepository.findByStockName("Infosys");

		if (stockOptional.isPresent()) {
			Stock stock = stockOptional.get();
			int newPrice = generateRandomPrice();
			stock.setStockPrice(newPrice);
			stockRepository.save(stock);
		}
	}
	
	@Scheduled(fixedRate = 2500)
	public void updateRelianceStockPrice() {
		Optional<Stock> stockOptional = stockRepository.findByStockName("Reliance");

		if (stockOptional.isPresent()) {
			Stock stock = stockOptional.get();
			int newPrice = generateRandomPrice();
			stock.setStockPrice(newPrice);
			stockRepository.save(stock);
		}
	}
	
	@Scheduled(fixedRate = 1500)
	public void updateZensarStockPrice() {
		Optional<Stock> stockOptional = stockRepository.findByStockName("Zensar");

		if (stockOptional.isPresent()) {
			Stock stock = stockOptional.get();
			int newPrice = generateRandomPrice();
			stock.setStockPrice(newPrice);
			stockRepository.save(stock);
		}
	}
	
	@Scheduled(fixedDelay = 3000)
	public void updatedPrice() {
		simpMessagingTemplate.convertAndSend("/topic/stocks", stockRepository.findAll());
	}
	

	
	private int generateRandomPrice() {
		Random rand = new Random();
		int min = 50;
		int max = 200;
		return rand.nextInt((max - min) + 1) + min;
	}

	@Override
	public List<Stock> getAllStocks() {

		return stockRepository.findAll();
	}

}
