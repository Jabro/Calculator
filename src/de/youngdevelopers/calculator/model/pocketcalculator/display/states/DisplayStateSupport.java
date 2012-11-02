package de.youngdevelopers.calculator.model.pocketcalculator.display.states;

public interface DisplayStateSupport {
	
	String INITIAL_VALUE = "0";

	void setState(DisplayState state);

	void setContent(String content);

	String getContent();

	boolean isInitialValue(String suffix);

}
