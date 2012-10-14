package calculator.controller;

import org.junit.Test;

import calculator.model.Operator;
import calculator.test.framework.CalculationTestSupport;
import calculator.test.framework.MockCalculatorView;

public class CalculatorControllerTest implements CalculationTestSupport {

	private static final int FIRST_DIGIT  = 3;
	private static final int SECOND_DIGIT = 4;
	private static final int THIRD_DIGIT  = 6;

	@Test
	public void testTwoDigits() {
		MockCalculatorView mock = createMock();
		mock.enterDigit(FIRST_DIGIT);
		mock.enterDigit(SECOND_DIGIT);
		mock.assertResult(34);
	}
	
	@Test
	public void testPlus() {
		MockCalculatorView mock = createMock();
		mock.enterDigit(FIRST_DIGIT);
		mock.enterCommand(new Command("+", Operator.PLUS));
		mock.enterDigit(SECOND_DIGIT);
		mock.enterCommand(new Command("=", true));
		mock.assertResult(7); // 3 + 4
	}
	
	@Test
	public void testPlusPlus() {
		MockCalculatorView mock = createMock();
		mock.enterDigit(FIRST_DIGIT);
		mock.enterCommand(new Command("+", Operator.PLUS));
		mock.enterDigit(SECOND_DIGIT);
		mock.enterCommand(new Command("+", Operator.PLUS));
		mock.enterCommand(new Command("=", true));
		mock.assertResult(11); // 3 + 4 + 4
	}
	
	@Test
	public void testPlusMinusTwoDigits() {
		MockCalculatorView mock = createMock();
		mock.enterDigit(FIRST_DIGIT);
		mock.enterCommand(new Command("+", Operator.PLUS));
		mock.enterDigit(SECOND_DIGIT);
		mock.enterCommand(new Command("-", Operator.MINUS));
		mock.enterCommand(new Command("=", true));
		mock.assertResult(3); // 3 + 4 - 4
	}
	
	@Test
	public void testPlusMinusThreeDigits() {
		MockCalculatorView mock = createMock();
		mock.enterDigit(FIRST_DIGIT);
		mock.enterCommand(new Command("+", Operator.PLUS));
		mock.enterDigit(SECOND_DIGIT);
		mock.enterCommand(new Command("-", Operator.MINUS));
		mock.enterDigit(THIRD_DIGIT);
		mock.enterCommand(new Command("=", true));
		mock.assertResult(1); // 3 + 4 - 6
	}

	private MockCalculatorView createMock() {
		MockCalculatorView mock = new MockCalculatorView();
		new DefaultCalculatorController(mock);
		return mock;
	}

}
