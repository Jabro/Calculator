package calculator.model;


public class Calculation {

	private static final String SEPERATOR = " ";
	private static final String EQUALS = SEPERATOR + "=" + SEPERATOR;

	private final double firstOperand;
	private final double secondOperand;
	private final Operator operator;
	private Double result;

	public Calculation(double firstOperand, Operator operator, double secondOperand) {
		this.firstOperand = firstOperand;
		this.operator = operator;
		this.secondOperand = secondOperand;		
	}

	public static double calculateResult(double firstOperand, Operator operator, double secondOperand) {
		return new Calculation(firstOperand, operator, secondOperand).calculate();	
	}

	public double calculate() {
		result = operator.getCalculationStrategy().calculate(firstOperand, secondOperand);
		System.out.println(this);	
		return result;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(firstOperand);
		buffer.append(SEPERATOR);
		buffer.append(operator);
		buffer.append(SEPERATOR);
		buffer.append(secondOperand);
		if(result != null) {	
			buffer.append(EQUALS);
			buffer.append(result);
		}
		return buffer.toString();
	}

}
