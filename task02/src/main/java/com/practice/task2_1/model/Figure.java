package com.practice.task2_1.model;

import com.practice.task2_1.model.entity.Shape;

import java.util.Arrays;
import java.util.Comparator;

public class Figure {
    private Shape[] figures = new Shape[0];

    public Shape[] getFigures() {
        return figures;
    }

    public void setFigures(Shape[] figures) {
        this.figures = figures;
    }

    public double getFiguresAreaSum(FigureType... figureTypes) {
        double sum = 0.0;
        if (figureTypes.length == FigureType.values().length) {
            return getTotalSum();
        }
        for (FigureType figureType : figureTypes) {
            sum = sum + getSingleTypeSum(figureType);
        }
        return sum;
    }

    public double getTotalSum() {
        double sum = 0.0;
        for (Shape figure : figures) {
            sum += figure.calcArea();
        }
        return sum;
    }

    private double getSingleTypeSum(FigureType figureType) {
        double sum = 0.0;
        for (Shape figure : figures) {
            String name = figure.getClass().getSimpleName().toUpperCase();
            FigureType currentType = FigureType.valueOf(name);
            if (currentType == figureType) {
                sum = sum + figure.calcArea();
            }
        }
        return sum;
    }

    public Shape[] sortFiguresByColor() {
        Shape[] sortedArray = Arrays.copyOf(figures, figures.length);
        return sortByCriteria(sortedArray, getColorComparator());
    }

    public Shape[] sortFiguresByArea() {
        Shape[] sortedArray = Arrays.copyOf(figures, figures.length);
        return sortByCriteria(sortedArray, getAreaComparator());
    }

    public Shape[] sortFiguresByType() {
        Shape[] sortedArray = Arrays.copyOf(figures, figures.length);
        return sortByCriteria(sortedArray, getTypeComparator());
    }

    private Shape[] sortByCriteria(Shape[] array, Comparator<Shape> comparator) {
        Arrays.sort(array, comparator);
        return array;
    }

    private Comparator<Shape> getColorComparator() {
        return new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                String color1 = o1.getColorShape().toString();
                String color2 = o2.getColorShape().toString();
                return color1.compareTo(color2);
            }
        };
    }

    private Comparator<Shape> getAreaComparator() {
        return new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                return (int) (o1.calcArea() - o2.calcArea());
            }
        };
    }

    private Comparator<Shape> getTypeComparator() {
        return new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                String name1 = o1.getClass().getSimpleName();
                String name2 = o2.getClass().getSimpleName();
                return name1.compareTo(name2);
            }
        };
    }
}