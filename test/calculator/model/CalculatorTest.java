package calculator.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import calculator.model.operator.PlusOperator;

public class CalculatorTest {

	@Test
	public void testCalculateResult() {
		Calculator calculator = new Calculator();
		calculator.setOperand(3);
		calculator.setOperator(new PlusOperator());
		assertEquals(3.0, calculator.calculateResult(), 0.000001);
	}

}
