package com.basti.finance.stockmarket.usecase;

import java.util.List;

import com.basti.finance.stockmarket.entities.CustomerId;
import com.basti.finance.stockmarket.entities.Stock;

public interface PortfolioService {

	public List<Stock> getStocks(CustomerId customerId);
}
