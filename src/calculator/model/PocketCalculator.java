package calculator.model;

import calculator.model.events.DisplayEventListener;

public class PocketCalculator {

	private enum State {
		CLEAR,
		FIRST_OPERAND_STARTED,
		OPERATOR_SET,
		SECOND_OPERAND_STARTED;
	}

	private Display display;
	private double operand;
	private double lastOperand;
	private State state = State.CLEAR;
	private Operator operator;
	
	public PocketCalculator() {
		display = new Display();
	}

	public void addListener(DisplayEventListener listener) {
		display.addListener(listener);		
	}

	public void removeListener(DisplayEventListener listener) {
		display.removeListener(listener);		
	}

	public void setOperator(Operator operator) {
		switch(state) {
		case FIRST_OPERAND_STARTED:
			this.operator = operator;
			state = State.OPERATOR_SET;
			lastOperand = operand;	
			break;
		case OPERATOR_SET:			
			this.operator = operator;
			break;
		case SECOND_OPERAND_STARTED:		
			calculate(false);
			this.operator = operator;
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
			Double result = Calculation.calculateResult(lastOperand, operator, operand);
			display.setDisplay(result);
			operand = result;
			deleteOperator();
			if(fromEqualSign) {
				state = State.FIRST_OPERAND_STARTED;
			} else {
				state = State.SECOND_OPERAND_STARTED;
			}
		}	

	}

	private void deleteOperator() {
		operator = null;
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
			state = State.SECOND_OPERAND_STARTED;
			break;
		case SECOND_OPERAND_STARTED:	
			state = State.SECOND_OPERAND_STARTED;
			break;
		}		
		operand = display.getNumber();
	}

	public Display getDisplay() {
		return display;
	}

}
