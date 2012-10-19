package calculator.model.display.states;

import calculator.model.display.states.DisplayState.States;


public interface DisplayStateSupport {
	
	static final String INITIAL_VALUE = "0";

	void setState(States state);

	void setContent(String content);

	String getContent();

	boolean isInitialValue(String suffix);

}
