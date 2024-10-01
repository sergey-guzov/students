package com.maintask.exceptions.exception;

public class FacultyGradesException extends RuntimeException{
    public FacultyGradesException() {
    }

    public FacultyGradesException(String message) {
        super(message);
    }

    public FacultyGradesException(String message, Throwable cause) {
        super(message, cause);
    }

    public FacultyGradesException(Throwable cause) {
        super(cause);
    }
}
