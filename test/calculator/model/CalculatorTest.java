package calculator.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest implements CalculationTest {

	@Test
	public void testPlus() {
		Calculator calculator = testSingle(Operator.PLUS);
		assertResult(calculator, FIRST_OPERAND + SECOND_OPERAND);
	}

	@Test
	public void testPlusPlus() {
		Calculator calculator = testDouble(Operator.PLUS);
		assertResult(calculator, (FIRST_OPERAND + SECOND_OPERAND) + SECOND_OPERAND);
	}

	@Test
	public void testMinus() {
		Calculator calculator = testSingle(Operator.MINUS);
		assertResult(calculator, FIRST_OPERAND - SECOND_OPERAND);
	}

	@Test
	public void testMinusMinus() {
		Calculator calculator = testDouble(Operator.MINUS);
		assertResult(calculator, (FIRST_OPERAND - SECOND_OPERAND) - SECOND_OPERAND);
	}

	@Test
	public void testMultiplication() {
		Calculator calculator = testSingle(Operator.MULTIPLICATION);
		assertResult(calculator, FIRST_OPERAND * SECOND_OPERAND);
	}

	@Test
	public void testMultiplicationMultiplication() {
		Calculator calculator = testDouble(Operator.MULTIPLICATION);
		assertResult(calculator, (FIRST_OPERAND * SECOND_OPERAND) * SECOND_OPERAND);
	}

	@Test
	public void testDivision() {
		Calculator calculator = testSingle(Operator.DIVISION);
		assertResult(calculator, FIRST_OPERAND / SECOND_OPERAND);
	}

	@Test
	public void testDivisionDivision() {
		Calculator calculator = testDouble(Operator.DIVISION);
		assertResult(calculator, (FIRST_OPERAND / SECOND_OPERAND) / SECOND_OPERAND);
	}

	private Calculator testSingle(Operator operator) {
		Calculator calculator = new Calculator();
		setFirstOperand(calculator);
		excuteOperation(calculator, operator);
		setSecondOperand(calculator);
		return calculator;
	}

	private Calculator testDouble(Operator operator) {
		Calculator calculator = testSingle(operator);
		excuteOperation(calculator, operator);
		return calculator;
	}

	private void setFirstOperand(Calculator calculator) {
		calculator.setOperand(FIRST_OPERAND);
	}

	private void setSecondOperand(Calculator calculator) {
		calculator.setOperand(SECOND_OPERAND);
	}

	private double excuteOperation(Calculator calculator, Operator operator) {
		double result = calculator.calculateResult();
		calculator.setOperator(operator);
		return result;
	}

	private void assertResult(Calculator calculator, Double expected) {
		assertEquals(expected , calculator.calculateResult(), INACCURACY);
	}

}
