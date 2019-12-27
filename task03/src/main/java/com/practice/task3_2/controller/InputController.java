package com.practice.task3_2.controller;

import com.practice.task3_2.view.InputData;
import com.practice.task3_2.view.Message;
import com.practice.task3_2.view.View;

public class InputController {
    private View view;

    public InputController(View view) {
        this.view = view;
    }

    public double getDoubleFromConsole() {
        boolean isOperationSuccessful = false;
        double number = 0;
        while (!isOperationSuccessful) {
            String str = InputData.input();
            if (str != null && str.equalsIgnoreCase("end")) {
                return -1.0;
            }

            if (Validator.isValidDouble(str)) {
                number = Double.parseDouble(str);
                isOperationSuccessful = true;
            } else {
                view.printMessage(Message.DOUBLE_IS_NOT_VALID);
            }
        }
        return number;
    }

    public int getIntFromConsole() {
        boolean isOperationSuccessful = false;
        int number = 0;
        while (!isOperationSuccessful) {
            String str = InputData.input();
            if (str != null && str.equalsIgnoreCase("end")) {
                break;
            }

            if (Validator.isValidIntForMenu(str)) {
                number = Integer.parseInt(str);
                isOperationSuccessful = true;
            } else {
                view.printMessage(Message.INT_IS_NOT_VALID);
            }
        }
        return number;
    }

    public String getStringFromConsole() {
        boolean isOperationSuccessful = false;
        String str = "";
        while (!isOperationSuccessful) {
            str = InputData.input();
            if (str != null && str.equalsIgnoreCase("end")) {
                return "end";
            }

            if (Validator.isValidString(str)) {
                isOperationSuccessful = true;
            } else {
                view.printMessage(Message.STRING_IS_NOT_VALID);
            }
        }
        return str;
    }
}
