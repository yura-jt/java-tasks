package com.training.task5_1.view;

import java.util.Scanner;

public class InputData {
    private static Scanner sc = new Scanner(System.in);

    public static String getString() {
        System.out.print("-> ");
        return sc.nextLine();
    }
}