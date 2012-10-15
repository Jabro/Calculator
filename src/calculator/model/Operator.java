package calculator.model;

import calculator.model.calculation.strategies.*;

public enum Operator {
	PLUS("+", new PlusCalculationStrategy()),
	MINUS("-", new MinusCalculationStrategy()), 
	MULTIPLICATION("*", new MultiplicationCalculationStrategy()),
	DIVISION("/", new DivisionCalculationStrategy());
	
	
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
