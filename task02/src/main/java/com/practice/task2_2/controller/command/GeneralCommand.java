package com.practice.task2_2.controller.command;

import com.practice.task2_2.model.Model;
import com.practice.task2_2.view.View;

/**
 * {@link GeneralCommand} is a general class for constructing commands
 */
public abstract class GeneralCommand implements Command {
    final View view;
    final Model model;

    /**
     * Initialize view and model component.
     *
     * @param model model component
     * @param view  view component
     */
    public GeneralCommand(View view, Model model) {
        this.view = view;
        this.model = model;
    }
}
