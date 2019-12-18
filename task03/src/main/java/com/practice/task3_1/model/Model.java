package com.practice.task3_1.model;

import com.practice.task3_1.model.entity.Toy;

public class Model {
    private PlayRoom<Toy> playRoom = new PlayRoom<>();

    public PlayRoom<Toy> getPlayRoom() {
        return playRoom;
    }

    public void setPlayRoom(PlayRoom<Toy> playRoom) {
        this.playRoom = playRoom;
    }
}
