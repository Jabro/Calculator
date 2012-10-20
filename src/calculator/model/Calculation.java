package calculator.model;

import calculator.model.calculation.strategies.CalculationStrategy;



public class Calculation {

	private static final String SEPERATOR = " ";
	private static final String EQUALS = SEPERATOR + "=" + SEPERATOR;

	private final double firstOperand;
	private final Double secondOperand;
	private final String operatorSign;
	private final CalculationStrategy calculationStrategy;
	private Double result;

	public Calculation(double firstOperand, Operator operator, double secondOperand) {
		this.firstOperand = firstOperand;
		this.secondOperand = secondOperand;
		this.operatorSign = operator.getSign();
		this.calculationStrategy = operator.getCalculationStrategy();
	}

	public Calculation(Operator operator, double operand) {
		this.firstOperand = operand;
		this.secondOperand = null;
		this.operatorSign = operator.getSign();
		this.calculationStrategy = operator.getCalculationStrategy();
	}

	public static double calculateResult(double firstOperand, Operator operator, double secondOperand) {
		return new Calculation(firstOperand, operator, secondOperand).calculate();	
	}

	public static Double calculateResult(Operator operator, double operand) {
		return new Calculation(operator, operand).calculate();	
	}

	public double calculate() {
		result = calculationStrategy.calculate(firstOperand, secondOperand);
		System.out.println(this);	
		return result;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		if(secondOperand != null) {
			buffer.append(firstOperand);
			buffer.append(SEPERATOR);
		}
		buffer.append(operatorSign);
		buffer.append(SEPERATOR);
		if(secondOperand != null) {			
			buffer.append(secondOperand);
		} else {
			buffer.append(firstOperand);
		}
		if(result != null) {	
			buffer.append(EQUALS);
			buffer.append(result);
		}
		return buffer.toString();
	}

}
