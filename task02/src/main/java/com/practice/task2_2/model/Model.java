package com.practice.task2_2.model;

import com.practice.task2_2.model.impl.BookServiceImpl;

import java.util.Arrays;
import java.util.Comparator;

public class Model {
    private BookService bookService;
    private Book[] books = new Book[0];

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public void setBookService() {
        this.bookService = new BookServiceImpl(books);
    }

    public Book[] sortBooksByPublisher() {
        Book[] sortedCopy = Arrays.copyOf(books, books.length);
        Arrays.sort(sortedCopy, getPublisherComparator());
        return sortedCopy;
    }

    private Comparator<Book> getPublisherComparator() {
        return new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPublisher().compareTo(o2.getPublisher());
            }
        };
    }

    public Book[] getByAuthor(String name) {
        return bookService.getByAuthor(name);
    }

    public Book[] getPublishedAfterYear(int year) {
        return bookService.getPublishedAfterYear(year);
    }

    public Book[] getByPublisher(String publisher) {
        return bookService.getByPublisher(publisher);
    }
}