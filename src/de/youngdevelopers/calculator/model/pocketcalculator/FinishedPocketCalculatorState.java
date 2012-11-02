package de.youngdevelopers.calculator.model.pocketcalculator;

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
		// tread result as first operand
		FirstOperandPocketCalculatorState.getInstance().useOperator(calculator, operator);
	}

	@Override
	public void useInput(PocketCalculatorStateSupport calculator, String input) {
		calculator.getDisplay().clear();
		calculator.setState(FirstOperandPocketCalculatorState.getInstance(), false);
		super.useInput(calculator, input);
	}

}
