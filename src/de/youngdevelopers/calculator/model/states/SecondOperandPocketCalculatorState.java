package de.youngdevelopers.calculator.model.states;

import de.youngdevelopers.calculator.model.Calculation;
import de.youngdevelopers.calculator.model.Operator;

public class SecondOperandPocketCalculatorState extends PocketCalculatorState {

	private static SecondOperandPocketCalculatorState instance;

	protected static PocketCalculatorState getInstance() {
		if(instance == null) {
			instance = new SecondOperandPocketCalculatorState();
		}
		return instance;
	}

	private SecondOperandPocketCalculatorState() {
	}

	@Override
	public void useOperator(PocketCalculatorStateSupport calculator, Operator operator) {
		if(operator == Operator.SQUARE_ROOT){
			calculateSquareRoot(calculator, operator);
			calculator.setState(SecondOperandPocketCalculatorState.getInstance(), true);
			return;
		}
		calculate(calculator, false);
		calculator.setState(OperatorSetPocketCalculatorState.getInstance());
		super.useOperator(calculator, operator);
	}

	@Override
	public void useInput(PocketCalculatorStateSupport calculator, String input) {
		if(calculator.isOperandFinished()) {
			calculator.getDisplay().clear();
			calculator.setState(FirstOperandPocketCalculatorState.getInstance(), false);
		} else {
			calculator.setState(SecondOperandPocketCalculatorState.getInstance(), false);
		}		
		super.useInput(calculator, input);
	}

	@Override
	public void calculate(PocketCalculatorStateSupport calculator, boolean fromEqualSign) {
		Double result = Calculation.calculateResult(calculator.getLastOperand(),
				calculator.getOperator(), calculator.getOperand());
		calculator.getDisplay().setNumber(result);
		calculator.setOperand(result);
		calculator.setOperator(null);
		if(fromEqualSign) {
			calculator.setState(FinishedPocketCalculatorState.getInstance());
		} else {
			calculator.setState(SecondOperandPocketCalculatorState.getInstance(), false);
		}
	}

}
