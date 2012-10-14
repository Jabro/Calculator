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
	
	public void updateDisplay(String content);

	public void createFrame(Collection<Command> commands,
			Collection<InputValue> inputValues, Display display);

}
