package com.salary.salary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)
public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException() {

    }

    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
