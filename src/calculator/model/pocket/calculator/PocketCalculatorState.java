package calculator.model.pocket.calculator;

import calculator.model.Calculation;
import calculator.model.Display;
import calculator.model.Operator;

public abstract class PocketCalculatorState {

	protected enum States {
		CLEAR(ClearPocketCalculatorState.getInstance()),
		FIRST_OPERAND(FirstOperandPocketCalculatorState.getInstance()),
		OPERATOR_SET(OperatorSetPocketCalculatorState.getInstance()),
		SECOND_OPERAND(SecondOperandPocketCalculatorState.getInstance()),
		FINISHED(FinishedPocketCalculatorState.getInstance());

		private final PocketCalculatorState state;

		private States(PocketCalculatorState state) {
			this.state = state;
		}

		public PocketCalculatorState getState() {
			return state;
		}

	}

	protected void useOperator(PocketCalculatorStateSupport calculator, Operator operator) {
		calculator.setOperator(operator);
		calculator.setLastOperand(calculator.getOperand());	
	}

	protected void useInput(PocketCalculatorStateSupport calculator, String input) {
		Display display = calculator.getDisplay();
		display.addContent(input);
		calculator.setOperand(display.getNumber());
	}

	protected void calculate(PocketCalculatorStateSupport calculator, boolean fromEqualSign) {
	}

	protected void calculateSquareRoot(PocketCalculatorStateSupport calculator, Operator operator) {
		Double result = Calculation.calculateResult(operator, calculator.getOperand());
		calculator.getDisplay().setNumber(result);
		calculator.setOperand(result);
	}

}
