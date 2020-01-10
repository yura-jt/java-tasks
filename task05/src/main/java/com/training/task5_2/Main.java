package com.training.task5_2;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.print("\nPlease, enter number, that defines bottom bound of random number:\n--> ");
        int from = getIntFromConsole();
        System.out.print("\nPlease, enter number, that defines upper bound of random number:\n--> ");
        int to = getIntFromConsole();
        System.out.print("\nPlease, enter number, that defines quantity of element in collection:\n--> ");
        int quantity = getIntFromConsole();

        List<Integer> list = CollectionGenerator.getIntegerList(from, to, quantity);
        Set<Integer> set = CollectionGenerator.getIntegerSet(from, to, quantity);

        printCollection(list);
        printCollection(set);
    }

    private static int getIntFromConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void printCollection(Collection<Integer> collection) {
        System.out.println(collection);
    }
}