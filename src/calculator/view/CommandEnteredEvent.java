package calculator.view;

import java.util.EventObject;

import calculator.controller.Command;

public class CommandEnteredEvent extends EventObject {

	private static final long serialVersionUID = -2188551669582304034L;
	private final Command command;
	
	public CommandEnteredEvent(Object source, Command command) {
		super(source);
		this.command = command;
	}

	public Command getCommand() {
		return command;
	}
	
}

