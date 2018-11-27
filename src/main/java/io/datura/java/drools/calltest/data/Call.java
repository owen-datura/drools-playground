package io.datura.java.drools.calltest.data;

import java.time.LocalDateTime;

public class Call {
	private LocalDateTime callTime;
	private CallerDemographics callerDemo;
	private CallerProducts products;
	
	public Call() {
		this(null);
	}
	
	public Call(LocalDateTime callTime) {
		this.callTime = callTime != null ? callTime : LocalDateTime.now();
		callerDemo = new CallerDemographics();
		products = new CallerProducts();
	}

	public LocalDateTime getCallTime() {
		return callTime;
	}

	public CallerDemographics getCallerDemo() {
		return callerDemo;
	}

	public CallerProducts getProducts() {
		return products;
	}
}
