package ca.cmpt213.as3.UI;

import ca.cmpt213.as3.MazeGame.Cell;

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

    public static char getCellSymbol(Cell cell, boolean revealAll) {
        if (cell.isBorder()) {
            return getBorderSymbol();
        }
        else if (cell.playerDead()) {
            return getDeadSymbol();
        }
        else if (cell.hasCats()) {
            return getCatSymbol();
        }
        else if (cell.hasPlayer()) {
            return getMouseSymbol();
        }
        else if (cell.hasCheese()) {
            return getCheeseSymbol();
        }
        else if (revealAll) {
            if (cell.isWall()) {
                return getWallSymbol();
            }
            else {
                return getEmptySpaceSymbol();
            }
        }
        else if (cell.isDiscovered()) {
            if (cell.isWall()) {
                return getWallSymbol();
            }
            else {
                return getEmptySpaceSymbol();
            }
        }
        else {
            return getUnDiscoveredSymbol();
        }

    }

}
