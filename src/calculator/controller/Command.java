package calculator.controller;

import calculator.model.operator.Operator;

public class Command {

	private final Operator operator;
	private final String name;

	public Command(String name) {
		this.name = name;
		this.operator = null;
	}
	
	public Command(String name, Operator operator) {
		this.name = name;
		this.operator = operator;
	}
	
	public Operator getOperator() {
		return operator;
	}

	public String getName() {
		return name;
	}
	
}
