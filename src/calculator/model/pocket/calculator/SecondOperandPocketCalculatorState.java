package calculator.model.pocket.calculator;

import calculator.model.Calculation;
import calculator.model.Operator;

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
	protected void useOperator(PocketCalculatorStateSupport calculator, Operator operator) {
		if(operator == Operator.SQUARE_ROOT){
			calculateSquareRoot(calculator, operator);
			calculator.setState(States.SECOND_OPERAND, true);
			return;
		}
		calculate(calculator, false);
		calculator.setState(States.OPERATOR_SET);
		super.useOperator(calculator, operator);
	}

	@Override
	protected void useInput(PocketCalculatorStateSupport calculator, String input) {
		if(calculator.isOperandFinished()) {
			calculator.getDisplay().clear();
			calculator.setState(States.FIRST_OPERAND, false);
		} else {
			calculator.setState(States.SECOND_OPERAND, false);
		}		
		super.useInput(calculator, input);
	}

	@Override
	protected void calculate(PocketCalculatorStateSupport calculator, boolean fromEqualSign) {
		Double result = Calculation.calculateResult(calculator.getLastOperand(),
				calculator.getOperator(), calculator.getOperand());
		calculator.getDisplay().setNumber(result);
		calculator.setOperand(result);
		calculator.setOperator(null);
		if(fromEqualSign) {
			calculator.setState(States.FINISHED);
		} else {
			calculator.setState(States.SECOND_OPERAND, false);
		}
	}

}
