package calculator.model;

import javax.swing.event.EventListenerList;

import calculator.model.events.CalculatorEventListener;
import calculator.model.events.ResultChangedEvent;
import calculator.model.operator.Operator;

public class Calculator {

	private EventListenerList listeners = new EventListenerList();
	private Operator operator;
	private Operand lastOperand = new Operand(0);
	private Operand operand     = new Operand(0);

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

	public void calculateResult() {
		//TODO maybe remove Operand class
		//TODO add CalculationStrategy
		//TODO support more than just plus
		System.out.println("--------------");	
		System.out.println(lastOperand.getNumber());	
		System.out.println("+");	
		System.out.println(operand.getNumber());		
		double result = lastOperand.getNumber() + operand.getNumber();
		lastOperand = new Operand(result);
		System.out.println("= " + result);
		System.out.println("--------------");	
		raiseResultChangedEvent(new ResultChangedEvent(this, result ));
	}

	public void setOperand(Operand operand) {
		this.operand = operand;
	}
	
}
