package com.practice.task2_2.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * {@link InputUtility} is class that responsible for getting input from user through the console.
 */
public class InputUtility {
    private static final List<String> COMMANDS = Arrays.asList("FILL", "GET", "SORT", "EXIT", "DEMO");
    private static final List<String> KEYS = Arrays.asList("AUTHOR", "PUBLISHER", "YEAR");

    private static Scanner scanner = new Scanner(System.in);

    /**
     * This method gets user input from console as String
     *
     * @param view view component, for providing interface interaction with user
     * @return a String contains input text, provided by user
     */
    public static String getStringFromConsole(View view) {
        boolean isValid = false;
        String command = "";
        while (!isValid) {
            System.out.println(Message.INPUT_MESSAGE);
            System.out.print("---> ");
            command = scanner.nextLine().trim().toUpperCase();
            isValid = validateInputString(command);
            if (!isValid) {
                view.printMessage(Message.WRONG_INPUT_MESSAGE);
            }
        }
        return command;
    }

    private static boolean validateInputString(String command) {
        String[] line = command.split(" ");
        if (line.length > 0 && COMMANDS.contains(line[0])) {
            if (line[0].equals("EXIT") || line[0].equals("FILL") || line[0].equals("DEMO")) {
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
        return line.length >= 2 && KEYS.contains(line[1]);
    }
}
