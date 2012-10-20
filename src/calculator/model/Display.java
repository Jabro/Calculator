package calculator.model;

import calculator.model.display.event.DisplayChangedEvent;
import calculator.model.display.event.DisplayEventSupport;
import calculator.model.display.states.ClearDisplayState;
import calculator.model.display.states.DisplayState;
import calculator.model.display.states.DisplayStateSupport;
import calculator.model.display.states.ErrorDisplayState;
import calculator.model.display.states.FloatingPointDisplayState;
import calculator.model.display.states.IntegerDisplayState;

public class Display extends DisplayEventSupport implements DisplayStateSupport {

	private static final String YOU_DO_NOT_RESPECT_THE_WORKFLOW = "YOU DO NOT RESPECT THE WORKFLOW";
	private static final String INITIAL_VALUE = "0";
	private String content;
	private DisplayState state;

	public Display() {
		clear();
	}

	public void clear() {
		setState(ClearDisplayState.getInstance());
		setContent(INITIAL_VALUE);
	}

	public void addDigit(int digit) {
		addContent(String.valueOf(digit));		
	}

	public void setContent(String content) {
		this.content = content;
		raiseDisplayChangedEvent(new DisplayChangedEvent(this, this));
	}

	public void addContent(String suffix) {
		state.addContent(this, suffix);
	}

	public void setNumber(Double number) {
		if(isInteger(number)) {
			setState(IntegerDisplayState.getInstance());
			setContent(String.valueOf(number.intValue()));
		} else {		
			setState(FloatingPointDisplayState.getInstance());
			setContent(String.valueOf(number));
		}
	}

	private boolean isInteger(Double number) {
		return number.intValue() == number;
	}

	public String getContent() {
		return content;
	}

	public double getNumber() {
		return Double.valueOf(content);
	}

	public void setErrorState() {
		setState(ErrorDisplayState.getInstance());
		setContent(YOU_DO_NOT_RESPECT_THE_WORKFLOW);		
	}

	public boolean isErrorMessage() {
		return state.isErrorState();
	}

	@Override
	public void setState(DisplayState state) {
		this.state = state;
	}

	@Override
	public boolean isInitialValue(String suffix) {
		return INITIAL_VALUE.equals(suffix);
	}

}
