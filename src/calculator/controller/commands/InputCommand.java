package calculator.controller.commands;

import calculator.model.Calculator;

public class InputCommand extends Command {

	private final String value;

	public InputCommand(Calculator calculator, String name) {
		super(calculator, name);
		this.value = getName();		
	}
	
	public InputCommand(Calculator calculator, String name, String value) {
		super(calculator, name);
		this.value = value;		
	}

	@Override
	public void execute() {
		calculator.useInput(value);
	}
	
}
