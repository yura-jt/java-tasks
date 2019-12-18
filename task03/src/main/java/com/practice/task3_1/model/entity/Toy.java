package com.practice.task3_1.model.entity;

import com.practice.task3_1.model.Color;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Toy {
    private String name;
    private Color color;
    private BigDecimal price;

    public Toy(String name, Color color, BigDecimal price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "toy, " +
                "name = " + name +
                ", color = " + color.name().toLowerCase() +
                ", price = " + price.setScale(1, RoundingMode.HALF_UP) +
                "$";
    }
}
