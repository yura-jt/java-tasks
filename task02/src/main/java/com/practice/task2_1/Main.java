package com.practice.task2_1;

import com.practice.task2_1.controller.Controller;
import com.practice.task2_1.model.Figure;
import com.practice.task2_1.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Figure figure = new Figure();
        Controller controller = new Controller(figure, view);

        controller.run();
    }
}