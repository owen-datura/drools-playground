package io.datura.java.drools.calltest.data;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

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

	public static LocalDateTime getRandomizedTime() {
		Random r = new Random();
		int dateOffset = r.nextInt(10);
		int hourOffset = r.nextInt(23);
		
		LocalDateTime rdt = LocalDateTime.now();
		rdt = rdt.minus(dateOffset, ChronoUnit.DAYS);
		rdt = rdt.minus(hourOffset, ChronoUnit.HOURS);
		
		return rdt;
	}
}
