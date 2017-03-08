package ca.cmpt213.as2.UI;

import ca.cmpt213.as2.MazeGame.Cell;
import ca.cmpt213.as2.MazeGame.Maze;

/**
 * Display Class to print out maze, elements and messages
 */
public class Display {

    public static void printWelcomeMsg() {
        System.out.println("----------------------------------------");
        System.out.println("Welcome to Cat and Mouse Maze Adventure!");
        System.out.println("by Patrick San Juan and Jordan Ho");
        System.out.println("----------------------------------------");
    }

    public static void printHelpMsg(int maxCheese) {
        System.out.println();
        System.out.println("DIRECTIONS");
        System.out.println("        Find " + maxCheese + " cheese before a cat eats you!");
        System.out.println("LEGEND:");
        System.out.println("        X: You died");
        System.out.println("        #: Wall");
        System.out.println("        @: You (a mouse)");
        System.out.println("        !: Cat");
        System.out.println("        $: Cheese");
        System.out.println("        .: Unexplored space");
        System.out.println("MOVES:");
        System.out.println("        Use W (up), A (left), S (down) and D (right) to move.");
        System.out.println("        Use m key for reveal all map toggle.");
        System.out.println("        Use ? key for valid commands help");
        System.out.println("        Use p key for walk through wall cheats");
        System.out.println("        Use f key to freeze cats");
        System.out.println("        Use e key to exit program");
        System.out.println("        Use r key to restart program");
        System.out.println("        Use c key to restart program and change the number of cheese win condition");
        System.out.println("        Use h key to restart program and change the difficulty of the maze");
        System.out.println("        Use + key to increase the player's view radius");
        System.out.println("        Use - key to decrease the player's view radius");
        System.out.println("        (NOTE: You must press enter after each move).");
        System.out.println();
    }

    /**
     * Prints the maze package with maze title and cheese collected to screen. Maze's with the revealAll
     * flag set to true will display undiscovered areas as well.
     *
     * @param maze      Maze to print.
     * @param maxCheese Number of cheese to win.
     */
    public static void printMazePackageToScreen(Maze maze, int maxCheese) {
        System.out.println();
        System.out.println("Maze:");
        Cell[][] cellMaze = maze.getMaze();
        for (int row = 0; row < maze.getHeight(); row++) {
            for (int col = 0; col < maze.getWidth(); col++) {
                Cell currentCell = cellMaze[row][col];
                System.out.printf("%2c", symbolToPrint(currentCell, maze.isRevealAll()));
            }
            System.out.println();
        }
        System.out.println("Cheese collected: " + maze.getPlayer().getCheeseCollected() + " of " + maxCheese);
    }

    /**
     * Prints the correct symbol for each element in maze
     *
     * @param cell      the cell given
     * @param revealAll prints a discovered cell or not
     * @return returns the string symbol
     */
    static char symbolToPrint(Cell cell, boolean revealAll) {

        if (cell.isBorder()) {
            return MazeElements.getBorderSymbol();
        } else if (cell.playerDead()) {
            return MazeElements.getDeadSymbol();
        } else if (cell.hasCats()) {
            return MazeElements.getCatSymbol();
        }  else if (cell.hasPlayer()) {
                return MazeElements.getMouseSymbol();
        } else if (cell.hasCheese()) {
            return MazeElements.getCheeseSymbol();
        } else if (revealAll) {
            if (cell.isWall()) {
                return MazeElements.getWallSymbol();
            } else {
                return MazeElements.getEmptySpaceSymbol();
            }
        } else if (cell.isDiscovered()) {
            if (cell.isWall()) {
                return MazeElements.getWallSymbol();
            } else {
                return MazeElements.getEmptySpaceSymbol();
            }
        } else {
            return MazeElements.getUnDiscoveredSymbol();
        }
    }

    //Lose messages
    public static void printEatenMsg() {
        System.out.println("I'm sorry, you have been eaten!");
    }

    public static void printLoseMsg() {
        System.out.println("===========================");
        System.out.println("X      YOU ARE DEAD!!     X");
        System.out.println("===========================");
        System.out.println("GAME OVER; please try again");
    }

    //Win messages
    public static void printWinMsg() {
        System.out.println("Congratulations! You won!");
    }

    //Invalid messages
    public static void printInvalidInputMsg() {
        System.out.println("Invalid command. Please enter a valid command (Enter ? for list of commands): ");
    }

    public static void printWallMsg() {
        System.out.println("Invalid move: you cannot move through walls!");
    }

    //Prompt messages
    public static void printPromptMsg() {
        System.out.print("Enter a command (Enter ? for list of commands): ");
    }


    //====================================EXTRA FEATURES========================================================
    //Messages for the extra features
    public static void printPassThroughWallMsg(boolean status) {
        System.out.println("(NOTE: until player is not on a wall, the player will still be able to move through walls)");
        System.out.println("Pass Through Wall Cheats: " + status);
    }

    public static void printFreezeCatsMsg(boolean status) {
        System.out.println("Cats Frozen: " + status);
    }

    public static void printExitMsg() {
        System.out.println("Exiting Program.");
    }

    //New game message
    public static void printNewGamePromptMsg() {
        System.out.print("Do you want to start a new game? [y/n]: ");
    }

    public static void printInvalidDecisionMsg() {
        System.out.println("Invalid Input. Please enter 'y' (yes) or 'n' (no).");
    }

    public static void printRestartedMsg() {
        System.out.println("Restarted Game.");
    }

    public static void printSettingsMsg() {
        System.out.println("Settings carried over from previous game.");
    }

    //Radius
    public static void printIncreaseViewRadiusMsg(int radius) {
        System.out.println("Radius increased to: " + radius);
    }

    public static void printDecreaseViewRadiusMsg(int radius) {
        System.out.println("Radius decreased to: " + radius);
    }

    public static void printOutOfRangeViewRadiusMsg() {
        System.out.println("Error, invalid input: No change");
    }

    //Difficulty setting
    public static void printDifficultyMsg(int difficulty) {
        System.out.println("The maze generation difficulty is now: " + difficulty);
    }

    public static void printDifficultyDecisionPromptMsg() {
        System.out.print("Do you want to change the Difficulty of the maze (NOTE: STARTS NEW GAME)? [y/n]: ");
    }

    public static void printDifficultyPromptMsg() {
        System.out.print("How difficult do you want the maze to be (HIGHER = HARDER, default = 42), choose a number between (0 to 100): ");
    }


    //Cheese setting
    public static void printChangeCheeseDecisionPromptMsg() {
        System.out.print("Do you want to change the number of cheese win Condition (NOTE: STARTS NEW GAME)? [y/n]: ");
    }

    public static void printChangeCheesePromptMsg(int maxCheese) {
        System.out.print("How many cheese do you want as your winning condition, choose a number between (1 to " + maxCheese + "): ");
    }

    public static void printMaxCheeseMsg(int maxCheese) {
        System.out.println("The number of Cheese needed to be collected is now: " + maxCheese);
    }

    //Error messages
    public static void printOutOfRangeMsg(int min, int max) {
        System.out.println("Error, invalid input: Please enter a number between " + min + " to " + max);
    }
}
