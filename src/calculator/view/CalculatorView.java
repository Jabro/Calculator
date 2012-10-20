package calculator.view;

import java.util.Collection;

import calculator.controller.InputValue;
import calculator.controller.commands.Command;
import calculator.model.Calculator;
import calculator.model.Display;
import calculator.view.event.InputEventListener;

public interface CalculatorView {
	
	public void addInputListener(InputEventListener listener) ;
	
	public void removeInputListener(InputEventListener listener) ;
	
	public void updateDisplay(Display display);

	public void setModels(Collection<Command> commands,
			Collection<InputValue> inputValues, Calculator calculator);

	public void initilize();

}
