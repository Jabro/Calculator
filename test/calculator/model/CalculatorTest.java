package calculator.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import calculator.test.framework.CalculationTestSupport;

public class CalculatorTest implements CalculationTestSupport {

	@Test
	public void testPlus() {
		Calculator calculator = testSingle(Operator.PLUS);
		assertResult(calculator, FIRST_OPERAND + SECOND_OPERAND);
	}

	@Test
	public void testMinus() {
		Calculator calculator = testSingle(Operator.MINUS);
		assertResult(calculator, FIRST_OPERAND - SECOND_OPERAND);
	}

	@Test
	public void testMultiplication() {
		Calculator calculator = testSingle(Operator.MULTIPLICATION);
		assertResult(calculator, FIRST_OPERAND * SECOND_OPERAND);
	}

	@Test
	public void testDivision() {
		Calculator calculator = testSingle(Operator.DIVISION);
		assertResult(calculator, FIRST_OPERAND / SECOND_OPERAND);
	}

	private void assertResult(Calculator calculator, Double expected) {
		assertEquals(expected , calculator.calculateResult(FIRST_OPERAND, SECOND_OPERAND), INACCURACY);
	}


	private Calculator testSingle(Operator operator) {
		Calculator calculator = new Calculator();
		calculator.setOperator(operator);
		return calculator;
	}

}
