package com.practice.task2_1.controller;

import com.practice.task2_1.model.Color;
import com.practice.task2_1.model.FigureType;
import com.practice.task2_1.view.Message;
import com.practice.task2_1.view.View;

import java.util.Arrays;

public class ShapeValidator {
    public static boolean validateShape(String[] args, View view) {
        boolean isValidType = isValidFigure(args[1]);
        if (!isValidType) {
            view.printMessage(Message.SHAPE_NOT_VALID);
            return false;
        }

        boolean isValidColor = isValidColorShape(args[2]);
        if (!isValidColor) {
            view.printMessage(Message.COLOR_NOT_VALID);
            return false;
        }

        FigureType figureType = FigureType.valueOf(args[1].toUpperCase());

        boolean result = false;

        if (figureType == FigureType.CIRCLE) {
            result = isValidCircle(args, view);
        } else if (figureType == FigureType.RECTANGLE) {
            result = isValidRectangle(args, view);
        } else if (figureType == FigureType.TRIANGLE) {
            result = isValidTriangle(args, view);
        }
        return result;
    }

    public static boolean isValidCircle(String[] args, View view) {
        if (args.length != 4) {
            view.printMessage(Message.ILLEGAL_ARGUMENT_LENGTH);
            return false;
        }
        String radius = args[3];
        boolean isValid = validateDimension(radius);
        if (!isValid) {
            view.printMessage(Message.RADIUS_NOT_VALID);
        }
        return isValid;
    }

    public static boolean isValidRectangle(String[] args, View view) {
        if (args.length != 5) {
            view.printMessage(Message.ILLEGAL_ARGUMENT_LENGTH);
            return false;
        }
        boolean isValidA = validateDimension(args[3]);
        boolean isValidB = validateDimension(args[4]);
        if (!isValidA || !isValidB) {
            view.printMessage(Message.RECTANGLE_NOT_VALID);
        }
        return isValidA && isValidB;
    }

    public static boolean isValidTriangle(String[] args, View view) {
        if (args.length != 6) {
            view.printMessage(Message.ILLEGAL_ARGUMENT_LENGTH);
            return false;
        }

        boolean isValidA = validateDimension(args[3]);
        boolean isValidB = validateDimension(args[4]);
        boolean isValidC = validateDimension(args[5]);

        boolean isSidesValid = isValidA && isValidB && isValidC;
        boolean isTriangleExist = isTriangle(args);

        if (!isSidesValid || !isTriangleExist) {
            view.printMessage(Message.TRIANGLE_NOT_VALID);
            return false;
        }
        return true;
    }

    private static boolean isTriangle(String[] args) {
        double a = Double.parseDouble(args[3]);
        double b = Double.parseDouble(args[4]);
        double c = Double.parseDouble(args[5]);

        return ((a + b > c) && (b + c > a) && (a + c > b));
    }

    private static boolean validateDimension(String dimension) {
        boolean result = false;
        boolean isNumber = isDouble(dimension);
        double number = Double.parseDouble(dimension);
        if (isNumber && number > 0.0) {
            result = true;
        }
        return result;
    }

    private static boolean isValidColorShape(String shapeColor) {
        boolean result = false;
        try {
            Color color = Color.valueOf(shapeColor.toUpperCase());
            result = true;
        } catch (Exception e) {
        }
        return result;
    }

    private static boolean isValidFigure(String type) {
        boolean result = false;
        try {
            FigureType figureType = FigureType.valueOf(type.toUpperCase());
            result = true;
        } catch (Exception e) {
        }
        return result;
    }

    private static boolean isDouble(String dimension) {
        boolean result = false;
        try {
            double number = Double.parseDouble(dimension);
            result = true;
        } catch (NumberFormatException e) {
        }
        return result;
    }

}
