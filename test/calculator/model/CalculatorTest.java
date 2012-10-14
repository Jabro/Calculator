package calculator.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

	private static final double INACCURACY = 0.0000000001;

	@Test
	public void testPlusCalculate() {
		Calculator calculator = new Calculator();
		calculator.setOperand(3);
		excuteOperation(calculator, Operator.PLUS);
		calculator.setOperand(4);
		assertEquals(3 + 4, calculator.calculateResult(), INACCURACY);
	}
	
	@Test
	public void testPlusPlus() {
		Calculator calculator = new Calculator();
		calculator.setOperand(3);
		excuteOperation(calculator, Operator.PLUS);
		assertEquals(3 + 3, excuteOperation(calculator, Operator.PLUS), INACCURACY);
	}
	
	@Test
	public void testMinusCalculate() {
		Calculator calculator = new Calculator();
		calculator.setOperand(3);
		excuteOperation(calculator, Operator.MINUS);
		calculator.setOperand(4);
		assertEquals(3 - 4, calculator.calculateResult(), INACCURACY);
	}
	
	@Test
	public void testMinusMinus() {
		Calculator calculator = new Calculator();
		calculator.setOperand(3);
		excuteOperation(calculator, Operator.MINUS);
		assertEquals(-3 - 3, excuteOperation(calculator, Operator.MINUS), INACCURACY);
	}
	
	@Test
	public void testMultiplicationCalculate() {
		Calculator calculator = new Calculator();
		calculator.setOperand(3);
		excuteOperation(calculator, Operator.MULTIPLICATION);
		calculator.setOperand(4);
		assertEquals(3 * 4, calculator.calculateResult(), INACCURACY);
	}
	
	@Test
	public void testMultiplicationMultiplication() {
		Calculator calculator = new Calculator();
		calculator.setOperand(3);
		excuteOperation(calculator, Operator.MULTIPLICATION);
		assertEquals(0, excuteOperation(calculator, Operator.MULTIPLICATION), INACCURACY);
	}
	
	@Test
	public void testDivisionCalculate() {
		Calculator calculator = new Calculator();
		calculator.setOperand(3);
		excuteOperation(calculator, Operator.DIVISION);
		calculator.setOperand(4);
		assertEquals(3.0 / 4.0, calculator.calculateResult(), INACCURACY);
	}
	
	@Test
	public void testDivisionDivision() {
		Calculator calculator = new Calculator();
		calculator.setOperand(3);
		excuteOperation(calculator, Operator.DIVISION);
		assertEquals(0, excuteOperation(calculator, Operator.DIVISION), INACCURACY);
	}

	public double excuteOperation(Calculator calculator, Operator operator) {
		calculator.setOperator(operator);
		return calculator.calculateResult();
	}

}
