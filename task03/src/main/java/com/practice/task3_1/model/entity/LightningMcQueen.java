package com.practice.task3_1.model.entity;

import com.practice.task3_1.model.Color;
import com.practice.task3_1.model.MoveType;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class LightningMcQueen extends MovableToy {
    List<Toy> friends;

    public List<Toy> getFriends() {
        return friends;
    }

    public void setFriends(List<Toy> friends) {
        this.friends = friends;
    }

    public LightningMcQueen(String name, Color color, BigDecimal price, int wheelsNumber, boolean isElectric, MoveType moveType) {
        super(name, color, price, wheelsNumber, isElectric, moveType);
    }

    @Override
    public String toString() {
        return "Lightning McQueen " + super.toString() +
                (friends != null ? friends.size() > 0 ? friends : "" : "");
    }
}
