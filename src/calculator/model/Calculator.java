package calculator.model;

import javax.swing.event.EventListenerList;

import calculator.model.events.CalculatorEventListener;
import calculator.model.events.ResultChangedEvent;

public class Calculator {

	private EventListenerList listeners = new EventListenerList();
	private Operator operator;
	private Double lastOperand = null;
	private double operand     = 0;

	public void addListener(CalculatorEventListener listener) {
		listeners.add(CalculatorEventListener.class, listener);
	}

	public void removeListener(CalculatorEventListener listener) {
		listeners.remove(CalculatorEventListener.class, listener);
	}

	private void raiseResultChangedEvent(ResultChangedEvent event) {
		for (CalculatorEventListener listener : listeners.getListeners(CalculatorEventListener.class)) {
			listener.onResultChanged(event);
		}
	}

	public void setOperator(Operator operator) {
		this.operator = operator;		
	}

	public double calculateResult() {
		// We have no pending calculations
		if(operator == null) {
			// Just one number entered
			if(lastOperand == null) {
				lastOperand = operand;
			}
			return lastOperand;
		}
		double result = operator.getCalculationStrategy().calculate(lastOperand, operand);
		System.out.println("--------------");	
		System.out.println(lastOperand);	
		if(operator != null) {
			System.out.println(operator.name());	
		}
		System.out.println(operand);	
		System.out.println("= " + result);
		System.out.println("--------------");	
		lastOperand = result;
		System.out.println(lastOperand);
		raiseResultChangedEvent(new ResultChangedEvent(this, result ));
		return result;
	}

	public void setOperand(double operand) {
		this.operand = operand;
	}

}
