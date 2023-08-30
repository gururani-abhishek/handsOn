package com.hsbc.exception;

// exception class that prompts when use is trying to create a training but the training already exists in the database
public class TrainingAlreadyExists extends RuntimeException {
	public TrainingAlreadyExists(String message) {
		super(message);
	}
}
