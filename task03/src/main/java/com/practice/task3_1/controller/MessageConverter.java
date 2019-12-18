package com.practice.task3_1.controller;

import com.practice.task3_1.model.entity.Toy;

import java.util.List;

public class MessageConverter {
    public static String listToString(List<Toy> toys) {
        String result = "";
        for (Toy toy : toys) {
            result = result + toy + System.lineSeparator();
        }
        return result;
    }

    public static String convertSingleSumMessage(double sum) {
        return String.format("Total price sum of all toys = %.1f0\n", sum);
    }
}
