package com.practice.task3_2.controller;

public class Validator {
    public static boolean isValidString(String str) {
        return str != null && str.length() >= 1;
    }

    public static boolean isValidDouble(String str) {
        double d = 0.0;
        boolean isValidDouble = false;
        try {
            d = Double.parseDouble(str);
            isValidDouble = true;
        } catch (NumberFormatException e) {
        }
        if (!isValidDouble) {
            return false;
        }
        return d > 0.0;
    }

    public static boolean isValidIntForMenu(String str) {
        int key = 0;
        boolean isValidInt = false;
        try {
            key = Integer.parseInt(str);
            isValidInt = true;
        } catch (NumberFormatException e) {
        }
        if (!isValidInt) {
            return false;
        }
        return key > 0 && key <= 5;
    }
}
