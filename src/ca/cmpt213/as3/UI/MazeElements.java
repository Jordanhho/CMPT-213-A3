package ca.cmpt213.as3.UI;

/**
 * MazeElements class to add in symbols map for every element.
 */
public class MazeElements {
    public static char getMouseSymbol() {
        return '@';
    }

    public static char getCatSymbol() {
        return '!';
    }

    public static char getDeadSymbol() {
        return 'X';
    }

    public static char getWallSymbol() {
        return '#';
    }

    public static char getBorderSymbol() {
        return '#';
    }

    public static char getEmptySpaceSymbol() {
        return ' ';
    }

    public static char getUnDiscoveredSymbol() {
        return '.';
    }

    public static char getCheeseSymbol() {
        return '$';
    }
}
