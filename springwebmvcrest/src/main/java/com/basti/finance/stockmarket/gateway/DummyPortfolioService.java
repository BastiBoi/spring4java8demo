package com.basti.finance.stockmarket.gateway;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.basti.finance.stockmarket.entities.CustomerId;
import com.basti.finance.stockmarket.entities.Stock;
import com.basti.finance.stockmarket.usecase.PortfolioService;

@Named
public class DummyPortfolioService implements PortfolioService {

	@Override
	public List<Stock> getStocks(CustomerId customerId) {
		List<Stock> portfolioItems = new ArrayList<>();
		portfolioItems.add(new Stock("CBK100","COMMERZBANK AG",12.298,12.338));
		portfolioItems.add(new Stock("519000","BMW",86.148,86.248));
		return portfolioItems;
	}
	
}