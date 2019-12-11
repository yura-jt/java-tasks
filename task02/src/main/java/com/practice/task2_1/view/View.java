package com.practice.task2_1.view;

import com.practice.task2_1.model.Shape;

public class View {
    public final static String PRINT_SORTED_BY_COLOR_MESSAGE = "\n--------- Printing arrays of geometry figures sorted by color: ----------";
    public final static String PRINT_SORTED_BY_AREA_MESSAGE = "\n--------- Printing arrays of geometry figures sorted by area: ----------";

    public final static String DELIMITER = "-------------------------------------------------------------------------";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printSumAreaByType(double sum, String type) {
        System.out.printf("Total area of all %ss = %.2f\n", type, sum);
    }

    public void printTotalArea(double sum) {
        printSumAreaByType(sum, "figure");
    }

    public void printFiguresArray(Shape[] figures) {
        System.out.println(DELIMITER);
        for (Shape figure : figures) {
            figure.draw();
        }
        System.out.println(DELIMITER);
    }
}
