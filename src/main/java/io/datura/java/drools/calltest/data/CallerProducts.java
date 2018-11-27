package io.datura.java.drools.calltest.data;

import java.util.EnumSet;

public class CallerProducts {
	private EnumSet<Products> ownedProducts;

	public enum Products {
		SERVERS, EC2_INSTANCES, SWITCHES_GIG_E, SWITCHES_10_GIG_E, INTRUSION_MONITORING, VOIP_PHONES
	}

	// on init, assume no products
	public CallerProducts() {
		ownedProducts = EnumSet.noneOf(Products.class);
	}

	public void addProduct(Products p) {
		ownedProducts.add(p);
	}
	
	public int getNumProducts() {
		return ownedProducts.size();
	}
	
	public boolean hasProduct( Products p ) {
		return ownedProducts.contains(p);
	}
}
