package com.practice.task2_2.controller.command;

/**
 * Defines an API for using commands.
 */
public interface Command {
    boolean isValid(String command);

    void execute(String command);
}
