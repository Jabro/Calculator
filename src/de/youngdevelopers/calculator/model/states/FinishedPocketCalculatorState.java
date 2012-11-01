package de.youngdevelopers.calculator.model.states;

import de.youngdevelopers.calculator.model.Operator;

public final class FinishedPocketCalculatorState extends PocketCalculatorState {

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
	public void useOperator(PocketCalculatorStateSupport calculator, Operator operator) {
		if(operator == Operator.SQUARE_ROOT){
			calculateSquareRoot(calculator, operator);
			calculator.setState(FirstOperandPocketCalculatorState.getInstance(), true);
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
