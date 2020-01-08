package com.practice.task2_2.view;

import com.practice.task2_2.model.Book;

/**
 * {@link View} is class responsible for View component in MVC model of 'Book Manager' app.
 */
public class View {
    /**
     * This method prints an array of books to console
     *
     * @param books books to print
     */
    public void printBooks(Book[] books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    /**
     * This method get command from console
     */
    public String getCommandFromConsole() {
        return InputUtility.getStringFromConsole(this);
    }

    /**
     * This method print out to console provided message
     *
     * @param message message to print
     */
    public void printMessage(String message) {
        System.out.println(message);
    }
}