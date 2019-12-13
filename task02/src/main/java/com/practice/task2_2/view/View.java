package com.practice.task2_2.view;

import com.practice.task2_2.model.Book;

public class View {
    public void printBooks(Book[] books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public String getCommandFromConsole() {
        return InputUtility.getStringFromConsole(this);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

}
