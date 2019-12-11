package com.practice.task2_2.model.impl;

import com.practice.task2_2.model.Book;
import com.practice.task2_2.model.BookService;

public class BookServiceImpl implements BookService {
    private Book[] books;

    public BookServiceImpl(Book[] books) {
        this.books = books;
    }

    @Override
    public Book[] getByAuthor(String name) {
        int count = 0;
        int[] indexes = new int[books.length];
        for (int i = 0; i < books.length; i++) {
            if (books[i].getAuthor().equals(name)) {
                indexes[count++] = i;
            }
        }
        return getResultArray(indexes, count);
    }

    @Override
    public Book[] getPublishedAfterYear(int year) {
        int count = 0;
        int[] indexes = new int[books.length];
        for (int i = 0; i < books.length; i++) {
            if (books[i].getYear() > year) {
                indexes[count++] = i;
            }
        }
        return getResultArray(indexes, count);
    }

    @Override
    public Book[] getByPublisher(String publisher) {
        int count = 0;
        int[] indexes = new int[books.length];
        for (int i = 0; i < books.length; i++) {
            if (books[i].getPublisher().equals(publisher)) {
                indexes[count++] = i;
            }
        }
        return getResultArray(indexes, count);
    }

    private Book[] getResultArray(int[] indexes, int count) {
        Book[] result = new Book[count];
        for (int i = 0; i < count; i++) {
            result[i] = books[indexes[i]];
        }
        return result;
    }
}
