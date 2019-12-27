package com.practice.model.entity;

/**
 * (@link ContactDataType) essential enum that contains constants of contact data types.
 */
public enum ContactDataType {
    PHONE_NUMBER("Phone number"),
    SKYPE("Skype"),
    E_MAIL("E-mail"),
    FACEBOOK("Facebook"),
    LINKEDIN("LinkedIn"),
    TWITTER("Twitter"),
    INSTAGRAM("Instagram");

    private String title;

    ContactDataType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}