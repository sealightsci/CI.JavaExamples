package io.sl.ex.junit.calculator;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({CalculatorFactory.class})
@PowerMockIgnore("javax.management.*")
public class CalculatorUsePowerMockRunnerTest {
	
	@Mock
	Calculator calc;
	@Spy
	@InjectMocks
	CalculatorUse calcUse = new CalculatorUse();

	@Before
	public void setUp() throws Exception {
		PowerMockito.mockStatic(CalculatorFactory.class);
	}

	@Test
	public void testCalcSum_wihMocks() {
		System.out.println("-----------------See this 'testCalcSum_wihMocks' is running .........");
		System.out.println("Current class loader:" + getClass().getClassLoader().toString());
		when(calc.doSum(1, 1)).thenReturn(0);
		when(CalculatorFactory.createCalculator()).thenReturn(calc);
		assertTrue(calcUse.calcSum(1, 1) == 0);
		//verify(calc).doSum(1, 1);
	}

}
