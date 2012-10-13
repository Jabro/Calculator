package calculator.model.events;

import java.util.EventListener;


public interface CalculatorEventListener extends EventListener{
	
	public void onResultChanged(ResultChangedEvent event);
	
}
