package com.practice.task2_1.model.entity;

import com.practice.task2_1.model.Color;

public class Triangle extends Shape {
    private double s1;
    private double s2;
    private double s3;

    public Triangle(Color colorShape, double s1, double s2, double s3) {
        super(colorShape);
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    @Override
    public double calcArea() {
        double p = (s1 + s2 + s3) / 2;
        return Math.sqrt(p * (p - s1) * (p - s2) * (p - s3));
    }

    @Override
    public String toString() {
        return super.toString() +
                ", s1 = " + s2 + ", s2 = " + s3 + ", s3 = ";
    }
}
