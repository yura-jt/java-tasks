package com.practice.task3_2.view;

public class Message {
    public static final String START_PROMPT = "Welcome to Mall App.\n" +
            "Please enter mall name:";
    public static final String REPEAT_MESSAGE = "Please type a valid data or enter \"end\" if you finish entering";
    public static final String STRING_IS_NOT_VALID = "Entered string is not valid. " + REPEAT_MESSAGE;

    public static final String DOUBLE_IS_NOT_VALID = "Entered double number is not valid double type or is negative " +
            REPEAT_MESSAGE;

    public static final String INT_IS_NOT_VALID = "Entered int is not valid or out of range [1..5]. " + REPEAT_MESSAGE;
    public static final String ENTER_PRODUCT = "You are going to add Products for delivering to Mall stock\n";
    public static final String NAME_PRODUCT_PROMPT = "Please, enter name of the product:\n";
    public static final String PRICE_PRODUCT_PROMPT = "Please, enter price of the product:\n";

    public static final String MAIN_MENU = "\n1 Add department\n" +
            "2 Delete department\n" +
            "3 Redeploy departments\n" +
            "4 Deliver departments\n" +
            "5 Exit\n" +
            "\n" +
            "Please, make your choice and enter number:\n";
    public static final String DELIVERED = " products were delivered to the warehouse of ";
    public static final String REDEPLOYED = "Departments were successfully redeployed in mall by the name\n";
    public static final String NOT_REDEPLOYED = "Departments were not redeployed, because mall is empty\n";
    public static final String DELETE_DEPARTMENT = "Please, enter name of the department, you want to delete:";
    public static final String CONFIRM_1 = "You are going to delete department \'";
    public static final String CONFIRM_2 = "\'! Are you sure? Please type \"yes\" for confirmation:";
    public static final String DELETED_SUCCESSFUL = "Department was deleted successfully.\n";
    public static final String OPERATION_CANCELED = "Operation was canceled by user.\n";

    public static final String DEPARTMENT_NAME_PROMPT = "Please enter new department's name:";
    public static final String DEPARTMENT_PRODUCT_PROMPT = "Please enter product names of the department \'";
    public static final String DEPARTMENT_SERVICE_PROMPT = "Please enter names of services of the department \'";
    public static final String DEPARTMENT_LOCATION_PROMPT = "Please enter location of the department \'";
    public static final String ADDED_SUCCESSFUL = "Department was added successfully.\n";
    public static final String ADD_MORE_DEPARTMENT = "Do you want to add more departments? Type \"yes\" if you are, or type \"end\" otherwise";
    public static final String NOT_DELETED = "Department with such name is not exist.";
}
