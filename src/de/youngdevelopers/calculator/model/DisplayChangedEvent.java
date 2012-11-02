package de.youngdevelopers.calculator.model;

import java.util.EventObject;


public class DisplayChangedEvent extends EventObject{

	private static final long serialVersionUID = 1150745927450884358L;
	private final Display display;
	
	public DisplayChangedEvent(Object source, Display display) {
		super(source);
		this.display = display;		
	}

	public Display getDisplay() {
		return display;
	}
	
}
