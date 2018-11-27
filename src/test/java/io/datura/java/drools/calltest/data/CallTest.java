package io.datura.java.drools.calltest.data;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

public class CallTest {

	@Test
	public void testCallDateIsPopulated() {
		Call c = new Call();
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
}
