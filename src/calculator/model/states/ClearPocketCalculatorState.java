package calculator.model.states;

import calculator.model.Operator;

public class ClearPocketCalculatorState extends PocketCalculatorState {

	private static ClearPocketCalculatorState instance;

	protected static PocketCalculatorState getInstance() {
		if(instance == null) {
			instance = new ClearPocketCalculatorState();
		}
		return instance;
	}
	
	private ClearPocketCalculatorState() {
	}

	@Override
	public void useOperator(PocketCalculatorStateSupport calculator, Operator operator) {
			if(operator != Operator.MINUS) {
				calculator.getDisplay().setErrorState();
				return;
			}
			calculator.setState(States.OPERATOR_SET);
			super.useOperator(calculator, operator);
	}

	@Override
	public void useInput(PocketCalculatorStateSupport calculator, String input) {
		calculator.getDisplay().clear();
		calculator.setState(States.FIRST_OPERAND, false);
		super.useInput(calculator, input);
	}

}