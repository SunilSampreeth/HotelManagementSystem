package com.bitlabs;

public class InvalidChoiceException extends Exception {
private String message;
public InvalidChoiceException(String message){
	super(message);
}
}
