package ca.cmpt213.as3.UI.INPUT;


import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JLabel;

import ca.cmpt213.as3.MazeGame.ValidInput;

import javax.swing.*;

/**
 * UserInput class to obtain user input with case statement depending on what input
 */
public class UserInput {

    private static final String[] VALIDKEYS = {"UP", "DOWN", "LEFT", "RIGHT"};
    private static ValidInput input;

    public static ValidInput getInput() {
        return input;
    }

    public static void setInput(ValidInput input) {
        UserInput.input = input;
    }

    private static void stringInputToEnum(String input) {
        switch (input) {
            case ("UP"):
                setInput(ValidInput.UP);
                break;
            case ("DOWN"):
                setInput(ValidInput.DOWN);
                break;
            case ("LEFT"):
                setInput(ValidInput.LEFT);
                break;
            case ("RIGHT"):
                setInput(ValidInput.RIGHT);
                break;
            default:
                setInput(ValidInput.START);
        }
    }



    private static AbstractAction getKeyListener(final String key, JLabel statusTextBox) {
        return new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                stringInputToEnum(key);
                String stringInput = "Move: ";
                switch (input) {
                    case UP:
                        stringInput = stringInput + "Up";
                        break;
                    case DOWN:
                        stringInput = stringInput + "Down";
                        break;
                    case LEFT:
                        stringInput = stringInput + "Left";
                        break;
                    case RIGHT:
                        stringInput = stringInput + "Right";
                        break;
                    default:
                        stringInput = "Enter a key";
                }
                statusTextBox.setText(stringInput);
            }
        };
    }




    public static void registerKey(JLabel statusTextBox) {
        for (int i = 0; i < VALIDKEYS.length; i++) {
            String key = VALIDKEYS[i];
            statusTextBox.getInputMap().put(KeyStroke.getKeyStroke(key), key);
            statusTextBox.getActionMap().put(key, getKeyListener(key, statusTextBox));
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
}
