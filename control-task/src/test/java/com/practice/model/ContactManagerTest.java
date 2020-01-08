package com.practice.model;

import com.practice.model.entity.Contact;
import com.practice.util.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactManagerTest {
    private ContactManager contactManager;

    @Before
    public void initialize() {
        contactManager = new ContactManager();
        contactManager.setContacts(TestHelper.getSourceData());
    }

    @Test
    public void getContacts() {
        List<Contact> actual = contactManager.getContacts();
        List<Contact> expected = TestHelper.getSourceData();
        assertThat(actual, is(expected));
    }
}