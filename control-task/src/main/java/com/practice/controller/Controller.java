package com.practice.controller;

import com.practice.model.ContactManager;
import com.practice.model.SearchCriteria;
import com.practice.model.SortingOrder;
import com.practice.model.entity.Contact;
import com.practice.view.View;

import java.util.*;

/**
 * (@link Controller) is the main class that responsible for linking user and model.
 */
public class Controller {
    private View view;
    private ContactManager manager;
    private ResourceBundle bundle;
    private InputController inputController;

    public Controller(View view, ContactManager manager) {
        this.view = view;
        this.manager = manager;
        bundle = ResourceBundle.getBundle("Menu");
        inputController = new InputController(view, bundle);
    }

    public void run() {
        mainMenu();
    }

    private void mainMenu() {
        boolean isExit = false;
        while (!isExit) {
            view.printMessage(bundle.getString("main_menu"));
            int key = inputController.getIntFromConsole(6);
            if (key == 1) {
                languageMenu();
            } else if (key == 2) {
                findMenu();
            } else if (key == 3) {
                sortMenu();
            } else if (key == 4) {
                mergeMenu();
            } else if (key == 5) {
                printContacts();
            } else if (key == 6) {
                isExit = true;
            }
        }
    }

    private void languageMenu() {
        view.printMessage(bundle.getString("language_menu"));

        int key = inputController.getIntFromConsole(4);
        if (key == 1) {
            bundle = ResourceBundle.getBundle("Menu", Locale.US);
        } else if (key == 2) {
            bundle = ResourceBundle.getBundle("Menu", new Locale("uk", "UA"));
        } else if (key == 3) {
            bundle = ResourceBundle.getBundle("Menu", new Locale("ru", "RU"));
        }
        inputController.setBundle(bundle);
    }

    private void findMenu() {
        int upLimit = SearchCriteria.values().length + 2;
        boolean isFinish = false;
        Map<SearchCriteria, String> map = new HashMap<>();

        while (!isFinish) {
            view.printMessage(bundle.getString("find_menu"));

            int key = inputController.getIntFromConsole(upLimit);
            if (key == upLimit - 1) {
                return;
            } else if (key == upLimit) {
                break;
            }
            String value = inputController.getStringFromConsole();
            if (value.equals("")) {
                return;
            }
            SearchCriteria criteria = SearchCriteria.values()[key - 1];
            map.put(criteria, value);
        }
        List<Contact> result = manager.findContacts(map);
        view.printMessage(bundle.getString("search_result_found") + " " +
                result.size() + " " + bundle.getString("search_result_entries"));
        String message = StringConverter.listToString(result);
        view.printMessage(message);
    }

    private void mergeMenu() {
        List<Contact> list = manager.getContacts();
        printContacts();

        view.printMessage(bundle.getString("merge_menu_acc1"));
        int number1 = inputController.getIntFromConsole(list.size());
        if (number1 == -1) {
            return;
        }

        view.printMessage(bundle.getString("merge_menu_acc2"));
        int number2 = inputController.getIntFromConsole(list.size());
        if (number2 == -1) {
            return;
        }
        Contact from = findAccountByNumber(number1);
        Contact to = findAccountByNumber(number2);
        manager.mergeContact(from, to);
        printContacts();
    }

    private void sortMenu() {
        view.printMessage(bundle.getString("sorting_menu"));
        int key = inputController.getIntFromConsole(3);
        if (key == 1) {
            printSorted(SortingOrder.BY_FIRST_NAME);
        } else if (key == 2) {
            printSorted(SortingOrder.BY_LAST_NAME);
        }
    }

    private Contact findAccountByNumber(int number) {
        List<Contact> sorted = getSortedContactList(SortingOrder.BY_FIRST_NAME);
        return sorted.get(number - 1);
    }


    private void printContacts() {
        List<Contact> list = getSortedContactList(SortingOrder.BY_FIRST_NAME);
        String message = StringConverter.listToString(list);
        view.printMessage(message);
    }

    private void printSorted(SortingOrder sortingOrder) {
        List<Contact> list = getSortedContactList(sortingOrder);
        view.printMessage(bundle.getString("contact_list_sorted") + " " +
                bundle.getString(sortingOrder.name().toLowerCase()));
        String message = StringConverter.listToString(list);
        view.printMessage(message);
    }

    private List<Contact> getSortedContactList(SortingOrder sortingOrder) {
        return manager.getSortedContactList(sortingOrder);
    }
}