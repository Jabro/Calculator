package calculator.model.display.event;

import java.util.EventListener;


public interface DisplayEventListener extends EventListener{
	
	public void onDisplayChanged(DisplayChangedEvent event);
	
}
