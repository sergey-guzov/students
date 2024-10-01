package com.maintask.exceptions.exception;

public class StudentGradesException extends RuntimeException {
    public StudentGradesException() {
    }

    public StudentGradesException(String message) {
        super(message);
    }

    public StudentGradesException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentGradesException(Throwable cause) {
        super(cause);
    }
}
