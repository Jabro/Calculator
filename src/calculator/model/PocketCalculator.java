package calculator.model;

import calculator.model.display.event.DisplayEventListener;
import calculator.model.states.ClearPocketCalculatorState;
import calculator.model.states.PocketCalculatorState;
import calculator.model.states.PocketCalculatorStateSupport;

public class PocketCalculator implements Calculator, PocketCalculatorStateSupport {

	private boolean isOperandFinished = false;
	private Display display;
	private double operand;
	private double lastOperand;
	private PocketCalculatorState state = ClearPocketCalculatorState.getInstance();
	private Operator operator;

	public PocketCalculator() {
		display = new Display();
	}

	@Override
	public void addListener(DisplayEventListener listener) {
		display.addListener(listener);		
	}

	@Override
	public void removeListener(DisplayEventListener listener) {
		display.removeListener(listener);		
	}

	@Override
	public void useOperator(Operator operator) {
		state.useOperator(this, operator);
	}

	@Override
	public void calculateFromEqualSign() {
		state.calculate(this, true);
	}

	@Override
	public void useInput(String input) {
		state.useInput(this, input);
	}
	
	@Override
	public void executeClear() {
		lastOperand = operand = 0;
		state = ClearPocketCalculatorState.getInstance();
		display.clear();
	}

	@Override
	public Display getDisplay() {
		return display;
	}
	
	@Override
	public void setState(PocketCalculatorState state) {
		this.state = state;
	}

	@Override
	public void setState(PocketCalculatorState state, boolean operandFinished) {
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
