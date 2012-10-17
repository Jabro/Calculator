package calculator.model.pocket.calculator;

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
		calculator.setState(States.OPERATOR_SET);
		super.useOperator(calculator, operator);
	}

	@Override
	protected void useInput(PocketCalculatorStateSupport calculator, String input) {
		calculator.getDisplay().clear();
		calculator.setState(States.FIRST_OPERAND, false);
		super.useInput(calculator, input);
	}

}
