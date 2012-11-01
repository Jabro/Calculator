package de.youngdevelopers.calculator.model.calculation.strategies;

public abstract class UnaryCalculationStrategy implements CalculationStrategy{

	public final double calculate(double firstOperand, Double secondOperand) {
		return calculate(firstOperand);
	}
	
}
