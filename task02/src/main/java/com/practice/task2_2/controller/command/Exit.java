package com.practice.task2_2.controller.command;

import com.practice.task2_2.controller.exception.ExitException;
import com.practice.task2_2.model.Model;
import com.practice.task2_2.view.View;

/**
 * {@link Exit} is a command, that provides exit app.
 */
public class Exit extends GeneralCommand {
    /**
     * Creates an Exit command instance, initialize it with view and
     * model component.
     *
     * @param model model component
     * @param view  view component
     */
    public Exit(View view, Model model) {
        super(view, model);
    }

    /**
     * This method check if provided string contains valid Exit command
     *
     * @param command command to validate
     * @return {@code true} if command is valid, {@code false} otherwise
     */
    @Override
    public boolean isValid(String command) {
        return command.startsWith("EXIT");
    }

    /**
     * This method executes Exit command
     *
     * @param command command to execute
     * @throws ExitException if Exit command was executed
     */
    @Override
    public void execute(String command) {
        throw new ExitException("* * * Program is closing. Good-bye! * * *");
    }
}
