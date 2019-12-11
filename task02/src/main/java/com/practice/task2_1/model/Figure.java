package com.practice.task2_1.model;

import java.util.Arrays;
import java.util.Comparator;

public class Figure {
    private Shape[] figures;

    public Shape[] getFigures() {
        return figures;
    }

    public void setFigures(Shape[] figures) {
        this.figures = figures;
    }

    public double getFigureAreaSum(FigureType... figureTypes) {
        double sum = 0.0;
        for (FigureType figureType : figureTypes) {
            for (Shape figure : figures) {
                String name = figure.getClass().getSimpleName().toUpperCase();
                FigureType currentType = FigureType.valueOf(name);
                if (currentType == figureType) {
                    sum = sum + figure.calcArea();
                }
            }
        }
        return sum;
    }

    public void sortFiguresByColor() {
        sortByCriteria(getColorComparator());
    }

    public void sortFiguresByArea() {
        sortByCriteria(getAreaComparator());
    }

    private void sortByCriteria(Comparator<Shape> comparator) {
        Arrays.sort(figures, comparator);
    }

    private Comparator<Shape> getColorComparator() {
        return new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                return o1.getColorShape().compareTo(o2.getColorShape());
            }
        };
    }

    private Comparator<Shape> getAreaComparator() {
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
}
