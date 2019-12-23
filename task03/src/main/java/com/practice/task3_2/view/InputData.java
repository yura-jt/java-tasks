package com.practice.task3_2.view;

import java.util.Scanner;

public class InputData {
    private static Scanner sc = new Scanner(System.in);

    public static String input() {
        System.out.print("-> ");
        return sc.nextLine();
    }
}