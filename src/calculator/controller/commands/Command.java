package calculator.controller.commands;

import calculator.model.PocketCalculator;

public abstract class Command {
	
	private final String name;
	protected final PocketCalculator pocketCalculator;

	public Command(PocketCalculator pocketCalculator, String name) {
		this.pocketCalculator = pocketCalculator;
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
