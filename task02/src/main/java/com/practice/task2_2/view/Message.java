package com.practice.task2_2.view;

/**
 * {@link Message} is an utility class, containing constants of app interface messages.
 */
public class Message {
    public static final String DATA_NOT_FOUND_MESSAGE = "Data not found. No entries match your request.\n";
    public static final String INPUT_MESSAGE = "Please, enter the command:";
    public static final String WRONG_INPUT_MESSAGE = "Command is unrecognised. Please, try again.";
    public static final String MENU_PROMPT = "\n     *  *  *  Welcome to Book Processor ver 1.0  *  *  *\n" +
            "\nYou can perform next operation:\n" +
            "[1] GET book's list by author or any other valid key.\n" +
            "    Command syntax: GET [KEY] [text]\n" +
            "    Valid keys:\n" +
            "    author\tpublisher\tyear\n" +
            "    [year] is year after which book was published\n\n" +
            "[2] FILL books list with random books.\n" +
            "    Command syntax: FILL [number_of_books]\n" +
            "    [number_of_books] is not mandatory field, if absent default value is 10\n\n" +
            "[3] SORT books by publisher.\n" +
            "    Command syntax SORT PUBLISHER\n\n" +
            "[4] EXIT from application.\n" +
            "    Command syntax: EXIT\n\n" +
            "[5] Demo automatic mode with random fill and search\n" +
            "    Command syntax: DEMO\n" +
            "Be aware, that commands and keys are case insensitive.\n";
    public static final String SORT_BY_PUBLISHER = "\n - - -    Performing sort by publisher:    - - -\n";
    public static final String SEARCH_HEADER = "\n   *  *  * Performing searching in books array for next query:  *  *  *\n";
}
