package com.practice.task2_2.controller.command;

public interface Command {
    boolean isValid(String command);

    void execute(String command);
}
