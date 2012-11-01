package de.youngdevelopers.calculator.model.calculation.strategies;

public class MultiplicationCalculationStrategy extends BinaryCalculationStrategy {

	private static CalculationStrategy instance;

	public static CalculationStrategy getInstance() {
		if(instance == null) {
			instance = new MultiplicationCalculationStrategy();
		}
		return instance;
	}
	
	private MultiplicationCalculationStrategy() {
	}
	
	@Override
	public double calculate(double firstOperand, double secondOperand) {
		return firstOperand * secondOperand;
	}

}
