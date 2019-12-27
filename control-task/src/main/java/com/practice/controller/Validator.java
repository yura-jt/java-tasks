package com.practice.controller;

/**
 * (@link Validator) is util class that provides support for input controllers in terms of validating
 * data, received from user.
 */
public class Validator {
    static boolean isValidString(String str) {
        return str != null && str.length() >= 1;
    }

    static boolean isValidIntForMenu(String str, int upLimit) {
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
        return key > 0 && key <= upLimit;
    }
}
