package com.practice.task2_1.model.entity;

import com.practice.task2_1.model.Color;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(Color colorShape, double width, double height) {
        super(colorShape);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calcArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", width = " + width + ", height = " + height;
    }
}
