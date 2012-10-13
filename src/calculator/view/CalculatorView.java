package calculator.view;

import calculator.view.events.CommandEventListener;
import calculator.view.events.InputEventListener;

public interface CalculatorView {
	
	public void addCommandListener(CommandEventListener listener);
	
	public void removeCommandListener(CommandEventListener listener);
	
	public void addInputListener(InputEventListener listener) ;
	
	public void removeInputListener(InputEventListener listener) ;
	
	public void updateDisplay(String content);

}
