package com.salary.salary.exception;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException() {

    }

    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}
