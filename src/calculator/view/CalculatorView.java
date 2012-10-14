package calculator.view;

import java.util.Collection;

import calculator.controller.Command;
import calculator.controller.InputValue;
import calculator.model.Display;
import calculator.view.events.CommandEventListener;
import calculator.view.events.InputEventListener;

public interface CalculatorView {
	
	public void addCommandListener(CommandEventListener listener);
	
	public void removeCommandListener(CommandEventListener listener);
	
	public void addInputListener(InputEventListener listener) ;
	
	public void removeInputListener(InputEventListener listener) ;
	
	public void updateDisplay(Display display);

	public void setModels(Collection<Command> commands,
			Collection<InputValue> inputValues, Display display);

	public void initilize();

}
