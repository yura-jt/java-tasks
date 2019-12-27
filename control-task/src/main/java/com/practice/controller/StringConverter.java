package com.practice.controller;

import com.practice.model.entity.Contact;

import java.util.List;

/**
 * (@link StringConverter) is util class that converts program messages into string object.
 */
public class StringConverter {
    public static final String DELIMITER = "****************************************************";

    public static String listToString(List<Contact> contacts) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (Contact contact : contacts) {
            sb.append("\n#").append(count++);
            sb.append(contact).append(DELIMITER);
        }
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}
