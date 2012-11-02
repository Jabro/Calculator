package de.youngdevelopers.calculator.model.pocketcalculator;

import de.youngdevelopers.calculator.model.Operator;

public final class OperatorSetPocketCalculatorState extends PocketCalculatorState {

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
	public void useOperator(PocketCalculatorStateSupport calculator, Operator operator) {
		calculator.setOperator(operator);
	}

	@Override
	public void useInput(PocketCalculatorStateSupport calculator, String input) {
		calculator.getDisplay().clear();
		calculator.setState(SecondOperandPocketCalculatorState.getInstance(), false);
		super.useInput(calculator, input);
	}

}
