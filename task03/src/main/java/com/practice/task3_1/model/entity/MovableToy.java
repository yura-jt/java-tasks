package com.practice.task3_1.model.entity;

import com.practice.task3_1.model.Color;
import com.practice.task3_1.model.MoveType;

import java.math.BigDecimal;

public abstract class MovableToy extends Toy {
    private int wheelsNumber;
    private boolean isElectric;
    private MoveType moveType;

    public MovableToy(String name, Color color, BigDecimal price, int wheelsNumber, boolean isElectric, MoveType moveType) {
        super(name, color, price);
        this.wheelsNumber = wheelsNumber;
        this.isElectric = isElectric;
        this.moveType = moveType;
    }

    public int getWheelsNumber() {
        return wheelsNumber;
    }

    public void setWheelsNumber(int wheelsNumber) {
        this.wheelsNumber = wheelsNumber;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    @Override
    public String toString() {
        return super.toString() + ", wheelsNumber = " + wheelsNumber +
                ", moving type = " + moveType.name().toLowerCase() +
                ", is Electric = " + isElectric;
    }
}
