package calculator.controller;

public class InputValue {

	private final String value;
	private final String name;
	private final Integer digit;

	public InputValue(String name, String value) {
		this.name = name;
		this.value = value;
		this.digit = null;	
	}

	public InputValue(String value) {
		name  = this.value = value;	
		digit = null;
	}

	public InputValue(int digit) {
		this.digit = digit;
		name = value = String.valueOf(digit);
	}

	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public boolean isDigit() {
		return digit != null;
	}

	public int getDigit() {
		if(!isDigit()) {
			throw new RuntimeException("Input value is not a digit. Check first using isDigit.");
		}
		return digit;
	}

	@Override
	public String toString() {
		return getName();
	}



}
