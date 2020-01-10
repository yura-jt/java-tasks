package com.training.task5_1.controller.util;

public class Message {
    public static final String PRINT = "\nCurator journal's all records:";
    public static final String MAIN_MENU = "Curator's Journal\n\n" +
            "add - Add student record to the journal\n" +
            "print - Print out curator's journal\n" +
            "exit - Exit\n\n" +
            "Please, make your choice and enter appropriate command name:";
    public static final String WRONG_INPUT = "\nCommand is not recognised.\n";
    public static final String WRONG_FIELD_INPUT = "\nEntered data is not valid.\n" +
            "Please repeat.\n";
    public static final String JOURNAL_EMPTY = "<Curator's journal is empty>\n";
    public static final String NEW_RECORD = "\nEnter data for filling new record:";
    public static final String ENTER_EXIT = "or enter \'exit\' for returning to the Main menu:";

    public static final String FIRST_NAME_PROMPT = "Please enter student's first name \n" + ENTER_EXIT;
    public static final String LAST_NAME_PROMPT = "\nPlease enter student's last name \n" + ENTER_EXIT;
    public static final String BIRTHDAY_PROMPT = "\nPlease enter student's birthday" +
            "in next format: DD/MM/YYYY (f.e. 28/12/1990)\n" + ENTER_EXIT;
    public static final String PHONE_NUMBER_NAME_PROMPT = "\nPlease enter student's phone number" +
            "in next format +38(099)123-45-67\n" + ENTER_EXIT;
    public static final String ADDRESS_PROMPT = "\nPlease enter student's address \n" + ENTER_EXIT;
    public static final String ADDED = "\nRecord was successfully added to curator journal!\n";

}