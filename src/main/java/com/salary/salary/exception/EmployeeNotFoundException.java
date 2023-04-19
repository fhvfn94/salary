package com.salary.salary.exception;

public class EmployeeNotFoundException extends RuntimeException {
    EmployeeNotFoundException() {

    }

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
