package calculator.controller.commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import calculator.model.Calculator;

public abstract class Command implements ActionListener {
	
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
	public void actionPerformed(ActionEvent e) {
		execute();
	}

	@Override
	public String toString() {
		return getName();
	}
	
}
