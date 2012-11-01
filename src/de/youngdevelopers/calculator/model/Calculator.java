package de.youngdevelopers.calculator.model;

import de.youngdevelopers.calculator.model.display.event.DisplayEventListener;

public interface Calculator {

	public void addListener(DisplayEventListener listener);

	public void removeListener(DisplayEventListener listener);

	public void useOperator(Operator operator);

	public void calculateFromEqualSign();

	public void useInput(String input);

	public void executeClear();

	public Display getDisplay();

}
