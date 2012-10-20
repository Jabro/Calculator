package calculator.controller.commands;

import calculator.model.Calculator;

public abstract class Command {
	
	private final String name;
	protected final Calculator calculator;

	public Command(Calculator calculator, String name) {
		this.calculator = calculator;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	abstract public void execute();

	@Override
	public String toString() {
		return getName();
	}
	
}
