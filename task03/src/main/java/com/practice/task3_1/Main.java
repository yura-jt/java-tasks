package com.practice.task3_1;

import com.practice.task3_1.controller.Controller;
import com.practice.task3_1.model.Model;
import com.practice.task3_1.view.View;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.playToys();
    }
}
