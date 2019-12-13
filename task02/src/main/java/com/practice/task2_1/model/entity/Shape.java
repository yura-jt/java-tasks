package com.practice.task2_1.model.entity;

import com.practice.task2_1.model.Color;
import com.practice.task2_1.model.Drawable;

public abstract class Shape implements Drawable {
    private Color colorShape;

    public Color getColorShape() {
        return colorShape;
    }

    public void setColorShape(Color colorShape) {
        this.colorShape = colorShape;
    }

    public Shape(Color colorShape) {
        this.colorShape = colorShape;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                ": color = " + colorShape.toString();
    }

    public String draw() {
        return String.format("%s, area = %.2f\n", this, calcArea());
    }

    public abstract double calcArea();
}