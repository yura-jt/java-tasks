package com.practice.task3_1.model.entity;

import com.practice.task3_1.model.Color;

import java.math.BigDecimal;

public class BuzzLightyear extends Toy {
    private String[] quotes = {"To infinity... and beyond!",
            "You are a sad, strange little man and you have my pity."};

    public String[] getQuotes() {
        return quotes;
    }

    public BuzzLightyear(String name, Color color, BigDecimal price) {
        super(name, color, price);
    }

    @Override
    public String toString() {
        return "Buzz Lightyear " + super.toString();
    }
}
