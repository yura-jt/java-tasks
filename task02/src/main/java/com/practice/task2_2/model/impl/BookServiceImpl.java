package com.practice.task2_2.model.impl;

import com.practice.task2_2.model.Book;
import com.practice.task2_2.model.BookService;

/**
 * {@link BookServiceImpl} is a BookService implementation that is based on array.
 */
public class BookServiceImpl implements BookService {
    private Book[] books;

    /**
     * Creates an implementation of BookService and initialize it with passed
     * as parameter, books array
     *
     * @param books array of books
     */
    public BookServiceImpl(Book[] books) {
        this.books = books;
    }

    /**
     * This method search books by author and return array of all matching books
     *
     * @param name name of author
     * @return a new array of books by specific author
     */
    @Override
    public Book[] getByAuthor(String name) {
        int count = 0;
        int[] indexes = new int[books.length];
        for (int i = 0; i < books.length; i++) {
            String currentName = books[i].getAuthor().toLowerCase();

            if (currentName.contains(name.toLowerCase())) {
                indexes[count++] = i;
            }
        }
        return getResultArray(indexes, count);
    }

    /**
     * This method search books that were published after certain year, passed
     * as parameter, and return array of all books, that matched criteria.
     *
     * @param year lower bound for publishing year
     * @return a new array of books, published by specific year
     */
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

    /**
     * This method search books that were published by specific company, passed
     * as parameter, and return array of all books, that matched criteria.
     *
     * @param publisher name of publisher
     * @return a new array of books, published by specific company
     */
    @Override
    public Book[] getByPublisher(String publisher) {
        int count = 0;
        int[] indexes = new int[books.length];
        for (int i = 0; i < books.length; i++) {
            String currentPublisher = books[i].getPublisher().toLowerCase();
            if (currentPublisher.contains(publisher.toLowerCase())) {
                indexes[count++] = i;
            }
        }
        return getResultArray(indexes, count);
    }

    private Book[] getResultArray(int[] indexes, int count) {
        if (count == 0) {
            return new Book[0];
        }

        Book[] result = new Book[count];
        for (int i = 0; i < count; i++) {
            result[i] = books[indexes[i]];
        }
        return result;
    }
}
