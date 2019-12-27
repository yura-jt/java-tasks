package com.practice.view;

import java.util.Scanner;
/**
 * (@link InputData) is class that responsible for retrieving data from user.
 */
public class InputData {
    private static Scanner sc = new Scanner(System.in);

    public static String input() {
        System.out.print("-> ");
        return sc.nextLine();
    }
}