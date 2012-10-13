package calculator.view.buttons;

import javax.swing.JButton;

import calculator.controller.Command;
import calculator.controller.InputValue;

public interface ButtonListener {
	
	void onCommandButtonClicked(JButton button, Command command);

	void onInputButtonClicked(JButton button, InputValue input);
	
}
