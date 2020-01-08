package com.practice.task2_2.model;

/**
 * Defines an API for getting {@link Book} objects.
 */
public interface BookService {
    Book[] getByAuthor(String name);

    Book[] getPublishedAfterYear(int year);

    Book[] getByPublisher(String publisher);
}
