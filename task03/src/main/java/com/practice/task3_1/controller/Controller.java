package com.practice.task3_1.controller;

import com.practice.task3_1.model.Color;
import com.practice.task3_1.model.Model;
import com.practice.task3_1.model.Parameter;
import com.practice.task3_1.model.PlayRoom;
import com.practice.task3_1.model.entity.Toy;
import com.practice.task3_1.model.util.DataGenerator;
import com.practice.task3_1.view.Message;
import com.practice.task3_1.view.View;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void playToys() {
        initiateRandomToys();
        sortDemo();
        calcTotalPrice();
        getByParamDemo();
    }

    private void initiateRandomToys() {
        PlayRoom<Toy> playRoom = model.getPlayRoom();
        List<Toy> toys = DataGenerator.getToys();
        playRoom.setToys(toys);

        view.printMessage(Message.RANDOM_INITIALIZE_MESSAGE);
        printToys(toys);
    }

    private void sortDemo() {
        PlayRoom<Toy> playRoom = model.getPlayRoom();
        sortToys(playRoom, Parameter.PRICE);
        sortToys(playRoom, Parameter.COLOR);
        sortToys(playRoom, Parameter.NAME);
    }

    private void sortToys(PlayRoom<Toy> playRoom, Parameter parameter) {
        view.printMessage(Message.SORT_BY + parameter.name());
        List<Toy> sortedToys = playRoom.sortByParam(parameter);
        String message = MessageConverter.listToString(sortedToys);
        view.printMessage(message);
    }

    private void calcTotalPrice() {
        PlayRoom<Toy> playRoom = model.getPlayRoom();
        double sum = playRoom.calcTotalPrice();
        String message = MessageConverter.convertSingleSumMessage(sum);
        view.printMessage(message);
    }

    private void getByParamDemo() {
        getToysByColor(Color.BROWN, Color.VIOLET);
        getToysByPrice(new BigDecimal("10.0"), new BigDecimal("20.0"));
        getToysByName("K", "O");
    }

    private void getToysByColor(Color from, Color to) {
        PlayRoom<Toy> playRoom = model.getPlayRoom();
        List<Toy> result = playRoom.getToysByParam(from, to);
        view.printMessage(Message.GET_TOYS_BY_COLOR + " from " + from + " to " + to);
        printToys(result);
    }

    private void getToysByPrice(BigDecimal from, BigDecimal to) {
        PlayRoom<Toy> playRoom = model.getPlayRoom();
        List<Toy> result = playRoom.getToysByParam(from, to);
        view.printMessage(Message.GET_TOYS_BY_PRICE + " from "
                + from.setScale(1, RoundingMode.HALF_UP) +
                " to " + to.setScale(1, RoundingMode.HALF_UP));
        printToys(result);
    }

    private void getToysByName(String from, String to) {
        PlayRoom<Toy> playRoom = model.getPlayRoom();
        List<Toy> result = playRoom.getToysByParam(from, to);
        view.printMessage(Message.GET_TOYS_BY_NAME + " from " + from + " to " + to);
        printToys(result);
    }

    private void printToys(List<Toy> toys) {
        String result = MessageConverter.listToString(toys);
        if (toys.size() > 0) {
            view.printMessage(result);
        } else {
            view.printMessage(Message.DATA_NOT_FOUND_MESSAGE);
        }
    }
}