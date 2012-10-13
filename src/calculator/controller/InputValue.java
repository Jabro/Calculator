package calculator.controller;

public class InputValue {
	
	private final String value;
	private final String name;

	public InputValue(String name, String value) {
		this.name = name;
		this.value = value;	
	}

	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}
	
}
