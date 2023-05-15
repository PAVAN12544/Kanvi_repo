package com.stock.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stockId;
	private String stockName;
	private int stockPrice;
	public Stock() {
		super();
	}
	public Stock(int stockId, String stockName, int stockPrice) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.stockPrice = stockPrice;
	}
	public Stock(String stockName, int stockPrice) {
		super();
		this.stockName = stockName;
		this.stockPrice = stockPrice;
	}
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public int getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(int stockPrice) {
		this.stockPrice = stockPrice;
	}
	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockName=" + stockName + ", stockPrice=" + stockPrice + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		
		Stock other = (Stock) obj;
		if(this.stockId == other.stockId) {
			return true;
		}
		return false;
	}
	
	
	
}
