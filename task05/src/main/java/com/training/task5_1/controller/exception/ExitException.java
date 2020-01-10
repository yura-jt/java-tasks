package com.training.task5_1.controller.exception;

public class ExitException extends RuntimeException {
    public ExitException(String message) {
        super(message);
    }

    public ExitException() {
    }
}