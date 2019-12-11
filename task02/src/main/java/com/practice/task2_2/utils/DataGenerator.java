package com.practice.task2_2.utils;

import com.practice.task2_2.model.Book;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {
    private final static String[] AUTHORS = {"Joshua Bloch", "Robert Martin", "Martin Fowler", "Bruce Eckel", "Alan Mycroft",
            "Cay S. Horstmann", "Kent Beck", "Erich Gamma", "Herbert Schildt", "James Gosling"};
    private final static String[] TITLES = {"Java cooking book", "Java in 24 hours", "Java for dummies", "To TDD or not TDD",
            "Collections in Action", "Generics for professionals", "Stream API: complete reference",
            "I/O for beginners", "Thinking in lambdas", "Reactive Java Core"};

    private final static String[] PUBLISHERS = {"Penguins", "Steak House", "William and McCortney", "Icebreaker", "Donnager",
            "Caprica", "Astra Inc.", "Tamila s.r.l.", "Youth union", "Lion Press"};

    public static Book[] getBookArray(int n) {
        Book[] books = new Book[n];
        for (int i = 0; i < books.length; i++) {
            books[i] = getRandomBook();
        }
        return books;
    }

    public static Book getRandomBook() {
        Book book = new Book();
        String author = getRandomAuthor();
        String title = getRandomTitle();
        String publisher = getRandomPublisher();
        int year = getRandomYear();
        int pages = getRandomPages();
        BigDecimal price = BigDecimal.valueOf(getRandomDouble(20.0, 200.0));

        book.setAuthor(author);
        book.setTitle(title);
        book.setPublisher(publisher);
        book.setYear(year);
        book.setPageAmount(pages);
        book.setPrice(price);

        return book;
    }

    public static String getRandomAuthor() {
        int index = getRandomInt(0, AUTHORS.length);
        return AUTHORS[index];
    }

    public static String getRandomTitle() {
        int index = getRandomInt(0, TITLES.length);
        return TITLES[index];
    }

    public static String getRandomPublisher() {
        int index = getRandomInt(0, PUBLISHERS.length);
        return PUBLISHERS[index];
    }

    public static int getRandomYear() {
        return getRandomInt(1995, 2020);
    }

    private static int getRandomPages() {
        return getRandomInt(200, 1400);
    }

    private static int getRandomInt(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to);
    }

    private static double getRandomDouble(double from, double to) {
        return ThreadLocalRandom.current().nextDouble(from, to);
    }
}
