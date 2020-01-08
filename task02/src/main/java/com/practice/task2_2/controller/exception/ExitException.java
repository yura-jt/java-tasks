package com.practice.task2_2.controller.exception;

/**
 * Thrown to indicate that an Exit command was performed
 **/
public class ExitException extends RuntimeException {
    public ExitException(String message) {
        super(message);
    }

    public ExitException() {
    }
}
