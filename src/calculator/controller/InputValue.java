package calculator.controller;

public class InputValue {
	
	private final String value;
	private final String name;

	public InputValue(String name, String value) {
		this.name = name;
		this.value = value;	
	}
	
	public InputValue(String value) {
		name = this.value = value;	
	}

	public InputValue(int digit) {
		name = value = String.valueOf(digit);
	}

	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
}
