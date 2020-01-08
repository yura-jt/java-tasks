package com.practice.task2_2;

import com.practice.task2_2.controller.Controller;
import com.practice.task2_2.model.Model;
import com.practice.task2_2.view.View;

/**
 * {@link Main} is an entry point to the program 'Book Manager'.
 */
public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        controller.processBooks();
    }
}