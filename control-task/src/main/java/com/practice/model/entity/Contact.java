package com.practice.model.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * (@link Contact) is entity that represent one contact. One contact could have many
 * contact data entries.
 */
public class Contact {
    private String firstName;
    private String lastName;

    private List<ContactData> contactData;

    public Contact(String firstName, String lastName, List<ContactData> contactData) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactData = contactData;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ContactData> getContactData() {
        return contactData;
    }

    public void setContactData(List<ContactData> contactData) {
        this.contactData = contactData;
    }

    private List<ContactData> getSortContactData() {
        List<ContactData> list = new ArrayList<>(contactData);
        list.sort(Comparator.comparingInt(o -> o.getContactDataType().ordinal()));
        return list;
    }

    @Override
    public String toString() {
        List<ContactData> list = getSortContactData();
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator())
                .append(firstName).append(" ")
                .append(lastName)
                .append(System.lineSeparator());

        for (ContactData contact : list) {
            sb.append(contact).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
