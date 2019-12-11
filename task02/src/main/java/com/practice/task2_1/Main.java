package com.practice.task2_1;

import com.practice.task2_1.controller.Controller;
import com.practice.task2_1.model.Figure;
import com.practice.task2_1.model.Shape;
import com.practice.task2_1.utils.DataGenerator;
import com.practice.task2_1.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Figure figure = new Figure();

        Shape[] figures = DataGenerator.getFilledShapeArray(10);
        figure.setFigures(figures);

        Controller controller = new Controller(figure, view);
        controller.run();
    }
}