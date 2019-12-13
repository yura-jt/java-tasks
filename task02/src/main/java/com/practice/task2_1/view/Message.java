package com.practice.task2_1.view;

public class Message {
    public final static String PRINT_SORTED_BY_COLOR_MESSAGE = "\n--------- Printing array of geometry figures sorted by color: -----------\n";
    public final static String PRINT_SORTED_BY_AREA_MESSAGE = "\n--------- Printing array of geometry figures sorted by area: ------------\n";
    public final static String PRINT_SORTED_BY_TYPE_MESSAGE = "\n--------- Printing array of geometry figures sorted by type: ------------\n";
    public final static String PRINT_ARRAY_UPDATED = "\n--------- Array of geometry figures was successfully updated! -----------";

    public final static String HEADER = ".===============================================================.\n" +
            "||                Shape Area Summarizer 1.0                    ||\n" +
            "`===============================================================`\n" +
            "\n";

    public final static String START_MENU = HEADER +
            "\n" +
            "            [1] - Manual input mode\n" +
            "            [2] - Demo mode with randomized data\n" +
            "            [3] - Exit\n";

    public final static String EXIT_MENU = "\n********** Program is shutting down, see you next time! *********\n";

    public final static String COMMAND_PROMPT = "--> ";

    public final static String START_MENU_COMMANDS = "If you want to switch to Manual input mode, please enter 1 or M\n" +
            "If you want to switch to automatic Demonstration mode, please enter 2 or D\n" +
            "If you want to exit from the program, please enter E\n" +
            "\n" +
            "Commands are case insensitive.\n" +
            "" +
            "Please, make your choice and press Enter:";

    public final static String COMMAND_NOT_VALID = "-------Error! Command is not recognised and therefore is not valid.-------\n" +
            "Please, make one more attempt\n";

    public final static String MAIN_MENU = HEADER + "                       MAIN MENU\n" +
            "\n" +
            "----| ADD  |---- Add figures to array\n" +
            "----| SORT |---- Sort figures array by criteria\n" +
            "----| CALC |---- Calculate figure's are\n" +
            "----| HELP |---- Help for command syntax\n" +
            "----| EXIT |---- Exit program\n" +
            "\n" +
            "Commands are case insensitive. " +
            "Allowed colors are: RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET, PINK, BROWN, BLACK, WHITE\n" +
            "Examples of commands:\n" +
            "-->add circle red 2.0\n" +
            "-->add rectangle white 10.0 7.0\n" +
            "-->add triangle black 9.9 8.0 3.2\n" +
            "-->sort color\n" +
            "-->sort area\n" +
            "-->sort type\n" +
            "-->calc total\n" +
            "-->calc rectangle\n" +
            "-->calc rectangle circle\n" +
            "-->help\n" +
            "-->exit\n";

    public final static String HELP_MENU = HEADER + "                     HELP MENU\n" +
            "\n" +
            "\n" +
            "----| ADD  |----\n" +
            "This command create and add to existing array one custom figure.\n" +
            "Command syntax: ADD [FIGURE_TYPE] [COLOR] [DIMENSION...]\n" +
            "Examples of command:\n" +
            "-->add circle red 2.0\n" +
            "-->add rectangle white 10.0 7.0\n" +
            "-->add triangle black 9.9 8.0 3.2\n" +
            "\n" +
            "Allowed colors are: RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET, PINK, BROWN, BLACK, WHITE\n" +
            "\n" +
            "----| SORT |----\n" +
            "This command is sorting array by next criteria: area, figure type, color." +
            "Examples of command:\n" +
            "-->sort color\n" +
            "-->sort area\n" +
            "-->sort type\n" +
            "\n" +
            "----| CALC |----\n" +
            "This command calculates area of all or given type figure.\n" +
            "Examples of command:\n" +
            "Please, note that you can combine different types in your query.\n" +
            "Order of given types is not important\n" +
            "-->calc total\n" +
            "-->calc rectangle\n" +
            "-->calc circle rectangle\n" +
            "-->calc triangle rectangle circle\n" +
            "\n" +
            "----| HELP |----\n" +
            "This command provides additional information on commands.\n" +
            "\n" +
            "----| EXIT |----\n" +
            "This command perform exit from the application.\n" +
            "\n" +
            "Press any symbol key and Enter to continue, for example: c and Enter";

    public static final String RADIUS_NOT_VALID = "ShapeBuilder error: radius is not valid. Please check argument";
    public static final String SHAPE_NOT_VALID = "ShapeBuilder error: such type of geometry figure is not supported by the program!";
    public static final String COLOR_NOT_VALID = "ShapeBuilder error: such color of figure is not supported by the program!";
    public static final String ILLEGAL_ARGUMENT_LENGTH = "Syntax error: illegal number of arguments";
    public static final String RECTANGLE_NOT_VALID = "Syntax error: rectangle dimensions are not valid";
    public static final String TRIANGLE_NOT_VALID = "Syntax error: triangle dimensions are not valid";
}
