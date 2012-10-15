package calculator.controller;

import org.junit.Test;

import calculator.model.Operator;
import calculator.test.framework.CalculationTestSupport;
import calculator.test.framework.MockCalculatorView;

public class PocketCalculatorControllerTest implements CalculationTestSupport {

	private static final int FIRST_DIGIT  = 3;
	private static final int SECOND_DIGIT = 4;
	private static final int THIRD_DIGIT  = 6;

	@Test
	public void testTwoDigits() {
		MockCalculatorView mock = createMock();
		mock.enterDigit(FIRST_DIGIT);
		mock.enterDigit(SECOND_DIGIT);
		mock.assertDisplay(34);
	}
	
	@Test
	public void testPlusTwoDigits() {
		MockCalculatorView mock = createMock();
		mock.enterDigit(FIRST_DIGIT);
		mock.enterDigit(SECOND_DIGIT);
		mock.enterCommand(new Command(Operator.PLUS));
		mock.enterDigit(THIRD_DIGIT);
		mock.enterCommand(new Command("=", true));
		mock.assertDisplay(40); // 34 + 6
	}
	
	@Test
	public void testPlus() {
		MockCalculatorView mock = createMock();
		mock.enterDigit(FIRST_DIGIT);
		mock.assertDisplay(3);
		mock.enterCommand(new Command(Operator.PLUS));		
		mock.enterDigit(SECOND_DIGIT);
		mock.assertDisplay(4);
		mock.enterCommand(new Command("=", true));
		mock.assertDisplay(7); // 3 + 4
	}
	
	@Test
	public void testPlusPlus() {
		MockCalculatorView mock = createMock();
		mock.enterDigit(FIRST_DIGIT);
		mock.enterCommand(new Command(Operator.PLUS));
		mock.enterDigit(SECOND_DIGIT);
		mock.enterCommand(new Command(Operator.PLUS));
		mock.enterCommand(new Command("=", true));
		mock.assertDisplay(7); // 3 + 4
	}
	
	@Test
	public void testPlusCalculateMinusCalculate() {
		MockCalculatorView mock = createMock();
		mock.enterDigit(FIRST_DIGIT);
		mock.enterCommand(new Command(Operator.PLUS));
		mock.enterDigit(SECOND_DIGIT);
		mock.enterCommand(new Command("=", true));
		mock.enterCommand(new Command(Operator.MINUS));
		mock.enterDigit(THIRD_DIGIT);
		mock.enterCommand(new Command("=", true));
		mock.assertDisplay(1); // 3 + 4 - 6
	}
	
	@Test
	public void testPlusMinusCalculate() {
		MockCalculatorView mock = createMock();
		mock.enterDigit(FIRST_DIGIT);
		mock.enterCommand(new Command(Operator.PLUS));
		mock.enterDigit(SECOND_DIGIT);
		mock.enterCommand(new Command(Operator.MINUS));
		mock.enterDigit(THIRD_DIGIT);
		mock.enterCommand(new Command("=", true));
		mock.assertDisplay(1); // 3 + 4 - 6
	}
	
	@Test
	public void testMultiplicationCalculateDivisionCalculate() {
		MockCalculatorView mock = createMock();
		mock.enterDigit(FIRST_DIGIT);
		mock.enterCommand(new Command(Operator.MULTIPLICATION));
		mock.enterCommand(new Command("=", true));
		mock.enterDigit(SECOND_DIGIT);
		mock.enterCommand(new Command(Operator.DIVISION));
		mock.enterDigit(THIRD_DIGIT);
		mock.enterCommand(new Command("=", true));
		mock.assertDisplay(2); // 3 * 4 / 6
	}
	
	@Test
	public void testPlusCalculateMinusThreeDigits() {
		MockCalculatorView mock = createMock();
		mock.enterDigit(FIRST_DIGIT);
		mock.enterCommand(new Command(Operator.PLUS));
		mock.enterDigit(SECOND_DIGIT);
		mock.enterCommand(new Command("=", true));
		mock.assertDisplay(7); // 3 + 4
		mock.enterCommand(new Command(Operator.MINUS));
		mock.enterDigit(THIRD_DIGIT);
		mock.enterCommand(new Command("=", true));
		mock.assertDisplay(1); // 7 - 6
	}

	private MockCalculatorView createMock() {
		MockCalculatorView mock = new MockCalculatorView();
		new PocketCalculatorController(mock);
		return mock;
	}

}
