package calculator.view;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TextToSpeech extends Thread {

	private static final String QUOTE         = "\"";
	private static final String ESCAPED_QUOTE = "\\\"";
	private static final String SCRIPT_PATH   = "scripts\\calculator\\view\\";
	private static final String SCRIPT_NAME   = "textToSpeech.vbs";
	private static final int NO_ERROR = 0;
	private static TextToSpeech instance;
	private final static Queue<String> textQueue = new ConcurrentLinkedQueue<String>();

	static void speak(String text) {
		textQueue.add(text);
		if(instance == null) {
			synchronized (textQueue) {
				if(instance == null) {
					instance = new TextToSpeech();
					instance.start();
				}
			}
		}
	}

	public void run() {
		String text = null;
		do{
			if((text = textQueue.poll()) != null) {
				runProcess(text);
			} else {
				instance = null;
			}
		} while(instance != null);
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
