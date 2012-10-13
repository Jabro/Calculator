package calculator.model.events;

import java.util.EventListener;


public interface DisplayEventListener extends EventListener{
	
	public void onDisplayChanged(DisplayChangedEvent event);
	
}
