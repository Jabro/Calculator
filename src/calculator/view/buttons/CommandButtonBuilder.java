package calculator.view.buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import calculator.controller.Command;

public class CommandButtonBuilder extends ButtonBuilder {
	
	@Override
	public void buildText() {
		button.setText(reference.toString());
	}

	@Override
	public void buildStyle() {
		button.setBackground(Color.WHITE);
	}

	@Override
	public void buildActionListener(final ButtonListener listener) {
		final Command command = (Command) reference;
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.onCommandButtonClicked((JButton) e.getSource(), command);
			}
			
		});
	}

}
