package io.sl.ex.junit.calculator;

public class CalculatorUse {

	public int calcSum(int a, int b) {
		Calculator calc = CalculatorFactory.createCalculator();
		return calc.doSum(a, b);
	}

	public int calcSub(int a, int b) {
		Calculator calc = CalculatorFactory.createCalculator();
		return calc.doSub(a, b);
	}
	
	public int calcMul(int a, int b) {
		Calculator calc = CalculatorFactory.createCalculator();
		return calc.doMul(a, b);
	}
}
