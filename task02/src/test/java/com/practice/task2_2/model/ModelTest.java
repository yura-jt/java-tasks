package com.practice.task2_2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ModelTest {
    private Model model;
    private String[][] TEST_DATA = {
            {"Clean code", "Robert Martin", "Pearson Education", "2008", "464", "25.07"},
            {"Test Driven Development", "Kent Beck", "Addison-Wesley Professional", "2002", "240", "36.99"},
            {"Modern Java in Action", "Alan Mycroft", "Manning Publications", "2018", "592", "40.49"}};

    @BeforeEach
    private void prepareBooks() {
        Book[] books = getTestBookArray();
        model = new Model();
        model.setBooks(books);
        model.setBookService();
    }

    private Book[] getTestBookArray() {
        int n = TEST_DATA.length;

        Book[] books = new Book[n];
        for (int i = 0; i < n; i++) {
            Book book = new Book();
            book.setTitle(TEST_DATA[i][0]);
            book.setAuthor(TEST_DATA[i][1]);
            book.setPublisher(TEST_DATA[i][2]);
            book.setYear(Integer.parseInt(TEST_DATA[i][3]));
            book.setPageAmount(Integer.parseInt(TEST_DATA[i][4]));
            book.setPrice(BigDecimal.valueOf(Double.parseDouble(TEST_DATA[i][5])));
            books[i] = book;
        }
        return books;
    }

    @Test
    public void getBooks() {
        Book[] expected = getTestBookArray();
        Book[] actual = model.getBooks();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void setBooks() {
        Book[] mockBooks = getTestBookArray();

        model.setBooks(mockBooks);
        int expected = model.getBooks().length;
        assertEquals(3, expected);

        model.setBooks(new Book[0]);
        assertEquals(0, model.getBooks().length);
    }

    @Test
    public void sortBooksByPublisher() {
        Book[] sorted = model.sortBooksByPublisher();

        assertEquals(sorted[0].getPublisher(), "Addison-Wesley Professional");
        assertEquals(sorted[1].getPublisher(), "Manning Publications");
        assertEquals(sorted[2].getPublisher(), "Pearson Education");
    }

    @Test
    public void getByNonExistAuthor() {
        Book[] actual = model.getByAuthor("George Martin Webber-Meister");
        assertEquals(0, actual.length);
    }

    @Test
    public void getByExistAuthorFullName() {
        Book[] actual = model.getByAuthor("Robert Martin");
        assertEquals("Clean code", actual[0].getTitle());
    }

    @Test
    public void getByAuthorPartOfName() {
        Book[] actual = model.getByAuthor("Kent");
        assertEquals("Test Driven Development", actual[0].getTitle());
    }

    @Test
    public void getByNonExistPublisher() {
        Book[] actual = model.getByPublisher("Cat and meow s.r.l.");
        assertEquals(0, actual.length);
    }

    @Test
    public void getByFullPublisherName() {
        Book[] actual = model.getByPublisher("Manning Publications");
        assertEquals("Modern Java in Action", actual[0].getTitle());
    }

    @Test
    public void getByPartOfPublisherName() {
        Book[] actual = model.getByPublisher("Addison-We");
        assertEquals("Test Driven Development", actual[0].getTitle());
    }

    @Test
    public void getPublishedAfterYear() {
        Book[] actual = model.getPublishedAfterYear(2010);
        assertEquals("Modern Java in Action", actual[0].getTitle());
    }

    @Test
    public void getPublishedAfterUnrelevantYear() {
        Book[] actual = model.getPublishedAfterYear(3000);
        assertEquals(0, actual.length);
    }
}