package calculator.view;

import java.io.IOException;

public class TextToSpeech extends Thread {

	private static final String QUOTE         = "\"";
	private static final String ESCAPED_QUOTE = "\\\"";
	private static final String SCRIPT_PATH   = "scripts\\calculator\\view\\";
	private static final String SCRIPT_NAME   = "textToSpeech.vbs";
	private static final int NO_ERROR = 0;
	private final String text;
	
	public TextToSpeech(String text) {
		text.replace(QUOTE, ESCAPED_QUOTE);
		this.text = text;	
	}

	static void speak(String text) {
		new TextToSpeech(text).start();
	}
	
	public void run() {
		try {
			Process prozess = Runtime.getRuntime().exec(createCommand());
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

	private String createCommand() {
		return "cmd /C " + SCRIPT_PATH + SCRIPT_NAME + " " + QUOTE + text + QUOTE;
	}
	
}
