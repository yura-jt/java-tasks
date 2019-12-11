package com.practice.task2_2.controller.command;

import com.practice.task2_2.model.Book;
import com.practice.task2_2.model.Model;
import com.practice.task2_2.view.View;

public class Get extends GeneralCommand {
    public Get(View view, Model model) {
        super(view, model);
    }

    @Override
    public boolean isValid(String command) {
        return command.startsWith("GET");
    }

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
        view.printBooks(result);
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
