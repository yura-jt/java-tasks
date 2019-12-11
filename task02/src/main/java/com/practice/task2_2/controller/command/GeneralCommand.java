package com.practice.task2_2.controller.command;

import com.practice.task2_2.model.Model;
import com.practice.task2_2.view.View;

public abstract class GeneralCommand implements Command {
    final View view;
    final Model model;

    public GeneralCommand(View view, Model model) {
        this.view = view;
        this.model = model;
    }
}
