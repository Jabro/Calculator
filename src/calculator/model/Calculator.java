package calculator.model;

import javax.swing.event.EventListenerList;

import calculator.model.events.CalculatorEventListener;
import calculator.model.events.ResultChangedEvent;

public class Calculator {

	private EventListenerList listeners = new EventListenerList();
	private Operator operator;

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

	public double calculateResult(double firstOperand, double secondOperand) {
		double result = operator.getCalculationStrategy().calculate(firstOperand, secondOperand);
		printCalculation(firstOperand, secondOperand, result);	
		raiseResultChangedEvent(new ResultChangedEvent(this, result ));
		return result;
	}

	private void printCalculation(double firstOperand, double secondOperand,
			double result) {
		System.out.println("--------------");	
		System.out.println(firstOperand);	
		System.out.println(operator.name());	
		System.out.println(secondOperand);	
		System.out.println("= " + result);
		System.out.println("--------------");
	}

}
