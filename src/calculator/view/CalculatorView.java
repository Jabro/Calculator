package calculator.view;

import java.util.Collection;

import calculator.controller.commands.Command;
import calculator.model.Calculator;
import calculator.model.Display;

public interface CalculatorView {
	
	public void updateDisplay(Display display);

	public void initilize(Collection<Command> commands, Calculator calculator);

}
