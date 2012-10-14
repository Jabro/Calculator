package calculator.model;

import calculator.model.calculation.strategies.*;

public enum Operator {
	PLUS(new PlusCalculationStrategy()),
	MINUS(new MinusCalculationStrategy()), 
	MULTIPLICATION(new MultiplicationCalculationStrategy()),
	DIVISION(new DivisionCalculationStrategy());
	
	
	private CalculationStrategy calculationStrategy;

	Operator(CalculationStrategy strategy){
		this.setCalculationStrategy(strategy);
	}

	public CalculationStrategy getCalculationStrategy() {
		return calculationStrategy;
	}

	public void setCalculationStrategy(CalculationStrategy calculationStrategy) {
		this.calculationStrategy = calculationStrategy;
	}
}
