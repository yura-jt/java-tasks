package com.practice.model;

import com.practice.model.entity.Contact;

import java.util.Comparator;

/**
 * (@link SortingOrder) is enum that contains sorting types, available in the program.
 * Each enum contain its own comparator as well.
 */
public enum SortingOrder {
    BY_FIRST_NAME((o1, o2) -> {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }),
    BY_LAST_NAME((o1, o2) -> {
        return o1.getLastName().compareTo(o2.getLastName());
    });
    Comparator<Contact> comparator;

    SortingOrder(Comparator<Contact> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Contact> getComparator() {
        return comparator;
    }
}
