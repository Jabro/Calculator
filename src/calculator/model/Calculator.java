package calculator.model;

import javax.swing.event.EventListenerList;

import calculator.model.events.CalculatorEventListener;
import calculator.model.events.ResultChangedEvent;

public class Calculator {

	private EventListenerList listeners = new EventListenerList();
	private Operator operator;
	private boolean operandIsSet = false;
	private boolean lastOperandIsSet = false;
	private double lastOperand = 0;
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
		System.out.println("--------------");	
		System.out.println(lastOperand);	
		System.out.println("+");	
		System.out.println(operand);	
		//TODO support more than just plus
		//TODO select calculation strategy depending on operator
		if (operator != null){
		double result = operator.getCalculationStrategy().calculate(lastOperand, operand);
		lastOperand = result;
		System.out.println("= " + result);
		System.out.println("--------------");	
		raiseResultChangedEvent(new ResultChangedEvent(this, result ));
		return result;
		} else {
			
			return operand;
		}
	}

	public void setOperand(double operand) {
		if (operandIsSet){
			this.lastOperand = this.operand;
			this.operand = operand;
		} else {
			this.operand = operand;
		}
	}
	
}
