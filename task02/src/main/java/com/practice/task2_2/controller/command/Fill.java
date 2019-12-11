package com.practice.task2_2.controller.command;

import com.practice.task2_2.model.Book;
import com.practice.task2_2.model.Model;
import com.practice.task2_2.utils.DataGenerator;
import com.practice.task2_2.view.View;

public class Fill extends GeneralCommand {
    final static int DEFAULT_VALUE = 10;

    public Fill(View view, Model model) {
        super(view, model);
    }

    @Override
    public boolean isValid(String command) {
        return command.startsWith("FILL");
    }

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
