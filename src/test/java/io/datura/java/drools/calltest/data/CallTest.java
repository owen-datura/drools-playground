package io.datura.java.drools.calltest.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class CallTest {

	@Test
	public void testCallDateIsPopulated() {
		Call c = new Call();
		assertNotNull(c.getCallTime());
	}
}
