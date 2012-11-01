package de.youngdevelopers.calculator.view;

import java.util.Collection;

import de.youngdevelopers.calculator.controller.commands.Command;
import de.youngdevelopers.calculator.model.Calculator;
import de.youngdevelopers.calculator.model.Display;

public interface CalculatorView {
	
	void updateDisplay(Display display);

	void initilize(Collection<Command> commands, Calculator calculator);

}
