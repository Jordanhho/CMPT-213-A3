package ca.cmpt213.as3.UI;


import java.util.Scanner;

import ca.cmpt213.as3.MazeGame.ValidInput;

/**
 * UserInput class to obtain user input with case statement depending on what input
 */
public class UserInput {

    /**
     * Returns a ValidInput of UP, DOWN, LEFT, RIGHT.
     * Wraps the getValidInput method below.
     *
     * @return ValidInput
     */
    public static ValidInput getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String testInput = scanner.nextLine();
        testInput = testInput.toLowerCase();

        //Checking for valid input
        if (testInput.length() != 1) { //make sure 1 character input
            return ValidInput.INVALID;
        } else {
            return getValidInput(testInput);
        }
    }

    /**
     * Returs a valid input based.
     *
     * @param testInput User input as a string.
     * @return ValidInput
     */
    public static ValidInput getValidInput(String testInput) {
        switch (testInput) {
            case "w":
                return ValidInput.UP;

            case "s":
                return ValidInput.DOWN;

            case "a":
                return ValidInput.LEFT;

            case "d":
                return ValidInput.RIGHT;

            case "m":
                return ValidInput.MAP;

            case "?":
                return ValidInput.HELP;

            case "p":
                return ValidInput.PASS;

            case "f":
                return ValidInput.FREEZE;

            case "e":
                return ValidInput.EXIT;

            case "r":
                return ValidInput.RESTART;

            case "+":
                return ValidInput.RADIUSUP;

            case "-":
                return ValidInput.RADIUSDOWN;

            case "h":
                return ValidInput.DIFFICULTY;

            case "c":
                return ValidInput.CHEESE;

            default:
                return ValidInput.INVALID;
        }
    }

    /**
     * GetStartNewgame prompts user if they want to restart the game or not
     *
     * @return returns if the user wants to restart, otherwise exit or invalid input
     */
    public static ValidInput getStartNewGameInput() {

        Scanner scanner = new Scanner(System.in);
        String testInput = scanner.nextLine();
        testInput = testInput.toLowerCase();

        //Checking for valid input
        if (testInput.length() != 1) {      //make sure 1 character input
            return ValidInput.INVALID;
        } else {
            switch (testInput) {
                case "y":
                    return ValidInput.RESTART;

                case "n":
                    return ValidInput.EXIT;

                default:
                    return ValidInput.INVALID;
            }
        }
    }

    /**
     * getDecision prompts the user for a yes or no input
     *
     * @return returns if the user wants to restart, otherwise exit or invalid input
     */
    public static ValidInput getDecision() {
        Scanner scanner = new Scanner(System.in);
        String testInput = scanner.nextLine();
        testInput = testInput.toLowerCase();

        //Checking for valid input
        if (testInput.length() != 1) {      //make sure 1 character input
            return ValidInput.INVALID;
        } else {
            switch (testInput) {
                case "y":
                    return ValidInput.YES;

                case "n":
                    return ValidInput.NO;

                default:
                    return ValidInput.INVALID;
            }
        }
    }


    /**
     * Method to test if a string is a number or not.
     *
     * @param testInput String to parse.
     * @return True if string can be parsed to integer.
     */
    public static boolean isNumber(String testInput) {
        try {
            Integer.parseInt(testInput);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
