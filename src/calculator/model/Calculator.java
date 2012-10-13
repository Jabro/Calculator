package calculator.model;

import javax.swing.event.EventListenerList;

import calculator.model.operator.Operator;

public class Calculator {

	private EventListenerList listeners = new EventListenerList();
	private Operator operator;

	public void addCalculatorListener(CalculatorListener listener) {
		listeners.add(CalculatorListener.class, listener);
	}
	
	public void removeCalculatorListener(CalculatorListener listener) {
		listeners.remove(CalculatorListener.class, listener);
	}
	
	private void raiseResultChangedEvent(ResultChangedEvent event) {
		for (CalculatorListener listener : listeners.getListeners(CalculatorListener.class)) {
			listener.onResultChanged(event);
		}
	}

	public void setOperator(Operator operator) {
		this.operator = operator;		
	}

	public void calculateResult() {
		System.out.println("calculateResult");
		raiseResultChangedEvent(new ResultChangedEvent(this, 3.0));
	}
	
}
