package com.practice.util;

import com.practice.model.entity.Contact;
import com.practice.model.entity.ContactData;
import com.practice.model.entity.ContactDataType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestHelper {
    private static final List<Contact> SOURCE_DATA;

    public static List<Contact> getSourceData() {
        return SOURCE_DATA;
    }

    private static final String[] NAMES = {"Mikhail", "Eugene", "Antonina"};
    private static final String[] SURNAMES = {"Trent", "Urus", "Dillinger"};
    private static final ContactData[] CONTACT_DATA = {new ContactData(ContactDataType.E_MAIL, "argon@gmail.com"),
            new ContactData(ContactDataType.FACEBOOK, "facebook.com/785654787"),
            new ContactData(ContactDataType.SKYPE, "live:walking-live"),
            new ContactData(ContactDataType.LINKEDIN, "linkedin.com/mousemini-b9348b1"),
            new ContactData(ContactDataType.TWITTER, "@guten"),
            new ContactData(ContactDataType.INSTAGRAM, "@batman")};
    private static final String[] PHONE_NUMBERS = {"+380507775432", "0508932498", "+380937778899"};

    static {
        List<Contact> prepare = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int count = i;
            List<ContactData> list = new ArrayList<>();
            ContactData phone = new ContactData(ContactDataType.PHONE_NUMBER, PHONE_NUMBERS[0]);
            ContactData social1 = CONTACT_DATA[i + count++];
            ContactData social2 = CONTACT_DATA[i + count++];
            Collections.addAll(list, phone, social1, social2);
            Contact contact = new Contact(NAMES[i], SURNAMES[i], list);
            prepare.add(contact);
        }
        SOURCE_DATA = new ArrayList<>(prepare);
    }
}
