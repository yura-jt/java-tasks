package com.practice.task3_1.model.util;

import com.practice.task3_1.model.Color;
import com.practice.task3_1.model.MoveType;
import com.practice.task3_1.model.SoundType;
import com.practice.task3_1.model.entity.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {
    public static List<Toy> getToys() {
        List<Toy> list = new ArrayList<>();
        Collections.addAll(list, getBuzzLightyear(), getTurboMan(), getChildKeyboard(),
                getLightningMcQueen());
        return list;
    }

    private static Toy getBuzzLightyear() {
        String name = "Buzzy";
        Color color = getRandomEnumValue(Color.values());
        BigDecimal price = BigDecimal.valueOf(getRandomDouble(5, 20));
        return new BuzzLightyear(name, color, price);
    }

    private static Toy getTurboMan() {
        String name = "Turbie";
        Color color = getRandomEnumValue(Color.values());
        BigDecimal price = BigDecimal.valueOf(getRandomDouble(10, 50));
        return new TurboMan(name, color, price);
    }

    private static Toy getChildKeyboard() {
        String name = "Keysie";
        Color color = getRandomEnumValue(Color.values());
        BigDecimal price = BigDecimal.valueOf(getRandomDouble(10, 40));
        SoundType soundType = getRandomEnumValue(SoundType.values());
        boolean hasBattery = getRandomBoolean();
        return new ChildKeyboard(name, color, price, soundType, hasBattery);
    }

    private static Toy getLightningMcQueen() {
        String name = "Lighty";
        Color color = getRandomEnumValue(Color.values());
        BigDecimal price = BigDecimal.valueOf(getRandomDouble(7, 30));
        int wheelsNumber = getRandomInt(0, 11);
        boolean isElectric = getRandomBoolean();
        MoveType moveType = getRandomEnumValue(MoveType.values());
        return new LightningMcQueen(name, color, price, wheelsNumber, isElectric, moveType);
    }

    private static <E extends Enum> E getRandomEnumValue(E... enums) {
        int index = getRandomInt(0, enums.length);
        return enums[index];
    }

    public static boolean getRandomBoolean() {
        int n = getRandomInt(0, 2);
        return n == 1;
    }

    public static int getRandomInt(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to);
    }

    private static double getRandomDouble(double from, double to) {
        return ThreadLocalRandom.current().nextDouble(from, to);
    }
}
