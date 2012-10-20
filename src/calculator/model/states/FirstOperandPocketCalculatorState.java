package calculator.model.states;

import calculator.model.Operator;

public class FirstOperandPocketCalculatorState extends PocketCalculatorState {

	private static FirstOperandPocketCalculatorState instance;

	protected static PocketCalculatorState getInstance() {
		if(instance == null) {
			instance = new FirstOperandPocketCalculatorState();
		}
		return instance;
	}

	private FirstOperandPocketCalculatorState() {
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
		if(calculator.isOperandFinished()) {
			calculator.getDisplay().clear();
		}		
		calculator.setState(FirstOperandPocketCalculatorState.getInstance(), false);
		super.useInput(calculator, input);
	}

}
