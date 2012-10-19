package calculator.view.buttons;

import javax.swing.JButton;

import calculator.controller.InputValue;
import calculator.controller.commands.Command;

public interface ButtonListener {
	
	void onCommandButtonClicked(JButton button, Command command);

	void onInputButtonClicked(JButton button, InputValue input);
	
}
