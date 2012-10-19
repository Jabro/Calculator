package calculator.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.EventListenerList;

import calculator.controller.InputValue;
import calculator.controller.commands.Command;
import calculator.model.Display;
import calculator.model.PocketCalculator;
import calculator.view.buttons.ButtonBuilder;
import calculator.view.buttons.ButtonListener;
import calculator.view.buttons.CommandButtonBuilder;
import calculator.view.buttons.InputButtonBuilder;
import calculator.view.event.InputEnteredEvent;
import calculator.view.event.InputEventListener;

public class PocketCalculatorView implements CalculatorView, ButtonListener{

	private EventListenerList listeners = new EventListenerList();
	private JTextField displayField;
	private Collection<Command> commands;
	private Collection<InputValue> inputValues;
	private PocketCalculator pocketCalculator;

	@Override
	public void setModels(Collection<Command> commands,
			Collection<InputValue> inputValues, PocketCalculator pocketCalculator) {
				this.commands = commands;
				this.inputValues = inputValues;
				this.pocketCalculator = pocketCalculator;
	}
	
	@Override
	public void initilize() {
		JButton[] inputButtons = buildButtons(inputValues, new InputButtonBuilder());
		JButton[] commandButtons = buildButtons(commands, new CommandButtonBuilder());
				
		createDisplayField(pocketCalculator.getDisplay());
		JPanel panel = createPanel();
		addButtons(panel, inputButtons);
		addButtons(panel, commandButtons);
		
		JFrame frame = new JFrame("Calculator");
		frame.setLayout(new BorderLayout());
		frame.add(displayField, BorderLayout.NORTH);
		frame.add(panel);		
		frame.setSize(350, 350);		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private void createDisplayField(Display display) {
		displayField = new JTextField(display.getContent());
		displayField.setEditable(false);
	}

	private JPanel createPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		return panel;
	}

	private void addButtons(JPanel panel, JButton[] buttons) {
		for (int i = 0; i < buttons.length; i++) {
			panel.add(buttons[i]);
		}
	}

	private JButton[] buildButtons(Collection<? extends Object> refences, ButtonBuilder builder) {
		JButton[] buttons = new JButton[refences.size()];
		int i = 0;
		for (final Object reference : refences) {
			builder.createNewButton(reference);
			builder.buildText();
			builder.buildStyle();
			builder.buildActionListener(this);
			buttons[i++] = builder.getButton();
		}
		return buttons;
	}

	@Override
	public void updateDisplay(Display display) {
		if(display.isErrorMessage()) {
			TextToSpeech.speak(display.getContent());
		}
		displayField.setText(display.getContent());
	}

	@Override
	public void onCommandButtonClicked(JButton button, Command command) {
		command.execute();
	}

	@Override
	public void onInputButtonClicked(JButton button, InputValue input) {
		raiseInputEnteredEvent(new InputEnteredEvent(this, input));
	}

	public void addInputListener(InputEventListener listener) {
		listeners.add(InputEventListener.class, listener);
	}

	public void removeInputListener(InputEventListener listener) {
		listeners.remove(InputEventListener.class, listener);
	}

	private void raiseInputEnteredEvent(InputEnteredEvent event) {
		for (InputEventListener listener : listeners.getListeners(InputEventListener.class)) {
			listener.onInputEntered(event);
		}
	}

}
