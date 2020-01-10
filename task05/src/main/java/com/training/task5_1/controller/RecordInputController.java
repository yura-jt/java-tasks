package com.training.task5_1.controller;

import com.training.task5_1.controller.exception.ExitException;
import com.training.task5_1.controller.util.Message;
import com.training.task5_1.model.Record;
import com.training.task5_1.view.InputData;
import com.training.task5_1.view.View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class RecordInputController {
    private static final String FIRST_NAME_REGEX = "^[\\p{L}\\s.’\\-,]+$";
    private static final String LAST_NAME_REGEX = "^[\\p{L}\\s.’\\-,]+$";
    private static final String BIRTHDAY_REGEX = "^(([1-9])|(0[1-9])|(1[0-2]))\\/(([0-9])|([0-2][0-9])|(3[0-1]))\\/(([0-9][0-9])|([1-2][0,9][0-9][0-9]))$";
    private static final String PHONE_NUMBER_NAME_REGEX = "(?:\\+\\d{2})?\\(?\\d{3}\\)?\\d{3}-?\\d{2}-?\\d{2}";
    private static final String ADDRESS_REGEX = "(?i).*[a-zа-я].(\\s+).*";


    private View view;

    public RecordInputController(View view) {
        this.view = view;
    }

    public List<Record> getRecordsFromConsole() {
        List<Record> list = new ArrayList<>();
        try {
            while (true) {
                view.printMessage(Message.NEW_RECORD);

                String firstName = getField(FIRST_NAME_REGEX, Message.FIRST_NAME_PROMPT);
                String lastName = getField(LAST_NAME_REGEX, Message.LAST_NAME_PROMPT);
                String date = getField(BIRTHDAY_REGEX, Message.BIRTHDAY_PROMPT);
                String phoneNumber = getField(PHONE_NUMBER_NAME_REGEX, Message.PHONE_NUMBER_NAME_PROMPT);
                String address = getField(ADDRESS_REGEX, Message.ADDRESS_PROMPT);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
                LocalDate birthDay = LocalDate.parse(date, formatter);

                Record record = new Record.Builder()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setBirthDay(birthDay)
                        .setPhoneNumber(phoneNumber)
                        .setAddress(address)
                        .build();

                list.add(record);
                view.printMessage(Message.ADDED);
            }
        } catch (ExitException e) {
        }
        return list;
    }

    private String getField(String regex, String message) {
        while (true) {
            view.printMessage(message);
            String input = InputData.getString();

            if (input.equals("exit")) {
                throw new ExitException();
            } else if (checkValidField(input, regex)) {
                return input;
            }
            view.printMessage(Message.WRONG_FIELD_INPUT);
        }
    }


    private boolean checkValidField(String input, String regex) {
        return Pattern.matches(regex, input);
    }
}