package de.youngdevelopers.calculator.model;

import java.util.EventListener;


public interface DisplayEventListener extends EventListener{
	
	void onDisplayChanged(DisplayChangedEvent event);
	
}
