package calculator.model.pocket.calculator;

import calculator.model.Display;
import calculator.model.Operator;

public class FinishedPocketCalculatorState extends PocketCalculatorState {

	private static FinishedPocketCalculatorState instance;

	protected static PocketCalculatorState getInstance() {
		if(instance == null) {
			instance = new FinishedPocketCalculatorState();
		}
		return instance;
	}

	private FinishedPocketCalculatorState() {
	}

	@Override
	protected void useOperator(PocketCalculatorStateSupport calculator, Operator operator) {
		if(operator == Operator.SQUARE_ROOT){
			calculateSquareRoot(calculator, operator);
			calculator.setState(States.FIRST_OPERAND, true);
			return;
		}
		calculator.setOperator(operator);
		calculator.setState(States.OPERATOR_SET);
		calculator.setLastOperand(calculator.getOperand());	
	}

	@Override
	protected void useInput(PocketCalculatorStateSupport calculator, String input) {
		Display display = calculator.getDisplay();
		display.clear();
		display.addContent(input);
		calculator.setState(States.FIRST_OPERAND, false);
		calculator.setOperand(display.getNumber());
	}

}
