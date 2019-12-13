package com.practice.task2_2.controller;

import com.practice.task2_2.controller.command.*;
import com.practice.task2_2.controller.exception.ExitException;
import com.practice.task2_2.model.Model;
import com.practice.task2_2.view.Message;
import com.practice.task2_2.view.View;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private View view;
    private List<Command> commands;

    public Controller(Model model, View view) {
        this.view = view;
        commands = new ArrayList<>();
        commands.add(new Get(view, model));
        commands.add(new Sort(view, model));
        commands.add(new Fill(view, model));
        commands.add(new Demo(view, model));
        commands.add(new Exit(view, model));
    }

    public void processBooks() {
        view.printMessage(Message.MENU_PROMPT);
        while (true) {
            try {
                String inputCommand = view.getCommandFromConsole();
                for (Command command : commands) {
                    if (command.isValid(inputCommand)) {
                        command.execute(inputCommand);
                        break;
                    }
                }
            } catch (Exception e) {
                if (e instanceof ExitException) {
                    break;
                }
            }
        }
    }
}
