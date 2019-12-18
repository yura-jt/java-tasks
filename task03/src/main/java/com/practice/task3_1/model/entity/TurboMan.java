package com.practice.task3_1.model.entity;

import com.practice.task3_1.model.Color;

import java.math.BigDecimal;

public class TurboMan extends Toy {
    public TurboMan(String name, Color color, BigDecimal price) {
        super(name, color, price);
    }

    @Override
    public String toString() {
        return "Turbo-Man " + super.toString();
    }
}
