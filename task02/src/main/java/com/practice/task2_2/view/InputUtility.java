package com.practice.task2_2.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputUtility {
    private static final List<String> COMMANDS = Arrays.asList("FILL", "GET", "SORT", "EXIT");
    private static final List<String> KEYS = Arrays.asList("TITLE", "AUTHOR", "PUBLISHER", "YEAR", "PAGES", "PRICE");

    private static Scanner scanner = new Scanner(System.in);

    public static String getStringFromConsole(View view) {
        boolean isValid = false;
        String command = "";
        while (!isValid) {
            command = scanner.nextLine().trim();
            isValid = validateInputString(command);
            if (!isValid) {
                view.printMessage(View.WRONG_INPUT_MESSAGE);
            }
        }
        return command;
    }

    private static boolean validateInputString(String command) {
        String[] line = command.split(" ");
        if (line.length > 0 && COMMANDS.contains(line[0])) {
            if (line[0].equals("EXIT") || line[0].equals("FILL")) {
                return true;
            }

            if (line[0].equals("SORT") && line.length == 2) {
                return true;
            }

            boolean hasValidKeys = checkIfCommandWithArgs(command);

            if (hasValidKeys) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkIfCommandWithArgs(String command) {
        String[] line = command.split(" ");
        return line.length > 2 && KEYS.contains(line[1]);
    }
}
