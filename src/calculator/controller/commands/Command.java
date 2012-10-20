package calculator.controller.commands;

public abstract class Command {
	
	private final String name;

	public Command(String name) {
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
