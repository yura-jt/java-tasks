package com.practice.task2_2.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private int year;
    private int pageAmount;
    private BigDecimal price;

    public Book() {
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPageAmount() {
        return pageAmount;
    }

    public void setPageAmount(int pageAmount) {
        this.pageAmount = pageAmount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book title = '" + title + '\'' +
                ", author = '" + author + '\'' +
                ", publisher = '" + publisher + '\'' +
                ", year = " + year +
                ", pageAmount = " + pageAmount +
                ", price = " + price.setScale(2, RoundingMode.HALF_UP) +
                "$";
    }
}
