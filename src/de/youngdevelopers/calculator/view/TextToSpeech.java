package de.youngdevelopers.calculator.view;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class TextToSpeech implements Runnable {

	private static final String QUOTE         = "\"";
	private static final String ESCAPED_QUOTE = "\\\"";
	private static final String SCRIPT_PATH   = "scripts\\calculator\\view\\";
	private static final String SCRIPT_NAME   = "textToSpeech.vbs";
	private static final int NO_ERROR = 0;
	private final String text;
	private static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor();
	
	private TextToSpeech(String text) {
		this.text = text;
	}
	
	static void speak(String text) {
		EXECUTOR.execute(new TextToSpeech(text));
	}

	@Override
	public void run() {
		try {
			runProcess();
		} catch(IOException | InterruptedException e) {
			throw new TextToSpeechRuntimeException("TextToSpeech not working correctly got exception with message:" + e.getMessage(), e);
		}
	}

	private void runProcess() throws IOException, InterruptedException {
		Process process = Runtime.getRuntime().exec(createCommand(text));
		int errorCode = process.waitFor();
		if(errorCode != NO_ERROR) {
			throw new TextToSpeechRuntimeException("TextToSpeech not working correctly got error code:" + errorCode);
		}		
	}

	private String createCommand(String text) {
		text.replace(QUOTE, ESCAPED_QUOTE);
		return "cmd /C " + SCRIPT_PATH + SCRIPT_NAME + " " + QUOTE + text + QUOTE;
	}

}
