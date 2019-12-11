package com.practice.task2_1.controller;

import com.practice.task2_1.model.Figure;
import com.practice.task2_1.model.FigureType;
import com.practice.task2_1.model.Shape;
import com.practice.task2_1.utils.DataGenerator;
import com.practice.task2_1.view.View;

public class Controller {
    private Figure figure;
    private View view;

    public Controller(Figure figure, View view) {
        this.figure = figure;
        this.view = view;
    }

    public void run() {
        Shape[] figures = DataGenerator.getFilledShapeArray(10);
        figure.setFigures(figures);

        printFigures();
        getTotalArea();
        getAreaSumByFigureType(FigureType.RECTANGLE);
        getAreaSumByFigureType(FigureType.TRIANGLE);
        getAreaSumByFigureType(FigureType.CIRCLE);
        sortFiguresByArea();
        sortFiguresByColor();
    }

    private void printFigures() {
        Shape[] figures = figure.getFigures();
        view.printFiguresArray(figures);
    }

    private void getTotalArea() {
        FigureType[] allTypes = FigureType.values();
        double sum = figure.getFigureAreaSum(allTypes);
        view.printTotalArea(sum);
    }

    private void getAreaSumByFigureType(FigureType figureType) {
        double sum = figure.getFigureAreaSum(figureType);
        view.printSumAreaByType(sum, figureType.name().toLowerCase());
    }

    private void sortFiguresByArea() {
        figure.sortFiguresByArea();
        Shape[] figures = figure.getFigures();
        view.printMessage(View.PRINT_SORTED_BY_AREA_MESSAGE);
        view.printFiguresArray(figures);
    }

    private void sortFiguresByColor() {
        figure.sortFiguresByColor();
        Shape[] figures = figure.getFigures();
        view.printMessage(View.PRINT_SORTED_BY_COLOR_MESSAGE);
        view.printFiguresArray(figures);
    }
}
