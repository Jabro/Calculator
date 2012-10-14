package calculator.model;

public class Operand {

	private double number;

	public Operand(double number) {
		this.number = number;
	}

	public double getNumber() {
		return number;
	}
	
	public void setNumber(double number) {
		this.number = number;		
	}
	
	@Override
	public String toString() {
		return String.valueOf(number);
	}

	

}
