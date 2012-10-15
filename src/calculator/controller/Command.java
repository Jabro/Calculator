package calculator.controller;

import calculator.model.Operator;

public class Command {

	private final Operator operator;
	private final String name;
	private final boolean isCalculationRequired;

	public Command(String name) {
		this.name = name;
		this.isCalculationRequired = false;
		this.operator = null;
	}
	
	public Command(String name, boolean isCalculationRequired) {
		this.name = name;
		this.isCalculationRequired = isCalculationRequired;
		this.operator = null;
	}
	
	public Command(Operator operator) {
		this.name = operator.getSign();
		this.isCalculationRequired = true;
		this.operator = operator;
	}
	
	public Operator getOperator() {
		return operator;
	}

	public String getName() {
		return name;
	}

	public boolean hasOperator() {
		return getOperator() != null;
	}

	public boolean isCalculationRequired() {
		return isCalculationRequired;
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
}
