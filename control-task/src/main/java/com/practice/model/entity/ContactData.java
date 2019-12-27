package com.practice.model.entity;

/**
 * (@link ContactData) is entity that represent one contact data entry. One contact data entry
 * consists of contact data type and value.
 */
public class ContactData {
    private ContactDataType contactDataType;
    private String account;

    public ContactData(ContactDataType contactDataType, String account) {
        this.contactDataType = contactDataType;
        this.account = account;
    }

    public ContactDataType getContactDataType() {
        return contactDataType;
    }

    public void setContactDataType(ContactDataType contactDataType) {
        this.contactDataType = contactDataType;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return contactDataType + ": " + account;
    }
}
