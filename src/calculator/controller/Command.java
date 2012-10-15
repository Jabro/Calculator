package calculator.controller;

import calculator.model.Operator;

public class Command {
	
	public enum Type {
		OPERATOR,
		CLEAR,
		CALCULATION;
	}

	private final Operator operator;
	private final String name;
	private final Type type;

	public Command(String name, Type type) {
		this.name = name;
		this.operator = null;
		this.type = type;
	}
	
	public Command(Operator operator) {
		this.name = operator.getSign();
		this.operator = operator;
		this.type = Type.OPERATOR;
	}
	
	public Operator getOperator() {
		return operator;
	}

	public String getName() {
		return name;
	}
	
	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return getName();
	}
	
}
