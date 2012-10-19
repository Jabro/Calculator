package calculator.model;

import javax.swing.event.EventListenerList;

import calculator.model.display.event.DisplayChangedEvent;
import calculator.model.display.event.DisplayEventListener;
import calculator.model.display.states.DisplayStateSupport;
import calculator.model.display.states.DisplayState.States;

public class Display implements DisplayStateSupport {

	private static final String YOU_DO_NOT_RESPECT_THE_WORKFLOW = "YOU DO NOT RESPECT THE WORKFLOW";
	private static final String INITIAL_VALUE = "0";
	private String content;
	private EventListenerList listeners = new EventListenerList();
	
	private States state = States.CLEAR;

	public Display() {
		clear();
	}

	public void clear() {
		setContent(INITIAL_VALUE);
		setState(States.CLEAR);
	}

	public void addDigit(int digit) {
		addContent(String.valueOf(digit));		
	}

	public void setContent(String content) {
		this.content = content;
		raiseDisplayChangedEvent(new DisplayChangedEvent(this, this));
	}

	private void raiseDisplayChangedEvent(DisplayChangedEvent event) {
		for (DisplayEventListener listener : listeners.getListeners(DisplayEventListener.class)) {
			listener.onDisplayChanged(event);
		}
	}

	public void addContent(String suffix) {
		state.getState().addContent(this, suffix);
	}

	public void setNumber(Double number) {
		if(isInteger(number)) {
			setState(States.INTEGER);
			setContent(String.valueOf(number.intValue()));
		} else {		
			setState(States.FLOATING_POINT);
			setContent(String.valueOf(number));
		}
	}

	private boolean isInteger(Double number) {
		return number.intValue() == number;
	}

	public void addListener(DisplayEventListener listener) {
		listeners .add(DisplayEventListener.class, listener);
	}

	public void removeListener(DisplayEventListener listener) {
		listeners.remove(DisplayEventListener.class, listener);
	}

	public String getContent() {
		return content;
	}

	public double getNumber() {
		return Double.valueOf(content);
	}

	public void setErrorState() {
		setState(States.ERROR);
		setContent(YOU_DO_NOT_RESPECT_THE_WORKFLOW);		
	}

	public boolean isErrorMessage() {
		return state == States.ERROR;
	}

	@Override
	public void setState(States state) {
		this.state = state;
	}

	@Override
	public boolean isInitialValue(String suffix) {
		return INITIAL_VALUE.equals(suffix);
	}

}
