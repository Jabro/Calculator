package calculator.view;

import java.util.Collection;

import calculator.controller.InputValue;
import calculator.controller.commands.Command;
import calculator.model.display.Display;
import calculator.model.pocket.calculator.PocketCalculator;
import calculator.view.events.InputEventListener;

public interface CalculatorView {
	
	public void addInputListener(InputEventListener listener) ;
	
	public void removeInputListener(InputEventListener listener) ;
	
	public void updateDisplay(Display display);

	public void setModels(Collection<Command> commands,
			Collection<InputValue> inputValues, PocketCalculator pocketCalculator);

	public void initilize();

}
