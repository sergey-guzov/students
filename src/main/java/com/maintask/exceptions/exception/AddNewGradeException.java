package com.maintask.exceptions.exception;

public class AddNewGradeException extends RuntimeException {
    public AddNewGradeException() {
    }

    public AddNewGradeException(String message) {
        super(message);
    }

    public AddNewGradeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddNewGradeException(Throwable cause) {
        super(cause);
    }
}
