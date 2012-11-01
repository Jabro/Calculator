package de.youngdevelopers.calculator.model.states;

import de.youngdevelopers.calculator.model.Operator;

public class ClearPocketCalculatorState extends PocketCalculatorState {

	private static ClearPocketCalculatorState instance;

	public static PocketCalculatorState getInstance() {
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
			calculator.setState(OperatorSetPocketCalculatorState.getInstance());
			super.useOperator(calculator, operator);
	}

	@Override
	public void useInput(PocketCalculatorStateSupport calculator, String input) {
		calculator.getDisplay().clear();
		calculator.setState(FirstOperandPocketCalculatorState.getInstance(), false);
		super.useInput(calculator, input);
	}

}
