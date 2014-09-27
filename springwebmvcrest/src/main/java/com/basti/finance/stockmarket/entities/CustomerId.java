package com.basti.finance.stockmarket.entities;

public class CustomerId {

	private final long customerId;

	public CustomerId(final long customerId) {
		this.customerId = customerId;
	}

	public long getCustomerId() {
		return customerId;
	}
	
	public static CustomerId valueOf(String customerId) {
		return new CustomerId(Long.valueOf(customerId));
	}
	
}
