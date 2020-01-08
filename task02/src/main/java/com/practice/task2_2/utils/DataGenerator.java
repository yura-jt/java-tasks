package com.practice.task2_2.utils;

import com.practice.task2_2.model.Book;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

/**
 * {@link DataGenerator} is an utility class that provides mock data for testing app.
 */
public class DataGenerator {
    private final static String[] AUTHORS = {"Joshua Bloch", "Robert Martin", "Martin Fowler", "Bruce Eckel", "Alan Mycroft",
            "Cay S. Horstmann", "Kent Beck", "Erich Gamma", "Herbert Schildt", "James Gosling"};
    private final static String[] TITLES = {"Java cooking book", "Java in 24 hours", "Java for dummies", "To TDD or not TDD",
            "Collections in Action", "Generics for professionals", "Stream API: complete reference",
            "I/O for beginners", "Thinking in lambdas", "Reactive Java Core"};

    private final static String[] PUBLISHERS = {"Penguins", "Steak House", "William and McCortney", "Icebreaker", "Donnager",
            "Caprica", "Astra Inc.", "Tamila s.r.l.", "Youth union", "Lion Press"};

    /**
     * This method creates an array of random books
     *
     * @param n amount of books, that will be added to an array
     * @return a new array of random books
     */
    public static Book[] getBookArray(int n) {
        Book[] books = new Book[n];
        for (int i = 0; i < books.length; i++) {
            books[i] = getRandomBook();
        }
        return books;
    }

    /**
     * This method return one random book
     *
     * @return a random book
     */
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

    /**
     * This method return random author name
     *
     * @return a random author name
     */
    public static String getRandomAuthor() {
        int index = getRandomInt(0, AUTHORS.length);
        return AUTHORS[index];
    }

    /**
     * This method return random title name
     *
     * @return a random title name
     */
    public static String getRandomTitle() {
        int index = getRandomInt(0, TITLES.length);
        return TITLES[index];
    }

    /**
     * This method return random publisher name
     *
     * @return a random publisher name
     */
    public static String getRandomPublisher() {
        int index = getRandomInt(0, PUBLISHERS.length);
        return PUBLISHERS[index];
    }

    /**
     * This method return random year, book was published
     *
     * @return a random year
     */
    public static int getRandomYear() {
        return getRandomInt(1995, 2020);
    }

    /**
     * This method return random amount of pages, book contains
     *
     * @return a random pages amount
     */
    private static int getRandomPages() {
        return getRandomInt(200, 1400);
    }

    /**
     * This method generate and return random int number within provided bounds
     *
     * @param from lower bound for random number
     * @param to   upper bound for random number
     * @return a new random int number within provided bounds
     */
    public static int getRandomInt(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to);
    }

    /**
     * This method generate and return random double number within provided bounds
     *
     * @param from lower bound for random number
     * @param to   upper bound for random number
     * @return a new random double number within provided bounds
     */
    private static double getRandomDouble(double from, double to) {
        return ThreadLocalRandom.current().nextDouble(from, to);
    }
}
