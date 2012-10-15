package calculator.model;

import calculator.model.events.CalculatorEventListener;
import calculator.model.events.PocketCalculatorEventListener;
import calculator.model.events.ResultChangedEvent;

public class PocketCalculator implements CalculatorEventListener {

	private Calculator calculator;
	private Display display;
	private Double operand;

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
		calculate();		
		calculator.setOperator(operator);
	}

	public void calculate() {
		// prevent overriding of the current operand
		// with the last result
		if(!isNewOperand()) {
			calculator.setOperand(operand);		
		}
		calculator.calculateResult();
		deleteOperand();			
		calculator.setOperator(null);
	}

	public void deleteOperand() {
		operand = null;
	}

	public boolean isNewOperand() {
		return operand == null;
	}

	public void setOperand(double operand) {
		this.operand = operand;		
	}

	public void addInput(String input) {
		if(isNewOperand()){
			display.clear();
		}
		display.addContent(input);
		setOperand(display.getNumber());
	}

	@Override
	public void onResultChanged(ResultChangedEvent event) {
		display.setDisplay(event.getResult());
	}

	public Display getDisplay() {
		return display;
	}
	
}
