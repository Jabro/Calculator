package calculator.model;

public class Operand {

	private final double number;

	public Operand(double number) {
		this.number = number;
	}

	public double getNumber() {
		return number;
	}
	
	@Override
	public String toString() {
		return String.valueOf(number);
	}

}
