package com.practice.task2_2.controller.command;

import com.practice.task2_2.controller.exception.ExitException;
import com.practice.task2_2.model.Model;
import com.practice.task2_2.view.View;

public class Exit extends GeneralCommand {
    public Exit(View view, Model model) {
        super(view, model);
    }

    @Override
    public boolean isValid(String command) {
        return command.startsWith("EXIT");
    }

    @Override
    public void execute(String command) {
        throw new ExitException("* * * Program is closing. Good-bye! * * *");
    }
}
