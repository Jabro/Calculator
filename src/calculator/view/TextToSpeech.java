package calculator.view;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class TextToSpeech extends Thread {

	private static final String QUOTE         = "\"";
	private static final String ESCAPED_QUOTE = "\\\"";
	private static final String SCRIPT_PATH   = "scripts\\calculator\\view\\";
	private static final String SCRIPT_NAME   = "textToSpeech.vbs";
	private static final int NO_ERROR = 0;
	private static TextToSpeech instance;
	private final Deque<String> textQueue = new LinkedList<String>();

	public void addText(String text) {
		textQueue.addLast(text);
	}

	static synchronized void speak(String text) {
		if(instance == null) {
			startNewInstance(text);
		} else {
			// thread is still running
			tryToAddTextToRunningThread(text);
		}
	}

	private static void tryToAddTextToRunningThread(String text) {
		try {
			// Prevent closing from running thread
			// before we can enter the text
			// Thread.sleep(1000); // for testing
			synchronized (instance.textQueue) {
				instance.addText(text);
			}
		} catch (NullPointerException e) {
			startNewInstance(text);
		}		
	}

	private static void startNewInstance(String text) {
		instance = new TextToSpeech();
		instance.addText(text);
		instance.start();
	}

	public void run() {
		while(instance != null) {
			String text = null;
			synchronized (textQueue) {
				if(!textQueue.isEmpty()) {
					text = textQueue.removeFirst();
				} else {
					instance = null;
				}
			}
			if(text != null) {
				runProcess(text);
			}
		}
	}

	private void runProcess(String text) {
		try {
			Process prozess = Runtime.getRuntime().exec(createCommand(text));
			int errorCode = prozess.waitFor();
			if(errorCode != NO_ERROR) {
				throw new RuntimeException("TextToSpeech not working correctly got error code:" + errorCode);
			}
		} catch(IOException e) {
			throw new RuntimeException("TextToSpeech not working correctly got exception with message:" + e.getMessage(), e);
		} catch (InterruptedException e) {
			throw new RuntimeException("TextToSpeech not working correctly got exception with message:" + e.getMessage(), e);
		}
	}

	private String createCommand(String text) {
		text.replace(QUOTE, ESCAPED_QUOTE);
		return "cmd /C " + SCRIPT_PATH + SCRIPT_NAME + " " + QUOTE + text + QUOTE;
	}

}
