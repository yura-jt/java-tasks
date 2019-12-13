package com.practice.task2_1.controller;

import com.practice.task2_1.model.FigureType;
import com.practice.task2_1.model.entity.Shape;

public class ShapeConverter {
    public static String convertArrayToString(Shape[] shapes) {
        String result = "";
        for (Shape shape : shapes) {
            result += shape.draw();
        }
        return result;
    }

    public static String convertAreaSumMessage(double sum, FigureType... figureTypes) {
        if (figureTypes.length == 1) {
            String type = figureTypes[0].toString().toLowerCase();
            return convertSingleSumMessage(sum, type);
        }
        String types = buildStringForTypes(figureTypes);
        return convertSingleSumMessage(sum, types);
    }

    public static String convertAreaSumMessage(double sum, String type) {
        return convertSingleSumMessage(sum, type);
    }

    private static String convertSingleSumMessage(double sum, String type) {
        return String.format("Total area of all %ss = %.2f", type, sum);
    }

    private static String buildStringForTypes(FigureType[] figureTypes) {
        String result = "";
        for (FigureType figureType : figureTypes) {
            String type = figureType.toString().toLowerCase();
            result = result + type + " and ";
        }
        return result.substring(0, result.lastIndexOf(" and "));
    }
}
