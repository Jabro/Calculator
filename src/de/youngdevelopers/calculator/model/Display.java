package de.youngdevelopers.calculator.model;

public interface Display {

	void clear();

	void addDigit(int digit);

	void setContent(String content);

	void addContent(String suffix);

	void setNumber(Double number);

	String getContent();

	double getNumber();

	void setErrorState();

	boolean isErrorMessage();

}
