package calculator.model.states;

import calculator.model.Calculation;
import calculator.model.Display;
import calculator.model.Operator;

public abstract class PocketCalculatorState {

	public void useOperator(PocketCalculatorStateSupport calculator, Operator operator) {
		calculator.setOperator(operator);
		calculator.setLastOperand(calculator.getOperand());	
	}

	public void useInput(PocketCalculatorStateSupport calculator, String input) {
		Display display = calculator.getDisplay();
		display.addContent(input);
		calculator.setOperand(display.getNumber());
	}

	public void calculate(PocketCalculatorStateSupport calculator, boolean fromEqualSign) {
	}

	protected void calculateSquareRoot(PocketCalculatorStateSupport calculator, Operator operator) {
		Double result = Calculation.calculateResult(operator, calculator.getOperand());
		calculator.getDisplay().setNumber(result);
		calculator.setOperand(result);
	}

}
