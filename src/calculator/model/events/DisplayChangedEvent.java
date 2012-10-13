package calculator.model.events;

import java.util.EventObject;

public class DisplayChangedEvent extends EventObject{

	private static final long serialVersionUID = 1150745927450884358L;
	private final String content;
	
	public DisplayChangedEvent(Object source, String content) {
		super(source);
		this.content = content;		
	}

	public String getContent() {
		return content;
	}
	
}
