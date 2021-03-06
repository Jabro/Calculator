package de.youngdevelopers.calculator.model.pocketcalculator.display;

import de.youngdevelopers.calculator.model.Display;
import de.youngdevelopers.calculator.model.DisplayChangedEvent;
import de.youngdevelopers.calculator.model.pocketcalculator.display.DisplayEventSupport;
import de.youngdevelopers.calculator.model.pocketcalculator.display.states.ClearDisplayState;
import de.youngdevelopers.calculator.model.pocketcalculator.display.states.DisplayState;
import de.youngdevelopers.calculator.model.pocketcalculator.display.states.DisplayStateSupport;
import de.youngdevelopers.calculator.model.pocketcalculator.display.states.ErrorDisplayState;
import de.youngdevelopers.calculator.model.pocketcalculator.display.states.FloatingPointDisplayState;
import de.youngdevelopers.calculator.model.pocketcalculator.display.states.IntegerDisplayState;

public class PocketCalculatorDisplay extends DisplayEventSupport implements Display, DisplayStateSupport {

	private static final String YOU_DO_NOT_RESPECT_THE_WORKFLOW = "YOU DO NOT RESPECT THE WORKFLOW";
	private static final String INITIAL_VALUE = "0";
	private String content = INITIAL_VALUE;
	private DisplayState state = ClearDisplayState.getInstance();

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
