package de.youngdevelopers.calculator.view.pocketcalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import de.youngdevelopers.calculator.controller.commands.Command;
import de.youngdevelopers.calculator.controller.commands.InputDigitCommand;
import de.youngdevelopers.calculator.model.Calculator;
import de.youngdevelopers.calculator.model.Display;
import de.youngdevelopers.calculator.view.CalculatorView;
import de.youngdevelopers.calculator.view.CommandInvoker;
import de.youngdevelopers.calculator.view.texttospeech.TextToSpeech;

public class PocketCalculatorView implements CalculatorView {

	private static final int COLUMN_COUNT = 3;
	private static final int DEFAULT_FRAME_HEIGHT = 350;
	private static final int DEFAULT_FRAME_WIDTH  = 350;
	private JTextField displayField;

	@Override
	public void initilize(Collection<Command> commands, Calculator calculator) {
		createDisplayField(calculator.getDisplay());
		JPanel panel = createPanel();
		addButtons(panel, createCommandButtons(commands));
		JFrame frame = new JFrame("Calculator");
		frame.setLayout(new BorderLayout());
		frame.add(displayField, BorderLayout.NORTH);
		frame.add(panel);		
		frame.setSize(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT);		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private JButton[] createCommandButtons(Collection<Command> commands) {
		JButton[] buttons = new JButton[commands.size()];
		int i = 0;
		for (final Command command : commands) {
			JButton button = new JButton();
			button.setText(command.getName());
			if(!(command instanceof InputDigitCommand)) {
				button.setBackground(Color.WHITE);
			}
			button.addActionListener(new CommandInvoker(command));
			buttons[i++] = button;
		}
		return buttons;
	}

	private void createDisplayField(Display display) {
		displayField = new JTextField(display.getContent());
		displayField.setEditable(false);
	}

	private JPanel createPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, COLUMN_COUNT, 0, 0));
		return panel;
	}

	private void addButtons(JPanel panel, JButton[] buttons) {
		for (int i = 0; i < buttons.length; i++) {
			panel.add(buttons[i]);
		}
	}

	@Override
	public void updateDisplay(Display display) {
		if(display.isErrorMessage()) {
			TextToSpeech.speak(display.getContent());
		}
		displayField.setText(display.getContent());
	}

}
