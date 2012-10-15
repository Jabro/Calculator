package calculator.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import calculator.test.framework.CalculationTestSupport;

public class CalculatorTest implements CalculationTestSupport {

	@Test
	public void testPlus() {
		assertResult(FIRST_OPERAND + SECOND_OPERAND, test(Operator.PLUS));
	}

	@Test
	public void testMinus() {
		assertResult(FIRST_OPERAND - SECOND_OPERAND, test(Operator.MINUS));
	}

	@Test
	public void testMultiplication() {
		assertResult(FIRST_OPERAND * SECOND_OPERAND, test(Operator.MULTIPLICATION));
	}

	@Test
	public void testDivision() {
		assertResult(FIRST_OPERAND / SECOND_OPERAND, test(Operator.DIVISION));
	}

	private void assertResult(double expected, double result) {
		assertEquals(expected, result, INACCURACY);
	}

	private double test(Operator operator) {
		Calculation calculation = new Calculation(FIRST_OPERAND, operator, SECOND_OPERAND);
		return calculation.calculate();
	}

}
