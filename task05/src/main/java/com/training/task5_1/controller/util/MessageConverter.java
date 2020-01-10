package com.training.task5_1.controller.util;

import com.training.task5_1.model.Record;

import java.util.List;

public class MessageConverter {
    public static String convertList(List<Record> journal) {
        StringBuilder sb = new StringBuilder();
        for (Record record : journal) {
            sb.append(record).append("\n");
        }
        return sb.toString();
    }
}
