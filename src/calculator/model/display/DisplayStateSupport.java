package calculator.model.display;

import calculator.model.display.DisplayState.States;


public interface DisplayStateSupport {
	
	static final String INITIAL_VALUE = "0";

	void setState(States state);

	void setContent(String content);

	String getContent();

	boolean isInitialValue(String suffix);

}
