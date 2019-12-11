package com.practice.task2_1.model;

public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(String colorShape, double base, double height) {
        super(colorShape);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calcArea() {
        return (base * height) / 2;
    }

    @Override
    public void draw() {
        System.out.printf("%s, area = %.2f\n", this, calcArea());
    }

    @Override
    public String toString() {
        return super.toString() +
                ", base = " + base + ", height = " + height;
    }
}
