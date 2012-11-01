package de.youngdevelopers.calculator.model.calculation.strategies;

public final class SquareRootCalculationStrategy extends UnaryCalculationStrategy {

	private static CalculationStrategy instance;

	public static CalculationStrategy getInstance() {
		if(instance == null) {
			instance = new SquareRootCalculationStrategy();
		}
		return instance;
	}
	
	private SquareRootCalculationStrategy() {
	}

	@Override
	public double calculate(double operand) {
		return Math.sqrt(operand);
	}	

}
