package com.practice.task2_2.controller.command;

import com.practice.task2_2.model.Model;
import com.practice.task2_2.view.View;

public class Sort extends GeneralCommand {
    public Sort(View view, Model model) {
        super(view, model);
    }

    @Override
    public boolean isValid(String command) {
        return command.startsWith("SORT");
    }

    @Override
    public void execute(String command) {
        String key = command.split(" ")[1];

        if (key.equals("PUBLISHER")) {
            model.sortBooksByPublisher();
        }
        view.printBooks(model.getBooks());
    }
}
