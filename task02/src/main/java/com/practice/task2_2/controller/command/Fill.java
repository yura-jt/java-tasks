package com.practice.task2_2.controller.command;

import com.practice.task2_2.model.Book;
import com.practice.task2_2.model.Model;
import com.practice.task2_2.utils.DataGenerator;
import com.practice.task2_2.view.View;

/**
 * {@link Fill} is a command, that provides initializing 'Book Manager' app with
 * mock data.
 */
public class Fill extends GeneralCommand {
    private final static int DEFAULT_VALUE = 10;

    /**
     * Creates a Fill command instance, initialize it with view and
     * model component.
     *
     * @param model model component
     * @param view  view component
     */
    public Fill(View view, Model model) {
        super(view, model);
    }

    /**
     * This method check if provided string contains valid Fill command
     *
     * @param command command to validate
     * @return {@code true} if command is valid, {@code false} otherwise
     */
    @Override
    public boolean isValid(String command) {
        return command.startsWith("FILL");
    }

    /**
     * This method executes Fill command
     *
     * @param command command to execute
     */
    @Override
    public void execute(String command) {
        int number = DEFAULT_VALUE;
        if (command.split(" ").length > 1) {
            String arg = command.split(" ")[1].trim();
            if (isNumber(arg)) {
                number = Integer.parseInt(arg);
            }
        }
        Book[] books = DataGenerator.getBookArray(number);
        model.setBooks(books);
        model.setBookService();
        view.printBooks(books);
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
