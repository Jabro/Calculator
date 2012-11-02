package de.youngdevelopers.calculator.view;

public class TextToSpeechRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -4857409426261383645L;

	public TextToSpeechRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public TextToSpeechRuntimeException(String message) {
		super(message);
	}
	
}
