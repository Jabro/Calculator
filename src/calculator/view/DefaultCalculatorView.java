package calculator.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.EventListenerList;

import calculator.controller.DefaultCalculatorController;
import calculator.controller.Command;

public class DefaultCalculatorView implements CalculatorView{

	private EventListenerList listeners = new EventListenerList();
	private DefaultCalculatorController controller;
	private JTextField display;
	
	public static void main(String[] args) {
		new DefaultCalculatorView();
	}
	
	public DefaultCalculatorView() {
		controller = new DefaultCalculatorController(this);
		createFrame();
	}

	private void createFrame() {
		JFrame frame = new JFrame("Klausur");

		// Start button
		JButton startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO Call method
			}
			
		});

		// Status field
		display = new JTextField();
		display.setEditable(false);
		
		// Panel
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 0, 0));

			
		// Buttons
		Collection<Command> commands = controller.getCommands();
		for (final Command command : commands) {
			JButton button = new JButton(command.getName());
			button.setBackground(Color.WHITE);
			button.setActionCommand(command.getName());
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					raiseCommandEnteredEvent(new CommandEnteredEvent(this, command));
				}

			});
			center.add(button);
		}	

		frame.setLayout(new BorderLayout());
		frame.add(startButton, BorderLayout.NORTH);
		//frame.add(panel);
		frame.add(new JScrollPane(center));
		frame.add(display, BorderLayout.SOUTH);
			
		frame.setSize(450, 450);		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

	public void addCommandListener(CommandListener listener) {
		listeners.add(CommandListener.class, listener);
	}
	
	public void removeCommandListener(CommandListener listener) {
		listeners.remove(CommandListener.class, listener);
	}
	
	public void addInputListener(InputListener listener) {
		listeners.add(InputListener.class, listener);
	}
	
	public void removeInputListener(InputListener listener) {
		listeners.remove(InputListener.class, listener);
	}
	
	private void raiseCommandEnteredEvent(CommandEnteredEvent event) {
		for (CommandListener listener : listeners.getListeners(CommandListener.class)) {
			listener.onCommandEntered(event);
		}
	}
	
	private void raiseInputEnteredEvent(InputEnteredEvent event) {
		for (InputListener listener : listeners.getListeners(InputListener.class)) {
			listener.onInputEntered(event);
		}
	}

	@Override
	public void updateDisplay(String content) {
		display.setText(content);
	}

}
