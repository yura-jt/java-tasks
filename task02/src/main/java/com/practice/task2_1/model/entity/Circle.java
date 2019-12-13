package com.practice.task2_1.model.entity;

import com.practice.task2_1.model.Color;

public class Circle extends Shape {
    private double radius;

    public Circle(Color colorShape, double radius) {
        super(colorShape);
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", radius = " + radius;
    }

}
