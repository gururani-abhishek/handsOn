package com.hsbc.exception;

// exception class that prompts when the user is trying to register to a particular training but the training is not available in the database. 
public class TrainingNotAvailable extends RuntimeException {
	public TrainingNotAvailable(String message) {
		super(message);
	}

}
