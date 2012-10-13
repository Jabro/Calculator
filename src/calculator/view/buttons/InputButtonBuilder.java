package calculator.view.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import calculator.controller.InputValue;

public class InputButtonBuilder extends ButtonBuilder {

	@Override
	public void buildText() {
		button.setText(reference.toString());
	}

	@Override
	public void buildStyle() {
	}

	@Override
	public void buildActionListener(final ButtonListener listener) {
		final InputValue input = (InputValue) reference;
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener.onInputButtonClicked((JButton) e.getSource(), input);
			}

		});
	}

}
