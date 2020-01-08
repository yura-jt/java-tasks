package com.practice.task2_2.controller.command;

import com.practice.task2_2.model.Book;
import com.practice.task2_2.model.Model;
import com.practice.task2_2.view.Message;
import com.practice.task2_2.view.View;

/**
 * {@link Get} is a command, that provides receiving books by query.
 */
public class Get extends GeneralCommand {
    /**
     * Creates a Get command instance, initialize it with view and
     * model component.
     *
     * @param model model component
     * @param view  view component
     */
    public Get(View view, Model model) {
        super(view, model);
    }

    /**
     * This method check if provided string contains valid Get command
     *
     * @param command command to validate
     * @return {@code true} if command is valid, {@code false} otherwise
     */
    @Override
    public boolean isValid(String command) {
        return command.startsWith("GET");
    }

    /**
     * This method executes Get command
     *
     * @param command command to execute
     */
    @Override
    public void execute(String command) {
        String key = command.split(" ")[1];
        String arg = makeArgString(command, key).trim();
        Book[] result = new Book[0];
        if (key.equals("AUTHOR")) {
            result = model.getByAuthor(arg);
        }
        if (key.equals("PUBLISHER")) {
            result = model.getByPublisher(arg);
        }
        if (key.equals("YEAR")) {
            boolean argIsNumber = isNumber(arg);
            if (argIsNumber) {
                result = model.getPublishedAfterYear(Integer.parseInt(arg));
            }
        }
        if (result.length == 0) {
            view.printMessage(Message.DATA_NOT_FOUND_MESSAGE);
        } else {
            view.printBooks(result);
        }
    }

    private String makeArgString(String command, String key) {
        String commandAndKey = "GET " + key;
        return command.substring(commandAndKey.length());
    }

    private boolean isNumber(String s) {
        boolean isNumber = false;
        try {
            Integer.parseInt(s);
            isNumber = true;
        } catch (NumberFormatException e) {
        }
        return isNumber;
    }
}