package com.practice.task2_2.model;

public interface BookService {
    Book[] getByAuthor(String name);

    Book[] getPublishedAfterYear(int year);

    Book[] getByPublisher(String publisher);
}
