package calculator.model;

public class CalculatorDisplay {
	
	private static final String INITIAL_VALUE = "0";
	private String display;
	
	public CalculatorDisplay() {
		clearDisplay();
	}

	public void clearDisplay() {
		display = INITIAL_VALUE;
	}

	public void addDigit(int digit) {
		System.out.println(display);
		display += digit;
	}

	public String getDisplay() {
		return display;
	}

}
