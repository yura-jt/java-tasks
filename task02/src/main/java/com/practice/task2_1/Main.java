package com.practice.task2_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private final static String[] colors = {"RED", "ORANGE", "YELLOW", "GREEN",
            "BLUE", "VIOLET", "PINK", "BROWN", "BLACK", "WHITE"};

    public static void main(String[] args) {
        System.out.println("--- Getting random array of geometry figures: ---");
        Shape[] figures = getRandomFiguresArray();
        printFiguresArray(figures);

        double totalAreaSum = getFigureAreaSum(figures, "Rectangle", "Circle", "Triangle");
        double totalRectangleAreaSum = getFigureAreaSum(figures, "Rectangle");
        double totalCircleAreaSum = getFigureAreaSum(figures, "Circle");
        double totalTriangleAreaSum = getFigureAreaSum(figures, "Triangle");

        System.out.printf("\nTotal sum of figures area = %.2f\n", totalAreaSum);
        System.out.printf("Total sum of rectangles area = %.2f\n", totalRectangleAreaSum);
        System.out.printf("Total sum of circle area = %.2f\n", totalCircleAreaSum);
        System.out.printf("Total sum of triangles area = %.2f\n", totalTriangleAreaSum);

        System.out.println("\n--- Printing arrays of geometry figures sorted by color: ---");
        Comparator<Shape> colorComparator = getColorComparator();
        Arrays.sort(figures, colorComparator);
        printFiguresArray(figures);

        System.out.println("\n--- Printing arrays of geometry figures sorted by area: ---");
        Comparator<Shape> areaComparator = getAreaComparator();
        Arrays.sort(figures, areaComparator);
        printFiguresArray(figures);

    }

    private static double getFigureAreaSum(Shape[] figures, String... figureTypes) {
        double sum = 0.0;
        for (String figureType : figureTypes) {
            for (Shape figure : figures) {
                String name = figure.getClass().getSimpleName();
                if (name.equals(figureType)) {
                    sum = sum + figure.calcArea();
                }
            }
        }
        return sum;
    }

    private static Comparator<Shape> getColorComparator() {
        return new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                return o1.getColorShape().compareTo(o2.getColorShape());
            }
        };
    }

    private static Comparator<Shape> getAreaComparator() {
        return new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if (o1.calcArea() < o2.calcArea()) {
                    return -1;
                } else if (o1.calcArea() > o2.calcArea()) {
                    return 1;
                }
                return 0;
            }
        };
    }

    private static Shape[] getRandomFiguresArray() {
        Shape[] figures = new Shape[10];
        for (int i = 0; i < figures.length; i++) {
            Shape shape = getRandomGeometryObject();
            figures[i] = shape;
        }
        return figures;
    }

    private static void printFiguresArray(Shape[] figures) {
        for (Shape figure : figures) {
            figure.draw();
        }
    }

    private static Shape getRandomGeometryObject() {
        Shape figure;
        int typeOfFigure = ThreadLocalRandom.current().nextInt(0, 3);

        if (typeOfFigure == 0) {
            figure = getRandomRectangle();
        } else if (typeOfFigure == 1) {
            figure = getRandomCircle();
        } else {
            figure = getRandomTriangle();
        }
        return figure;
    }

    private static Shape getRandomRectangle() {
        String color = getRandomColor();
        double width = getRandomLength();
        double height = getRandomLength();
        return new Rectangle(color, width, height);
    }

    private static Shape getRandomCircle() {
        String color = getRandomColor();
        double radius = getRandomLength();
        return new Circle(color, radius);
    }

    private static Shape getRandomTriangle() {
        String color = getRandomColor();
        double base = getRandomLength();
        double height = getRandomLength();
        return new Triangle(color, base, height);
    }

    private static String getRandomColor() {
        int limit = colors.length;
        int index = ThreadLocalRandom.current().nextInt(0, limit);
        return colors[index];
    }

    private static double getRandomLength() {
        double length = ThreadLocalRandom.current().nextInt(1, 20);
        return length;
    }
}