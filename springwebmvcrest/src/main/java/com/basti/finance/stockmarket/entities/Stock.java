package com.basti.finance.stockmarket.entities;

public class Stock {
	
	private final String wkn;
	
	private final String name;
	
	private final double bid;
	
	private final double ask;

	public Stock(final String wkn, final String name, final double bid, final double ask) {
		this.wkn = wkn;
		this.name = name;
		this.bid = bid;
		this.ask = ask;
	}

	public String getWkn() {
		return wkn;
	}

	public String getName() {
		return name;
	}

	public double getBid() {
		return bid;
	}

	public double getAsk() {
		return ask;
	}
	
	
}
