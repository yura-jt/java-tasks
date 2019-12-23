package com.practice.task3_2.controller;

import com.practice.task3_2.model.Product;
import com.practice.task3_2.model.StoreImpl;
import com.practice.task3_2.view.Message;
import com.practice.task3_2.view.View;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private StoreImpl store;
    private View view;
    private InputController inputController;

    public Controller(StoreImpl store, View view) {
        this.store = store;
        this.view = view;
        inputController = new InputController(view);
    }

    public void processData() {
        initiateStore();
        mainMenu();
    }

    private void mainMenu() {
        boolean isExit = false;
        while (!isExit) {
            view.printMessage(Message.MAIN_MENU);
            int key = inputController.getIntFromConsole();
            if (key == 1) {
                addDepartment();
                printStore();
            } else if (key == 2) {
                deleteDepartment();
                printStore();
            } else if (key == 3) {
                redeployDepartment();
                printStore();
            } else if (key == 4) {
                deliverGoods();
                printStore();
            } else if (key == 5) {
                isExit = true;
            }
        }
    }

    private void initiateStore() {
        view.printMessage(Message.START_PROMPT);
        String name = inputController.getStringFromConsole();
        store.setName(name);
        printStore();
    }

    private void addDepartment() {
        boolean isEnd = false;
        while (!isEnd) {
            view.printMessage(Message.DEPARTMENT_NAME_PROMPT);
            String name = inputController.getStringFromConsole();
            if (name.equalsIgnoreCase("end")) {
                break;
            }

            view.printMessage(Message.DEPARTMENT_PRODUCT_PROMPT + name + "\'");
            String products = inputController.getStringFromConsole();
            if (products.equalsIgnoreCase("end")) {
                break;
            }

            view.printMessage(Message.DEPARTMENT_SERVICE_PROMPT + name + "\'");
            String services = inputController.getStringFromConsole();
            if (services.equalsIgnoreCase("end")) {
                break;
            }

            view.printMessage(Message.DEPARTMENT_LOCATION_PROMPT + name + "\'");
            String location = inputController.getStringFromConsole();
            if (location.equalsIgnoreCase("end")) {
                break;
            }

            boolean result = store.addDepartment(name, products, services, location);
            if (result) {
                view.printMessage(Message.ADDED_SUCCESSFUL);
            }

            isEnd = askIfUserWantsToStop();
        }
    }

    private boolean askIfUserWantsToStop() {
        view.printMessage(Message.ADD_MORE_DEPARTMENT);
        String command = inputController.getStringFromConsole();
        if (command.equalsIgnoreCase("yes")) {
            return false;
        }
        return true;
    }

    private void deleteDepartment() {
        view.printMessage(Message.DELETE_DEPARTMENT);
        String name = inputController.getStringFromConsole();

        view.printMessage(Message.CONFIRM_1 + name + Message.CONFIRM_2);
        String confirm = inputController.getStringFromConsole();

        boolean operationResult = false;
        if (confirm.equalsIgnoreCase("yes")) {
            operationResult = store.deleteDepartment(name);
        } else {
            view.printMessage(Message.OPERATION_CANCELED);
        }

        if (operationResult) {
            view.printMessage(Message.DELETED_SUCCESSFUL);
        } else {
            view.printMessage(Message.NOT_DELETED);
        }
    }

    private void deliverGoods() {
        List<Product> enteredProducts = new ArrayList<>();
        boolean isEnd = false;
        view.printMessage(Message.ENTER_PRODUCT);
        while (!isEnd) {
            view.printMessage(Message.NAME_PRODUCT_PROMPT);
            String name = inputController.getStringFromConsole();
            if (name.equalsIgnoreCase("end")) {
                break;
            }
            view.printMessage(Message.PRICE_PRODUCT_PROMPT);
            double d = inputController.getDoubleFromConsole();
            if (d < 0) {
                isEnd = true;
            } else {
                BigDecimal price = BigDecimal.valueOf(d);
                Product product = new Product(name, price);
                enteredProducts.add(product);
            }
        }
        store.deliverGoods(enteredProducts);
        view.printMessage(enteredProducts.size() + Message.DELIVERED
                + store.getName() + "\n");
    }

    private void redeployDepartment() {
        if (store.getDepartments().size() > 0) {
            store.redeployDepartments();
            view.printMessage(Message.REDEPLOYED);
        } else {
            view.printMessage(Message.NOT_REDEPLOYED);
        }
    }

    private void printStore() {
        view.printMessage(store.toString());
    }
}