package com.practice.task3_1.model.entity;

import com.practice.task3_1.model.Color;
import com.practice.task3_1.model.SoundType;

import java.math.BigDecimal;

public class ChildKeyboard extends MusicToy {
    public ChildKeyboard(String name, Color color, BigDecimal price, SoundType soundType, boolean hasBattery) {
        super(name, color, price, soundType, hasBattery);
    }

    @Override
    public String toString() {
        return "Child Keyboard " + super.toString();
    }
}
