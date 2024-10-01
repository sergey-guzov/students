package com.maintask.exceptions.exception;

public class GroupGradeException extends RuntimeException {
    public GroupGradeException() {
    }

    public GroupGradeException(String message) {
        super(message);
    }

    public GroupGradeException(String message, Throwable cause) {
        super(message, cause);
    }

    public GroupGradeException(Throwable cause) {
        super(cause);
    }
}
