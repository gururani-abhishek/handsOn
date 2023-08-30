package com.hsbc.exception;

// exception class that prompts when the user tries to add a new employee to the database but the employee is already present there.
public class EmployeeAlreadyExists extends RuntimeException {
	public EmployeeAlreadyExists(String message) {
		super(message);
	}
}
