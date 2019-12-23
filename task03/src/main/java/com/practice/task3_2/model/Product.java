package com.practice.task3_2.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
    private String name;
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product name = '" + name + '\'' +
                ", price = " + price.setScale(2, RoundingMode.HALF_UP);
    }
}
