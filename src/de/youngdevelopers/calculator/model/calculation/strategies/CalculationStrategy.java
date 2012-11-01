package de.youngdevelopers.calculator.model.calculation.strategies;

public interface CalculationStrategy {
	
	double calculate(double operand);

	double calculate(double firstOperand, Double secondOperand);
	
}
