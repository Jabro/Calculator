package calculator.model;

import java.util.EventObject;

public class ResultChangedEvent extends EventObject{

	private static final long serialVersionUID = 1150745927450884358L;
	private final double result;
	
	public ResultChangedEvent(Object source, double result) {
		super(source);
		this.result = result;		
	}

	public double getResult() {
		return result;
	}
	
}
