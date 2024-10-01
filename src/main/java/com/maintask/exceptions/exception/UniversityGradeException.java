package com.maintask.exceptions.exception;

public class UniversityGradeException extends RuntimeException {
    public UniversityGradeException() {
    }

    public UniversityGradeException(String message) {
        super(message);
    }

    public UniversityGradeException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniversityGradeException(Throwable cause) {
        super(cause);
    }
}
