package com.practice.task3_3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        for (Language language : Language.values()) {
            System.out.println(language);
        }

        sortExample();
    }

    public static void sortExample() {
        Language language1 = Language.valueOf("DOTHRAKI");
        Language language2 = Language.valueOf("ESPERANTO");
        Language language3 = Language.valueOf("KLINGON");

        Language[] languages = {language1, language2, language3};
        System.out.println("\nEnum values array before sorting:\n" +
                Arrays.toString(languages));

        Arrays.sort(languages);

        System.out.println("\nEnum values array after sorting:\n" +
                Arrays.toString(languages));
    }
}