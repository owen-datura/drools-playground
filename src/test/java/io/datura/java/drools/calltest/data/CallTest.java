package io.datura.java.drools.calltest.data;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import io.datura.java.drools.calltest.data.CallerProducts.Products;

public class CallTest {

	@Test
	public void testCallDateIsPopulated() {
		Call c = new Call(1l);
		assertNotNull(c.getCallTime());
	}

	@Test
	public void testRandomDateGeneration() {
		LocalDateTime ldt = Call.getRandomizedTime();
		assertNotNull(ldt);
	}

	@Test
	public void testRandomDateIsInPast() {
		LocalDateTime ldt = Call.getRandomizedTime();
		assertTrue(LocalDateTime.now().isAfter(ldt));
	}

	@Test
	public void testEmptyProductSet() {
		Call c = new Call(1l);
		assertEquals(0l, c.getProducts().getNumProducts());
	}

	@Test
	public void testAddProduct() {
		Call c = new Call(1l);
		c.getProducts().addProduct(Products.EC2_INSTANCES);
		c.getProducts().addProduct(Products.EC2_INSTANCES);
		c.getProducts().addProduct(Products.EC2_INSTANCES);
		assertEquals(1l, c.getProducts().getNumProducts());

		assertTrue(c.getProducts().hasProduct(Products.EC2_INSTANCES));
	}
}
