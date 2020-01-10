package com.training.task5_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class CollectionGenerator {
    public static List<Integer> getIntegerList(int from, int to, int quantity) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            int number = getRandomNumber(from, to);
            list.add(number);
        }
        return list;
    }

    public static Set<Integer> getIntegerSet(int from, int to, int quantity) {
        Set<Integer> set = new HashSet<>();
        if ((to - from) < quantity) {
            throw new IllegalArgumentException("Set cannot be constructed because required " +
                    "set length exceeds possible combination of element values");
        }

        while (set.size() < quantity) {
            int number = getRandomNumber(from, to);
            set.add(number);
        }
        return set;
    }

    private static int getRandomNumber(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to + 1);
    }
}