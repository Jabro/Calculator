package calculator.model;

import javax.swing.event.EventListenerList;

import calculator.model.events.CalculatorEventListener;
import calculator.model.events.ResultChangedEvent;
import calculator.model.operator.Operator;

public class Calculator {

	private EventListenerList listeners = new EventListenerList();
	private Operator operator;

	public void addCalculatorListener(CalculatorEventListener listener) {
		listeners.add(CalculatorEventListener.class, listener);
	}
	
	public void removeCalculatorListener(CalculatorEventListener listener) {
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
		System.out.println("calculateResult");
		raiseResultChangedEvent(new ResultChangedEvent(this, 3.0));
	}
	
}
