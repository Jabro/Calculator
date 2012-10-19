package calculator.model.pocket.calculator;

import calculator.model.Operator;
import calculator.model.display.Display;
import calculator.model.events.DisplayEventListener;
import calculator.model.pocket.calculator.PocketCalculatorState.States;

public class PocketCalculator implements PocketCalculatorStateSupport {

	private boolean isOperandFinished = false;
	private Display display;
	private double operand;
	private double lastOperand;
	private States state = States.CLEAR;
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

	public void useOperator(Operator operator) {
		state.getState().useOperator(this, operator);
	}

	public void calculateFromEqualSign() {
		state.getState().calculate(this, true);
	}

	public void useInput(String input) {
		state.getState().useInput(this, input);
	}
	
	public void executeClear() {
		lastOperand = operand = 0;
		state = States.CLEAR;
		display.clear();
	}

	@Override
	public Display getDisplay() {
		return display;
	}
	
	@Override
	public void setState(States state) {
		this.state = state;
	}

	@Override
	public void setState(States state, boolean operandFinished) {
		this.state = state;
		this.isOperandFinished = operandFinished;
	}

	@Override
	public boolean isOperandFinished() {
		return isOperandFinished;
	}

	@Override
	public Operator getOperator() {
		return operator;
	}

	@Override
	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	@Override
	public double getOperand() {
		return operand;
	}

	@Override
	public void setOperand(double operand) {
		this.operand = operand;
	}

	@Override
	public double getLastOperand() {
		return lastOperand;
	}

	@Override
	public void setLastOperand(double operand) {
		this.lastOperand = operand;
	}

}
