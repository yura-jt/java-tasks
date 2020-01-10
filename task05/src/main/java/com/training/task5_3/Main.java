package com.training.task5_3;

public class Main {
    private static final String UI_MESSAGE = "\nTranslation of \"%s\"\ninto Russian language:\n%s";
    private static final String EXAMPLE_1 = "Spring ecosystem unleashes some new amazing " +
            "capabilities that rekindle the fun in developing applications.";

    private static final String EXAMPLE_2 = "African wildcats were probably first domesticated in the Near East.";
    private static final String EXAMPLE_3 = "African wildcats were pretty fast comparing to other groups";

    public static void main(String[] args) {
        DictionaryEnRu dict = new DictionaryEnRu();
        initDictionary(dict);
        translationDemo(dict);
    }

    private static void translationDemo(DictionaryEnRu dictionary) {
        String translation1 = dictionary.translateEnRu(EXAMPLE_1);
        String translation2 = dictionary.translateEnRu(EXAMPLE_2);
        String translation3 = dictionary.translateEnRu(EXAMPLE_3);

        System.out.println(String.format(UI_MESSAGE, EXAMPLE_1, translation1));
        System.out.println(String.format(UI_MESSAGE, EXAMPLE_2, translation2));
        System.out.println(String.format(UI_MESSAGE, EXAMPLE_3, translation3));
    }

    private static void initDictionary(DictionaryEnRu dict) {
        dict.addWordPair("spring", "весна");
        dict.addWordPair("ecosystem", "экосистема");
        dict.addWordPair("unleashes", "высвобождает");
        dict.addWordPair("some", "некоторый");
        dict.addWordPair("new", "новый");
        dict.addWordPair("amazing", "удивительный");
        dict.addWordPair("capabilities", "возможности");
        dict.addWordPair("that", "который");
        dict.addWordPair("rekindle", "возрождать");
        dict.addWordPair("fun", "веселье");
        dict.addWordPair("in", "в");
        dict.addWordPair("developing", "разработка");
        dict.addWordPair("applications", "приложения");

        dict.addWordPair("african", "африканский");
        dict.addWordPair("wildcats", "степные коты");
        dict.addWordPair("were", "были");
        dict.addWordPair("probably", "возможно");
        dict.addWordPair("first", "первый");
        dict.addWordPair("domesticated", "одомашненный");
        dict.addWordPair("near", "ближний");
        dict.addWordPair("east", "восток");

        dict.addWordPair("fast", "быстрый");
        dict.addWordPair("other", "другой");
    }
}