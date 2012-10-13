package calculator.view;

public interface CalculatorView {
	
	public void addCommandListener(CommandListener listener);
	
	public void removeCommandListener(CommandListener listener);
	
	public void addInputListener(InputListener listener) ;
	
	public void removeInputListener(InputListener listener) ;
	
	public void updateDisplay(String content);

}
