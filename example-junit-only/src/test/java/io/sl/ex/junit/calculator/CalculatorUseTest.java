package io.sl.ex.junit.calculator;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CalculatorUseTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCalcSub_realObjects() {
		System.out.println("----------------See this 'testCalcSub_realObjects' is running .........");
		System.out.println("Current class loader:" + getClass().getClassLoader().toString());
		CalculatorUse mgr = new CalculatorUse();
		assertTrue(mgr.calcSub(1, 1) == 0);
	}

}
