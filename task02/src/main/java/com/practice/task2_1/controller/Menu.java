package com.practice.task2_1.controller;

import com.practice.task2_1.model.FigureType;
import com.practice.task2_1.model.entity.Shape;
import com.practice.task2_1.model.util.DataGenerator;
import com.practice.task2_1.view.InputData;
import com.practice.task2_1.view.Message;
import com.practice.task2_1.view.View;

public class Menu {
    private View view;
    private Controller controller;
    private final static String[] SORT_TYPE = {"COLOR", "TYPE", "AREA"};

    public Menu(Controller controller, View view) {
        this.controller = controller;
        this.view = view;
    }

    public void initiateStartMenu() {
        view.printMessage(Message.START_MENU);
        String command = getStartMenuCommand();

        if (command.equals("MANUAL_MODE")) {
            processManualMode();
        } else if (command.equals("DEMO_MODE")) {
            processDemoMode();
        }
        view.printMessage(Message.EXIT_MENU);
    }

    private void processManualMode() {
        view.printMessage(Message.MAIN_MENU);
        boolean isExit = false;
        while (!isExit) {
            String command = inputCommand();
            String[] args = command.split(" ");
            if (command.startsWith("add")) {
                addFigure(args);
            } else if (command.startsWith("sort")) {
                sortFigure(args);
            } else if (command.startsWith("calc")) {
                calcArea(args);
            } else if (command.startsWith("help")) {
                help();
            } else if (command.startsWith("exit")) {
                isExit = true;
            } else {
                view.printMessage(Message.COMMAND_NOT_VALID);
                view.printMessage("Enter HELP and press Enter for more detailed command syntax");
            }
        }
    }

    private void addFigure(String[] args) {
        boolean isValidCommand = validateAddCommand(args);
        boolean isValidShape = ShapeValidator.validateShape(args, view);
        if (isValidCommand && isValidShape) {
            addFigureToArray(args);
        }
    }

    private boolean validateAddCommand(String[] args) {
        boolean result = false;
        if (args.length > 3) {
            result = true;
        }
        return result;
    }

    private void addFigureToArray(String[] args) {
        Shape shape = ShapeBuilder.createFigure(args);
        controller.addFigureToArray(shape);
    }

    private void sortFigure(String[] args) {
        boolean isValid = validateSortCommand(args);
        if (!isValid) {
            view.printMessage(Message.COMMAND_NOT_VALID);
        } else {
            String sortCriteria = args[1];
            performSorting(sortCriteria.toLowerCase());
        }
    }

    private void performSorting(String sortCriteria) {
        if (sortCriteria.equals("type")) {
            controller.sortFiguresByType();
        } else if (sortCriteria.equals("color")) {
            controller.sortFiguresByColor();
        } else if (sortCriteria.equals("area")) {
            controller.sortFiguresByArea();
        }
    }

    private void calcArea(String[] args) {
        boolean isValid = validateCalcAreaCommand(args);
        if (isValid && args[1].equals("total")) {
            controller.getTotalArea();
        } else if (isValid) {
            FigureType[] figureTypes = getFigureTypesFromArg(args);
            controller.getAreaSumByFigureType(figureTypes);
        }
    }

    private FigureType[] getFigureTypesFromArg(String[] args) {
        FigureType[] figureTypes = new FigureType[args.length - 1];
        for (int i = 0; i < figureTypes.length; i++) {
            String type = args[i + 1];
            FigureType figureType = FigureType.valueOf(type.toUpperCase());
            figureTypes[i] = figureType;
        }
        return figureTypes;
    }

    private boolean validateCalcAreaCommand(String[] args) {
        if (args.length < 2 || !isAllShapesExist(args)) {
            view.printMessage(Message.COMMAND_NOT_VALID);
            return false;
        }
        return isAllShapesExist(args);
    }

    private boolean isAllShapesExist(String[] args) {
        if (args[1].equals("total")) {
            return true;
        }
        boolean result = false;
        try {
            getFigureTypesFromArg(args);
            result = true;
        } catch (Exception e) {
        }
        return result;
    }

    private void help() {
        view.printMessage(Message.HELP_MENU);
        inputCommand();
    }

    private String getStartMenuCommand() {
        boolean isValid = false;
        String command = "";
        while (!isValid) {
            view.printMessage(Message.START_MENU_COMMANDS);
            command = inputCommand();

            if (command.equals("m") || command.equals("1")) {
                return "MANUAL_MODE";
            } else if (command.equals("d") || command.equals("2")) {
                return "DEMO_MODE";
            } else if (command.equals("e") || command.equals("3")) {
                return "EXIT_MODE";
            } else {
                view.printMessage(Message.COMMAND_NOT_VALID);
            }
        }
        return command;
    }

    private boolean validateSortCommand(String[] args) {
        if (args.length != 2) {
            view.printMessage(Message.ILLEGAL_ARGUMENT_LENGTH);
            return false;
        }
        String sortCriteria = args[1];
        boolean result = false;
        for (String s : SORT_TYPE) {
            if (sortCriteria.equalsIgnoreCase(s)) {
                result = true;
            }
        }
        return result;
    }

    private String inputCommand() {
        view.printCommandPrompt();
        return InputData.input().toLowerCase();
    }

    private void processDemoMode() {
        Shape[] figures = DataGenerator.getFilledShapeArray(10);
        controller.setFigureArray(figures);

        controller.getTotalArea();

        controller.getAreaSumByFigureType(FigureType.RECTANGLE, FigureType.CIRCLE);
        controller.getAreaSumByFigureType(FigureType.TRIANGLE);
        controller.getAreaSumByFigureType(FigureType.CIRCLE);

        controller.sortFiguresByArea();
        controller.sortFiguresByColor();
        controller.sortFiguresByType();
    }
}
