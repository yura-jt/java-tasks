package com.practice.task2_2.controller.command;

import com.practice.task2_2.model.Model;
import com.practice.task2_2.view.View;

/**
 * {@link Sort} is a command, that provides sorting books.
 */
public class Sort extends GeneralCommand {

    /**
     * Creates a Sort command instance, initialize it with view and
     * model component.
     *
     * @param model model component
     * @param view  view component
     */
    public Sort(View view, Model model) {
        super(view, model);
    }

    /**
     * This method check if provided string contains valid Sort command
     *
     * @param command command to validate
     * @return {@code true} if command is valid, {@code false} otherwise
     */
    @Override
    public boolean isValid(String command) {
        return command.startsWith("SORT");
    }

    /**
     * This method executes Sort command
     *
     * @param command command to execute
     */
    @Override
    public void execute(String command) {
        String key = command.split(" ")[1];

        if (key.equals("PUBLISHER")) {
            model.sortBooksByPublisher();
        }
        view.printBooks(model.getBooks());
    }
}