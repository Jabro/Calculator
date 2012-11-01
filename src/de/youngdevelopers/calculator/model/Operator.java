package de.youngdevelopers.calculator.model;

import de.youngdevelopers.calculator.model.calculation.strategies.*;

public enum Operator {
	
	PLUS("+", PlusCalculationStrategy.getInstance()),
	MINUS("-", MinusCalculationStrategy.getInstance()), 
	MULTIPLICATION("*", MultiplicationCalculationStrategy.getInstance()),
	DIVISION("/", DivisionCalculationStrategy.getInstance()),
	SQUARE_ROOT("sqrt", SquareRootCalculationStrategy.getInstance());
	
	private final CalculationStrategy calculationStrategy;
	private final String sign;

	Operator(String sign, CalculationStrategy strategy){
		this.sign = sign;
		calculationStrategy = strategy;
	}

	public CalculationStrategy getCalculationStrategy() {
		return calculationStrategy;
	}

	public String getSign() {
		return sign;
	}
	
	@Override
	public String toString() {
		return getSign();
	}
	
}
