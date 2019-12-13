package com.practice.task2_1.controller;

import com.practice.task2_1.model.Figure;
import com.practice.task2_1.model.FigureType;
import com.practice.task2_1.model.entity.Shape;
import com.practice.task2_1.view.Message;
import com.practice.task2_1.view.View;

public class Controller {
    private Figure figure;
    private View view;

    public Controller(Figure figure, View view) {
        this.figure = figure;
        this.view = view;
    }

    public void run() {
        Menu menu = new Menu(this, view);
        menu.initiateStartMenu();
    }

    public void addFigureToArray(Shape shape) {
        Shape[] figures = figure.getFigures();
        Shape[] newArray = new Shape[figures.length + 1];
        System.arraycopy(figures, 0, newArray, 0, figures.length);
        newArray[newArray.length - 1] = shape;
        setFigureArray(newArray);
    }

    public void setFigureArray(Shape[] array) {
        figure.setFigures(array);
        view.printMessage(Message.PRINT_ARRAY_UPDATED);
        printFigures();
    }

    public void printFigures() {
        Shape[] figures = figure.getFigures();
        String result = ShapeConverter.convertArrayToString(figures);
        view.printMessage(result);
    }

    public void getTotalArea() {
        double sum = figure.getTotalSum();
        String result = ShapeConverter.convertAreaSumMessage(sum, "figure");
        view.printMessage(result);
    }

    public void getAreaSumByFigureType(FigureType... figureTypes) {
        double sum = figure.getFiguresAreaSum(figureTypes);
        String result = ShapeConverter.convertAreaSumMessage(sum, figureTypes);
        view.printMessage(result);
    }

    public void sortFiguresByArea() {
        Shape[] array = figure.sortFiguresByArea();
        String result = ShapeConverter.convertArrayToString(array);

        view.printMessage(Message.PRINT_SORTED_BY_AREA_MESSAGE);
        view.printMessage(result);
    }

    public void sortFiguresByColor() {
        Shape[] array = figure.sortFiguresByColor();
        String result = ShapeConverter.convertArrayToString(array);

        view.printMessage(Message.PRINT_SORTED_BY_COLOR_MESSAGE);
        view.printMessage(result);
    }

    public void sortFiguresByType() {
        Shape[] array = figure.sortFiguresByType();
        String result = ShapeConverter.convertArrayToString(array);

        view.printMessage(Message.PRINT_SORTED_BY_TYPE_MESSAGE);
        view.printMessage(result);
    }
}