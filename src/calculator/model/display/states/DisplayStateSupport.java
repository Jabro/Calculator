package calculator.model.display.states;

public interface DisplayStateSupport {
	
	static final String INITIAL_VALUE = "0";

	void setState(DisplayState state);

	void setContent(String content);

	String getContent();

	boolean isInitialValue(String suffix);

}
