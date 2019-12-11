package com.practice.task2_1.utils;

import com.practice.task2_1.model.*;

import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {
    private static final double[][] RECTANGLE_DIMENSIONS = {{5.0, 10.5}, {25.5, 10.2},
            {4.3, 7.5}, {15.7, 15.6}, {4, 5}, {7.6, 5.6}, {1.0, 2.3}, {14.4, 2.7}};
    private static final double[][] TRIANGLE_DIMENSIONS = {{14.7, 15.9}, {10.0, 20.0},
            {5.0, 7.0}, {15.4, 8.9}, {16.0, 32.5}, {4.3, 7.8}, {8.9, 10.2}, {10.4, 15.2}};
    private static final double[] CIRCLE_DIMENSIONS = {1.5, 3.4, 5.6, 9.4, 7.0, 9.5, 10.0, 8.4};

    private final static String[] COLORS = {"RED", "ORANGE", "YELLOW", "GREEN",
            "BLUE", "VIOLET", "PINK", "BROWN", "BLACK", "WHITE"};

    public static Shape[] getFilledShapeArray(int arrayLength) {
        Shape[] figures = new Shape[arrayLength];
        for (int i = 0; i < figures.length; i++) {
            figures[i] = getRandomGeometryObject();
        }
        return figures;
    }

    private static Shape getRandomGeometryObject() {
        Shape figure;
        int index = getRandomInt(0, FigureType.values().length);
        FigureType figureType = FigureType.values()[index];
        if (figureType == FigureType.RECTANGLE) {
            figure = getRandomRectangle();
        } else if (figureType == FigureType.CIRCLE) {
            figure = getRandomCircle();
        } else {
            figure = getRandomTriangle();
        }
        return figure;
    }

    public static Shape getRandomRectangle() {
        String color = getRandomColor();
        int index = getRandomInt(0, RECTANGLE_DIMENSIONS.length);
        double[] dimensions = RECTANGLE_DIMENSIONS[index];

        double width = dimensions[0];
        double height = dimensions[1];

        return new Rectangle(color, width, height);
    }

    public static Shape getRandomCircle() {
        String color = getRandomColor();
        double radius = getRandomRadius();
        return new Circle(color, radius);
    }

    public static Shape getRandomTriangle() {
        String color = getRandomColor();
        int index = getRandomInt(0, TRIANGLE_DIMENSIONS.length);
        double[] dimensions = TRIANGLE_DIMENSIONS[index];

        double base = dimensions[0];
        double height = dimensions[1];

        return new Triangle(color, base, height);
    }

    private static String getRandomColor() {
        int limit = COLORS.length;
        int index = ThreadLocalRandom.current().nextInt(0, limit);
        return COLORS[index];
    }

    private static double getRandomRadius() {
        int index = getRandomInt(0, CIRCLE_DIMENSIONS.length);
        return CIRCLE_DIMENSIONS[index];
    }

    private static int getRandomInt(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to);
    }
}
