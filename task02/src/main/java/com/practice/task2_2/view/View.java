package com.practice.task2_2.view;

import com.practice.task2_2.model.Book;

public class View {
    public static final String DATA_NOT_FOUND_MESSAGE = "Data not found. No entries match your request.";
    public static final String INPUT_MESSAGE = "Please, enter the command:";
    public static final String WRONG_INPUT_MESSAGE = "Command is unrecognised. Please, enter the command one more time:";
    public static final String MENU_PROMPT = "\nWelcome to Book Processor ver 1.0.\n" +
            "You can perform next operation:\n" +
            "1. Get book's list by author or any other valid key.\n" +
            "Command syntax: GET [KEY] [text]\n" +
            "Valid keys:\n" +
            "title\tauthor\tpublisher\tyear\tpages\tprice" +
            "[year] is year after which book was published)\n\n" +
            "2. Fill books list with random books.\n" +
            "Command syntax: FILL [number_of_books]\n" +
            "[number_of_books] is not mandatory field, if absent default value is 10\n\n" +
            "3. Sort books by any valid key, mentioned above.\n" +
            "Command syntax SORT [KEY]\n\n" +
            "4. Exit from application.\n" +
            "Command syntax: EXIT\n" +
            "Please, pay attention, that commands and keys should be strictly upper-case.\n";


    public void printBooks(Book[] books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public String getCommandFromConsole() {
        System.out.println(INPUT_MESSAGE);
        return InputUtility.getStringFromConsole(this);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

}
