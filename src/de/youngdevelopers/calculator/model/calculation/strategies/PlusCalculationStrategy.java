package de.youngdevelopers.calculator.model.calculation.strategies;

public class PlusCalculationStrategy extends BinaryCalculationStrategy {

	private static CalculationStrategy instance;

	public static CalculationStrategy getInstance() {
		if(instance == null) {
			instance = new PlusCalculationStrategy();
		}
		return instance;
	}

	private PlusCalculationStrategy() {
	}

	@Override
	public double calculate(double firstOperand, double secondOperand) {
		return firstOperand + secondOperand;
	}	

}
