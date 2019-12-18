package com.practice.task3_1.model.entity;

import com.practice.task3_1.model.Color;
import com.practice.task3_1.model.SoundType;

import java.math.BigDecimal;

public abstract class MusicToy extends Toy {
    private SoundType soundType;
    private boolean hasBattery;

    public MusicToy(String name, Color color, BigDecimal price, SoundType soundType, boolean hasBattery) {
        super(name, color, price);
        this.soundType = soundType;
        this.hasBattery = hasBattery;
    }

    public SoundType getSoundType() {
        return soundType;
    }

    public void setSoundType(SoundType soundType) {
        this.soundType = soundType;
    }

    public boolean hasBattery() {
        return hasBattery;
    }

    public void setBattery(boolean hasBattery) {
        this.hasBattery = hasBattery;
    }

    @Override
    public String toString() {
        return super.toString() + ", soundType = " + soundType.name().toLowerCase() +
                ", hasBattery = " + hasBattery;
    }
}
