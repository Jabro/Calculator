package de.youngdevelopers.calculator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.youngdevelopers.calculator.controller.commands.Command;

public class CommandInvoker  implements ActionListener {
	
	private final Command command;

	public CommandInvoker(Command command) {
		this.command = command;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		command.execute();
	}
	
}
