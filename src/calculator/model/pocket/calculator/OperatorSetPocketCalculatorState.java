package calculator.model.pocket.calculator;

import calculator.model.Display;
import calculator.model.Operator;

public class OperatorSetPocketCalculatorState extends PocketCalculatorState {

	private static OperatorSetPocketCalculatorState instance;

	protected static PocketCalculatorState getInstance() {
		if(instance == null) {
			instance = new OperatorSetPocketCalculatorState();
		}
		return instance;
	}

	private OperatorSetPocketCalculatorState() {
	}

	@Override
	protected void useOperator(PocketCalculatorStateSupport calculator, Operator operator) {
		calculator.setOperator(operator);
	}

	@Override
	protected void useInput(PocketCalculatorStateSupport calculator, String input) {
		Display display = calculator.getDisplay();
		display.clear();
		display.addContent(input);
		calculator.setState(States.SECOND_OPERAND, false);
		calculator.setOperand(display.getNumber());
	}

}
