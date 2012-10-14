package calculator.model;

import calculator.model.calculation.strategies.*;

public enum Operator {
	PLUS(new PlusCalculationStrategy()),
	MINUS(new MinusCalculationStrategy()), 
	MULTIPLICATION(new MultiplicationCalculationStrategy()),
	DIVISION(new DivisionCalculationStrategy());
	
	
	private final CalculationStrategy calculationStrategy;

	Operator(CalculationStrategy strategy){
		calculationStrategy = strategy;
	}

	public CalculationStrategy getCalculationStrategy() {
		return calculationStrategy;
	}
}
