package de.youngdevelopers.calculator.model.display.event;

import java.util.EventListener;


public interface DisplayEventListener extends EventListener{
	
	void onDisplayChanged(DisplayChangedEvent event);
	
}
