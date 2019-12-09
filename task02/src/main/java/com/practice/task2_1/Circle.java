package com.practice.task2_1;

public class Circle extends Shape {
    private double radius;

    public Circle(String colorShape, double radius) {
        super(colorShape);
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
        System.out.printf("%s, area = %.2f\n", this, calcArea());
    }

    @Override
    public String toString() {
        return super.toString() +
                ", radius = " + radius;
    }

}
