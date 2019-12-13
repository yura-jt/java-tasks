package com.practice.task2_1.controller;

import com.practice.task2_1.model.Color;
import com.practice.task2_1.model.FigureType;
import com.practice.task2_1.model.entity.Circle;
import com.practice.task2_1.model.entity.Rectangle;
import com.practice.task2_1.model.entity.Shape;
import com.practice.task2_1.model.entity.Triangle;

public class ShapeBuilder {
    public static Shape createFigure(String[] args) {
        FigureType figureType = FigureType.valueOf(args[1].toUpperCase());
        Shape shape = null;
        if (figureType == FigureType.CIRCLE) {
            shape = createCircle(args);
        } else if (figureType == FigureType.RECTANGLE) {
            shape = createRectangle(args);
        } else if (figureType == FigureType.TRIANGLE) {
            shape = createTriangle(args);
        }
        return shape;
    }

    private static Shape createCircle(String[] args) {
        Color color = Color.valueOf(args[2].toUpperCase());
        double radius = Double.parseDouble(args[3]);
        return new Circle(color, radius);
    }

    private static Shape createRectangle(String[] args) {
        Color color = Color.valueOf(args[2].toUpperCase());
        double a = Double.parseDouble(args[3]);
        double b = Double.parseDouble(args[4]);
        return new Rectangle(color, a, b);
    }

    private static Shape createTriangle(String[] args) {
        Color color = Color.valueOf(args[2].toUpperCase());
        double a = Double.parseDouble(args[3]);
        double b = Double.parseDouble(args[4]);
        double c = Double.parseDouble(args[5]);
        return new Triangle(color, a, b, c);
    }
}
