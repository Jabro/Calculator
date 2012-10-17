package calculator.model.pocket.calculator;

import calculator.model.Calculation;
import calculator.model.Display;
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
		calculator.setOperator(operator);
		calculator.setState(States.OPERATOR_SET);
		calculator.setLastOperand(calculator.getOperand());
	}

	@Override
	protected void useInput(PocketCalculatorStateSupport calculator, String input) {
		Display display = calculator.getDisplay();
		if(calculator.isOperandFinished()) {
			display.clear();
		}		
		display.addContent(input);
		if(calculator.isOperandFinished()) {
			calculator.setState(States.FIRST_OPERAND, false);
		} else {
			calculator.setState(States.SECOND_OPERAND, false);
		}				
		calculator.setOperand(display.getNumber());
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
