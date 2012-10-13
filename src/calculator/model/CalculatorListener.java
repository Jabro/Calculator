package calculator.model;

import java.util.EventListener;

public interface CalculatorListener extends EventListener{
	
	public void onResultChanged(ResultChangedEvent event);
	
}
