package com.basti.finance.stockmarket.entities.presenter;

import java.util.List;

import com.basti.finance.stockmarket.entities.Stock;

public class PortfolioResponse {

	private final List<Stock> stocks;

	public PortfolioResponse(final List<Stock> stocks) {
		this.stocks = stocks;
	}

	public List<Stock> getStocks() {
		return stocks;
	}
	
	
}
