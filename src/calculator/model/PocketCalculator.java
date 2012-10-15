package calculator.model;

import calculator.model.events.CalculatorEventListener;
import calculator.model.events.PocketCalculatorEventListener;
import calculator.model.events.ResultChangedEvent;

public class PocketCalculator implements CalculatorEventListener {

	private enum State {
		CLEAR,
		FIRST_OPERAND_STARTED,
		OPERATOR_SET,
		SECOND_OPERAND_STARTED;
	}

	private Calculator calculator;
	private Display display;
	private double operand;
	private double lastOperand;
	private State state = State.CLEAR;

	public PocketCalculator() {
		calculator = new Calculator();
		calculator.addListener(this);
		display    = new Display();
	}

	public void addListener(PocketCalculatorEventListener listener) {
		display.addListener(listener);		
	}

	public void removeListener(PocketCalculatorEventListener listener) {
		display.removeListener(listener);		
	}

	public void setOperator(Operator operator) {
		switch(state) {
		case FIRST_OPERAND_STARTED:
			calculator.setOperator(operator);
			state = State.OPERATOR_SET;
			lastOperand = operand;	
			break;
		case OPERATOR_SET:			
			calculator.setOperator(operator);
			break;
		case SECOND_OPERAND_STARTED:		
			calculate(false);
			calculator.setOperator(operator);
			state = State.OPERATOR_SET;
			lastOperand = operand;	
			break;
		}
	}

	public void calculateFromEqualSign() {
		calculate(true);
	}

	private void calculate(boolean fromEqualSign) {
		switch(state) {
		case CLEAR:
		case FIRST_OPERAND_STARTED:
		case OPERATOR_SET:
			return;
		case SECOND_OPERAND_STARTED:	
			operand = calculator.calculateResult(lastOperand, operand);
			deleteOperator();
			if(fromEqualSign) {
				state = State.FIRST_OPERAND_STARTED;
			} else {
				state = State.SECOND_OPERAND_STARTED;
			}
		}	

	}

	private void deleteOperator() {
		calculator.setOperator(null);
	}

	public void addInput(String input) {
		if(state == State.CLEAR || state == State.OPERATOR_SET) {
			display.clear();
		}
		display.addContent(input);
		switch(state) {
		case CLEAR:
		case FIRST_OPERAND_STARTED:
			state = State.FIRST_OPERAND_STARTED;
			break;
		case OPERATOR_SET:
			// lastOperand = operand;
			state = State.SECOND_OPERAND_STARTED;
			break;
		case SECOND_OPERAND_STARTED:	
			state = State.SECOND_OPERAND_STARTED;
			break;
		}		
		operand = display.getNumber();
	}

	@Override
	public void onResultChanged(ResultChangedEvent event) {
		display.setDisplay(event.getResult());
	}

	public Display getDisplay() {
		return display;
	}

}
