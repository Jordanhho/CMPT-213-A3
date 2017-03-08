package ca.cmpt213.as2;

import ca.cmpt213.as2.MazeGame.*;
import ca.cmpt213.as2.UI.Display;
import ca.cmpt213.as2.UI.UserInput;

import java.util.Scanner;

/**
 * Game (Main) class to test the game
 */
public class Game {
    //Game settings
    private static int numCheese = 5;
    private static int cellRadiusView = 1;
    private static int mazeDifficulty = 155; //the lower the harder: between 0 to 266
    private static int maxCheese = 100;
    private static int maxDifficulty = 100;

    private static void setNumCheese(int numCheese) {
        Game.numCheese = numCheese;
    }

    private static void setMazeDifficulty(int mazeDifficultyNew) {
        mazeDifficulty = Math.round(266 * ((float) (100 - mazeDifficultyNew) / 100));
    }

    private static boolean increaseCellRadiusView() {
        if (cellRadiusView == 100) {
            return false;
        } else {
            cellRadiusView = cellRadiusView + 1;
            return true;
        }
    }

    private static boolean decreaseCellRadiusView() {
        if (cellRadiusView == 0) {
            return false;
        } else {
            cellRadiusView = cellRadiusView - 1;
            return true;
        }
    }

    public static void main(String[] args) {
        boolean restartGame = false;
        boolean changeCheese = false;
        boolean changeDifficulty = false;
        do {

            //Game condition flags
            boolean playerWin = false;
            boolean playerDead = false;

            //Maze generation:
            Maze maze = MazeFactory.makeDefaultMaze(cellRadiusView, mazeDifficulty);

            //Welcome messages
            Display.printWelcomeMsg();
            Display.printHelpMsg(numCheese);

            Display.printMazePackageToScreen(maze, numCheese);

            if (restartGame) {
                Display.printSettingsMsg();
                Display.printRestartedMsg();
                if (changeCheese) {
                    Display.printMaxCheeseMsg(numCheese);
                }

                if (changeDifficulty) {
                    Display.printDifficultyMsg(mazeDifficulty);
                }
            }

            changeDifficulty = false;
            changeCheese = false;
            restartGame = false;
            while (!playerWin && !playerDead && !restartGame) {
                Display.printPromptMsg();
                ValidInput input = UserInput.getUserInput();

                switch (input) {
                    case HELP:
                        Display.printHelpMsg(numCheese);
                        break;

                    case INVALID:
                        Display.printInvalidInputMsg();
                        break;

                    case MAP:
                        if (!maze.isRevealAll()) {
                            maze.setRevealAll(true);
                        } else {
                            maze.setRevealAll(false);
                        }
                        Display.printMazePackageToScreen(maze, numCheese);
                        break;

                    case PASS:
                        if (MazeController.isWalkThroughWalls()) {
                            MazeController.setWalkThroughWalls(false);
                        } else {
                            MazeController.setWalkThroughWalls(true);
                        }
                        Display.printPassThroughWallMsg(MazeController.isWalkThroughWalls());
                        break;

                    case FREEZE:
                        if (MazeController.isStopCats()) {
                            MazeController.setStopCats(false);
                        } else {
                            MazeController.setStopCats(true);
                        }
                        Display.printFreezeCatsMsg(MazeController.isStopCats());
                        break;

                    case EXIT:
                        Display.printExitMsg();
                        System.exit(0);
                        break;

                    case RESTART:
                        restartGame = true;
                        break;

                    case RADIUSUP:
                        if (!increaseCellRadiusView()) {
                            Display.printOutOfRangeViewRadiusMsg();
                            break;
                        } else {
                            MazeController.revealArea(maze.getPlayer().getCoordinate(), maze, cellRadiusView);
                            Display.printMazePackageToScreen(maze, numCheese);
                            Display.printIncreaseViewRadiusMsg(cellRadiusView);
                            break;
                        }

                    case RADIUSDOWN:
                        if (!decreaseCellRadiusView()) {
                            Display.printOutOfRangeViewRadiusMsg();
                            break;
                        } else {
                            MazeController.revealArea(maze.getPlayer().getCoordinate(), maze, cellRadiusView);
                            Display.printMazePackageToScreen(maze, numCheese);
                            Display.printDecreaseViewRadiusMsg(cellRadiusView);
                            break;
                        }

                    case DIFFICULTY:
                        boolean invalid = true;
                        while (invalid) {
                            Display.printDifficultyDecisionPromptMsg();
                            ValidInput decision = UserInput.getDecision();
                            switch (decision) {
                                case YES:
                                    boolean validNumber = false;
                                    while (!validNumber) {
                                        Display.printDifficultyPromptMsg();
                                        Scanner scanner = new Scanner(System.in);
                                        String testInput = scanner.nextLine();

                                        if (!UserInput.isNumber(testInput)) {
                                            Display.printOutOfRangeMsg(0, maxDifficulty);
                                        } else {
                                            int difficulty = Integer.parseInt(testInput);
                                            if (0 <= difficulty && difficulty <= maxDifficulty) {
                                                setMazeDifficulty(difficulty);
                                                validNumber = true;
                                                restartGame = true;
                                                changeDifficulty = true;
                                                invalid = false;
                                            } else {
                                                Display.printOutOfRangeMsg(0, maxDifficulty);
                                            }
                                        }
                                    }
                                    break;

                                case NO:
                                    invalid = false;
                                    break;

                                case INVALID:
                                    Display.printInvalidDecisionMsg();
                                    break;
                            }
                        }
                        break;

                    case CHEESE:
                        invalid = true;
                        while (invalid) {
                            Display.printChangeCheeseDecisionPromptMsg();
                            ValidInput decision = UserInput.getDecision();
                            switch (decision) {
                                case YES:
                                    boolean validNumber = false;
                                    while (!validNumber) {
                                        Display.printChangeCheesePromptMsg(maxCheese);
                                        Scanner scanner = new Scanner(System.in);
                                        String testInput = scanner.nextLine();

                                        if (!UserInput.isNumber(testInput)) {
                                            Display.printOutOfRangeMsg(1, maxCheese);
                                        } else {
                                            int numCheese = Integer.parseInt(testInput);
                                            if (0 < numCheese && numCheese <= maxCheese) {
                                                setNumCheese(numCheese);
                                                validNumber = true;
                                                restartGame = true;
                                                changeCheese = true;
                                                invalid = false;
                                            } else {
                                                Display.printOutOfRangeMsg(1, maxCheese);
                                            }
                                        }
                                    }
                                    break;

                                case NO:
                                    invalid = false;
                                    break;

                                case INVALID:
                                    Display.printInvalidDecisionMsg();
                                    break;
                            }
                        }
                        break;

                    default:
                        if (MazeController.movePlayer(input, maze, cellRadiusView)) {
                            //Check if player moves onto a cat
                            if (checkCatOnPlayer(maze)) {
                                MazeController.setDeathLocation(maze.getPlayer(), maze);
                                playerDead = true;
                            } else {
                                //Checks if player on cheese
                                if (checkPlayerOnCheese(maze)) {
                                    if (maze.getPlayer().getCheeseCollected() == numCheese - 1) { //checks if player has enough cheese to win
                                        maze.getPlayer().incrementCheeseCollected();
                                        playerWin = true;
                                    } else {
                                        maze.getPlayer().incrementCheeseCollected();
                                        MazeController.spawnCheese(maze);
                                    }
                                }
                                MazeController.moveCats(maze);

                                //checks if a cat eats a player
                                if (checkCatOnPlayer(maze)) {
                                    MazeController.setDeathLocation(maze.getPlayer(), maze);
                                    playerDead = true;
                                }
                            }
                            if (!playerWin && !playerDead) {
                                Display.printMazePackageToScreen(maze, numCheese);
                            }
                        } else {
                            Display.printWallMsg();
                        }
                }
            }
            if (playerWin || playerDead) {
                winCondition(playerWin, maze);
                boolean invalid = true;
                while (invalid) {
                    Display.printNewGamePromptMsg();
                    ValidInput input = UserInput.getStartNewGameInput();
                    switch (input) {
                        case EXIT:
                            Display.printExitMsg();
                            System.exit(0);
                            break;

                        case RESTART:
                            restartGame = true;
                            invalid = false;
                            break;

                        case INVALID:
                            Display.printInvalidDecisionMsg();
                            break;
                    }
                }
            }
        } while (true);
    }

    /**
     * Displays messages according to winning condition that has been reached.
     *
     * @param win  Win flag
     * @param maze Maze to check
     */
    private static void winCondition(boolean win, Maze maze) {
        if (win) {
            maze.setRevealAll(true);
            Display.printMazePackageToScreen(maze, numCheese);
            Display.printWinMsg();
        } else {
            maze.setRevealAll(true);
            Display.printMazePackageToScreen(maze, numCheese);
            Display.printEatenMsg();
            Display.printLoseMsg();
        }
    }

    /**
     * Check if player and the cheese is on the same cell.
     * @param maze Maze to check.
     * @return True if player is on the cheese.
     */
    private static boolean checkPlayerOnCheese(Maze maze) {
        return maze.getMaze()[maze.getPlayer().getCoordinate().getRow()][maze.getPlayer().getCoordinate().getCol()].hasCheese();
    }

    /**
     * Checks if the player and cat are on the same coordinate.
     *
     * @param maze Maze to check.
     * @return True if cat and player are on the same cell in the maze.
     */
    private static boolean checkCatOnPlayer(Maze maze) {
        return maze.getMaze()[maze.getPlayer().getCoordinate().getRow()][maze.getPlayer().getCoordinate().getCol()].hasCats();
    }
}



