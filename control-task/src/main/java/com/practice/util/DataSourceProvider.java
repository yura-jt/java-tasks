package com.practice.util;

import com.practice.model.entity.Contact;
import com.practice.model.entity.ContactData;
import com.practice.model.entity.ContactDataType;

import java.util.ArrayList;
import java.util.List;

/**
 * (@link DataSourceProvider) is the datasource that provides test data
 */
public class DataSourceProvider {
    private static final String[] NAMES = {"George", "Ivan", "Michael", "Freddy", "Stan", "Mira", "Angelina", "Xena"};
    private static final String[] SURNAMES = {"Green", "Cooper", "Jenkins", "Carter", "Lopez", "Harris", "Lee", "Griffin"};
    private static final String[] PHONE_NUMBERS = {"+380997775432", "0508932455", "+380938886513", "+482948392934", "789456214", "111222998", "8891", "0507775642"};
    private static final ContactData[] CONTACT_DATA = {new ContactData(ContactDataType.E_MAIL, "wuff@gmail.com"),
            new ContactData(ContactDataType.FACEBOOK, "facebook.com/19203942039"),
            new ContactData(ContactDataType.SKYPE, "live:rocket987"),
            new ContactData(ContactDataType.LINKEDIN, "linkedin.com/fast-and-furious-b9348b1"),
            new ContactData(ContactDataType.TWITTER, "@morgen"),
            new ContactData(ContactDataType.INSTAGRAM, "@super_star"),
            new ContactData(ContactDataType.SKYPE, "live:anchor8"),
            new ContactData(ContactDataType.FACEBOOK, "facebook.com/daisy")};

    public static List<Contact> getContacts() {
        List<Contact> list = new ArrayList<>();
        for (int i = 0; i < NAMES.length; i++) {
            List<ContactData> contactDataList = new ArrayList<>();
            ContactData phone = new ContactData(ContactDataType.PHONE_NUMBER, PHONE_NUMBERS[i]);
            contactDataList.add(phone);
            contactDataList.add(CONTACT_DATA[i]);
            Contact contact = new Contact(NAMES[i], SURNAMES[i], contactDataList);
            list.add(contact);
        }
        return list;
    }
}
