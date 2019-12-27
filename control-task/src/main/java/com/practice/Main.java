package com.practice;

import com.practice.controller.Controller;
import com.practice.model.ContactManager;
import com.practice.view.View;

/**
 * (@link Main) is the class that have role of program entry point.
 */
public class Main {
    public static void main(String[] args) {
        View view = new View();
        ContactManager manager = new ContactManager();

        Controller controller = new Controller(view, manager);
        controller.run();
    }
}
