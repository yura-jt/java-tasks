package com.practice.task2_2.controller.exception;

public class ExitException extends RuntimeException {
    public ExitException(String message) {
        super(message);
    }

    public ExitException() {
    }
}
