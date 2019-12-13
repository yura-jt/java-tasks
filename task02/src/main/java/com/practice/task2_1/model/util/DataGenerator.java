package com.practice.task2_1.model.util;

import com.practice.task2_1.model.Color;
import com.practice.task2_1.model.FigureType;
import com.practice.task2_1.model.entity.Circle;
import com.practice.task2_1.model.entity.Rectangle;
import com.practice.task2_1.model.entity.Shape;
import com.practice.task2_1.model.entity.Triangle;

import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {
    private static final double[][] RECTANGLE_DIMENSIONS = {{5.0, 10.5}, {25.5, 10.2},
            {4.3, 7.5}, {15.7, 15.6}, {4, 5}, {7.6, 5.6}, {1.0, 2.3}, {14.4, 2.7}};
    private static final double[][] TRIANGLE_DIMENSIONS = {{14.7, 15.9, 3.6}, {10.0, 20.0, 25.4},
            {5.0, 7.0, 2.45}, {15.4, 8.9, 7.6}, {16.0, 32.5, 18}, {4.3, 7.8, 9.0}, {8.9, 10.2, 13.0},
            {10.4, 15.2, 11.5}};
    private static final double[] CIRCLE_DIMENSIONS = {1.5, 3.4, 5.6, 9.4, 7.0, 9.5, 10.0, 8.4};

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
        Color color = getRandomColor();
        int index = getRandomInt(0, RECTANGLE_DIMENSIONS.length);
        double[] dimensions = RECTANGLE_DIMENSIONS[index];

        double width = dimensions[0];
        double height = dimensions[1];

        return new Rectangle(color, width, height);
    }

    public static Shape getRandomCircle() {
        Color color = getRandomColor();
        double radius = getRandomRadius();
        return new Circle(color, radius);
    }

    public static Shape getRandomTriangle() {
        Color color = getRandomColor();
        int index = getRandomInt(0, TRIANGLE_DIMENSIONS.length);
        double[] dimensions = TRIANGLE_DIMENSIONS[index];

        double s1 = dimensions[0];
        double s2 = dimensions[1];
        double s3 = dimensions[2];

        return new Triangle(color, s1, s2, s3);
    }

    private static Color getRandomColor() {
        Color[] colors = Color.values();
        int limit = colors.length;
        int index = ThreadLocalRandom.current().nextInt(0, limit);
        return colors[index];
    }

    private static double getRandomRadius() {
        int index = getRandomInt(0, CIRCLE_DIMENSIONS.length);
        return CIRCLE_DIMENSIONS[index];
    }

    private static int getRandomInt(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to);
    }
}
