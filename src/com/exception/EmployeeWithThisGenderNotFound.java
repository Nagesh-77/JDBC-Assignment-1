package com.exception;

public class EmployeeWithThisGenderNotFound extends RuntimeException{
	public EmployeeWithThisGenderNotFound(String msg) {
		super(msg);
	}
}
