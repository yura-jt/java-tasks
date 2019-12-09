package com.practice.task2_1;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String colorShape, double width, double height) {
        super(colorShape);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calcArea() {
        return width * height;
    }

    @Override
    public void draw() {
        System.out.printf("%s, area = %.2f\n", this, calcArea());
    }

    @Override
    public String toString() {
        return super.toString() +
                ", width = " + width + ", height = " + height;
    }
}
