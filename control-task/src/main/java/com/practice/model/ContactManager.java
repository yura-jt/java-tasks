package com.practice.model;

import com.practice.model.entity.Contact;
import com.practice.model.entity.ContactData;
import com.practice.model.entity.ContactDataType;
import com.practice.util.DataSourceProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * (@link ContactManager) is model that is responsible for management of contacts object.
 * It contains main business logic of application and provides API that allow to perform
 * operation with contacts and contact data.
 */
public class ContactManager {
    private List<Contact> contacts;

    public ContactManager() {
        this.contacts = DataSourceProvider.getContacts();
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Contact> getSortedContactList(SortingOrder sortingOrder) {
        List<Contact> list = new ArrayList<>(contacts);
        list.sort(sortingOrder.comparator);
        return list;
    }

    public void mergeContact(Contact from, Contact to) {
        mergeContactData(from, to);
        deleteContact(from);
    }

    public void deleteContact(Contact contact) {
        contacts.remove(contact);
    }

    private void mergeContactData(Contact from, Contact to) {
        List<ContactData> source = from.getContactData();
        List<ContactData> destination = to.getContactData();
        for (ContactData fromAccount : source) {
            boolean isPresent = false;
            for (ContactData toAccount : destination) {
                if (fromAccount.getContactDataType() == toAccount.getContactDataType()) {
                    isPresent = true;
                }
            }
            if (fromAccount.getContactDataType() == ContactDataType.PHONE_NUMBER || !isPresent) {
                destination.add(fromAccount);
            }
        }
    }

    public List<Contact> findContacts(Map<SearchCriteria, String> parameters) {
        List<Contact> result = new ArrayList<>();

        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            boolean isMatch = false;
            for (Map.Entry<SearchCriteria, String> entry : parameters.entrySet()) {
                isMatch = checkContactIsMatchCriteria(contact, entry.getKey(), entry.getValue().toLowerCase());
            }
            if (isMatch) {
                result.add(contact);
            }
        }
        return result;
    }

    private boolean checkContactIsMatchCriteria(Contact contact, SearchCriteria criteria, String value) {
        boolean result = false;
        if (criteria == SearchCriteria.FIRST_NAME) {
            return contact.getFirstName().toLowerCase().contains(value);
        }
        if (criteria == SearchCriteria.LAST_NAME) {
            return contact.getLastName().toLowerCase().contains(value);
        }
        List<ContactData> contactData = contact.getContactData();
        for (ContactData data : contactData) {
            if (data.getContactDataType().name().equals(criteria.name()) &&
                    data.getAccount().toLowerCase().contains(value)) {
                return true;
            }
        }
        return result;
    }
}