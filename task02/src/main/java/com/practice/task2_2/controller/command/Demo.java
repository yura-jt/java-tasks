package com.practice.task2_2.controller.command;

import com.practice.task2_2.model.Book;
import com.practice.task2_2.model.Model;
import com.practice.task2_2.utils.DataGenerator;
import com.practice.task2_2.view.Message;
import com.practice.task2_2.view.View;

/**
 * {@link Demo} is a command, that provides full-scale app demonstration.
 */
public class Demo extends GeneralCommand {
    /**
     * Creates a Demo command instance, initialize it with view and
     * model component.
     *
     * @param model model component
     * @param view  view component
     */
    public Demo(View view, Model model) {
        super(view, model);
    }

    /**
     * This method check if provided string contains valid Demo command
     *
     * @param command command to validate
     * @return {@code true} if command is valid, {@code false} otherwise
     */
    @Override
    public boolean isValid(String command) {
        return command.startsWith("DEMO");
    }

    /**
     * This method executes Demo command and shows application capabilities
     *
     * @param command command to execute
     */
    @Override
    public void execute(String command) {
        createDataSource();
        randomAuthorSearch();
        randomAuthorPublisher();
        randomAuthorYears();
        sortByPublisher();
    }

    private void randomAuthorSearch() {
        String[] randomAuthors = getRandomAuthors();
        executeQuery(randomAuthors, "author");
    }

    private void randomAuthorPublisher() {
        String[] randomPublishers = getRandomPublisher();
        executeQuery(randomPublishers, "publisher");
    }

    private void randomAuthorYears() {
        Integer[] randomYears = getRandomYear();
        view.printMessage("   *  *  * Performing searching in books array for next query:");
        for (Integer query : randomYears) {
            view.printMessage(query + ":");
            Book[] result = model.getPublishedAfterYear(query);
            if (result.length > 0) {
                view.printBooks(result);
            } else {
                view.printMessage(Message.DATA_NOT_FOUND_MESSAGE);
            }
        }
    }

    private void sortByPublisher() {
        Book[] books = model.sortBooksByPublisher();
        view.printMessage(Message.SORT_BY_PUBLISHER);
        view.printBooks(books);
    }

    private void createDataSource() {
        Book[] books = DataGenerator.getBookArray(10);
        model.setBooks(books);
        model.setBookService();
        view.printMessage("Array with 10 books was created:");
        view.printBooks(books);
    }

    private String[] getRandomAuthors() {
        int number = DataGenerator.getRandomInt(1, 5);
        String[] authors = new String[number];
        for (int i = 0; i < number; i++) {
            authors[i] = DataGenerator.getRandomAuthor();
        }
        return authors;
    }

    private String[] getRandomPublisher() {
        int number = DataGenerator.getRandomInt(1, 7);
        String[] publishers = new String[number];
        for (int i = 0; i < number; i++) {
            publishers[i] = DataGenerator.getRandomPublisher();
        }
        return publishers;
    }

    private Integer[] getRandomYear() {
        int number = DataGenerator.getRandomInt(1, 5);
        Integer[] years = new Integer[number];
        for (int i = 0; i < number; i++) {
            years[i] = DataGenerator.getRandomYear();
        }
        return years;
    }

    private void executeQuery(String[] queries, String key) {
        view.printMessage(Message.SEARCH_HEADER);
        Book[] result = new Book[0];
        for (String query : queries) {
            view.printMessage("Searching for query '" + query + "':");
            if (key.equals("author")) {
                result = model.getByAuthor(query);
            } else if (key.equals("publisher")) {
                result = model.getByPublisher(query);
            }
            if (result.length > 0) {
                view.printBooks(result);
            } else {
                view.printMessage(Message.DATA_NOT_FOUND_MESSAGE);
            }
        }
    }
}