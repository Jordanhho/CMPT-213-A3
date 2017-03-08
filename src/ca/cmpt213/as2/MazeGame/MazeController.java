package ca.cmpt213.as2.MazeGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Maze Controller class manages all methods that modify and sets the maze data type.
 */
public class MazeController {
    //Fields
    private static boolean walkThroughWalls = false;
    private static boolean stopCats = false;

    //Extra-features
    private static boolean wallCheats() {
        return walkThroughWalls;
    }

    public static boolean isWalkThroughWalls() {
        return walkThroughWalls;
    }

    public static void setWalkThroughWalls(boolean walkThroughWalls) {
        MazeController.walkThroughWalls = walkThroughWalls;
    }

    public static boolean isStopCats() {
        return stopCats;
    }

    public static void setStopCats(boolean stopCats) {
        MazeController.stopCats = stopCats;
    }

    /**
     * Moves the element according to the given coordinate position and direction
     *
     * @param currentPos the current position of the object
     * @param direction  the direction the object wants to move
     * @return the new coordinate after the move OR null if ValidInput is not a direction
     */
    private static Coordinate move(Coordinate currentPos, ValidInput direction) {
        switch (direction) {
            case UP:
                return currentPos.up();

            case DOWN:
                return currentPos.down();

            case LEFT:
                return currentPos.left();

            case RIGHT:
                return currentPos.right();

            default:
                return null;
        }
    }

    /**
     * SpawnCheese Method generates a random cheese coordinate and sets it to the maze after checking if it is a previously generated cheese coordinate
     *
     * @param maze Maze to spawn cheese in
     */
    public static void spawnCheese(Maze maze) {
        boolean cheeseSpawned = false;
        while (!cheeseSpawned) {
            Coordinate newCheeseLocation = Generator.getRandomCoordinate(maze.getHeight(), maze.getWidth());
            Cell[][] mazeArray = maze.getMaze();

            if (!mazeArray[newCheeseLocation.getRow()][newCheeseLocation.getCol()].isWall() && !mazeArray[newCheeseLocation.getRow()][newCheeseLocation.getCol()].isBorder()) {
                if (maze.getCheeseCoordinates() == null) {
                    //spawn the cheese
                    Cell cellWithCheese = mazeArray[newCheeseLocation.getRow()][newCheeseLocation.getCol()];
                    cellWithCheese.setCheese(true);
                    maze.setCell(cellWithCheese, newCheeseLocation);

                    maze.setCheeseCoordinates(newCheeseLocation);
                    cheeseSpawned = true;
                } else if (maze.getCheeseCoordinates() != null && maze.getCheeseCoordinates() != newCheeseLocation) {
                    //set past cheese coordinate to false
                    //Cell with no cheese
                    Cell cellWithoutCheese = mazeArray[maze.getCheeseCoordinates().getRow()][maze.getCheeseCoordinates().getCol()];
                    cellWithoutCheese.setCheese(false);
                    maze.setCell(cellWithoutCheese, maze.getCheeseCoordinates());

                    Cell cellWithCheese = mazeArray[newCheeseLocation.getRow()][newCheeseLocation.getCol()];
                    cellWithCheese.setCheese(true);
                    maze.setCell(cellWithCheese, newCheeseLocation);

                    maze.setCheeseCoordinates(newCheeseLocation);
                    cheeseSpawned = true;
                }
            }
        }
    }

    /**
     * Check if a cat of the player hits a wall or not
     *
     * @param currentPos    Current position of the object
     * @param Direction     Direction the object wants to move
     * @param maze          Maze to check
     * @param playerControl for controlling the move through walls cheats
     * @return True if object can move in the specified Direction
     */
    private static boolean checkWallMove(Coordinate currentPos, ValidInput Direction, Maze maze, boolean playerControl) {
        try {
            Coordinate nextPos = move(currentPos, Direction);
            if (maze.getMaze()[nextPos.getRow()][nextPos.getCol()].isBorder()) {
                return false;
            } else if (maze.getMaze()[nextPos.getRow()][nextPos.getCol()].isWall()) {
                return wallCheats() && playerControl;
            } else {
                return true;
            }
        } catch (Exception e) {
            //Returns false if nextPos is null or array is out of bounds.
            return false;
        }
    }


    //Cats:

    /**
     * Method to flip direction given for Cat previous direction field
     *
     * @param direction input a direction
     * @return returns the flipped horizontal or vertical direction
     */
    private static ValidInput flipCatDirection(ValidInput direction) {
        switch (direction) {
            case UP:
                return ValidInput.DOWN;

            case DOWN:
                return ValidInput.UP;

            case LEFT:
                return ValidInput.RIGHT;

            case RIGHT:
                return ValidInput.LEFT;

            default:
                return ValidInput.INVALID;
        }
    }

    /**
     * Moves the cat with calls to generator that makes sure it does not move in the previous direction unless it is a deadend
     *
     * @param maze Maze to move cats in.
     */
    public static void moveCats(Maze maze) {
        List<Cat> cats = maze.getCats();
        if (!stopCats) {
            for (Cat cat : cats) {
                Coordinate currentCoordinate = cat.getCoordinate();

                //Check if valid move
                boolean nonWallMove = false;
                boolean deadEnd = false;

                //For checking previous directions
                List<ValidInput> prevDirectionList = new ArrayList<>();
                ValidInput newDirection = ValidInput.UP;

                while (!nonWallMove && !deadEnd) {
                    //Generate Cat movement direction
                    newDirection = Generator.getRandomCatDirection(cat);

                    if (newDirection != cat.getPrevDirection()) { //Check if prev direction
                        //flag for checking if next move is wall or the previous cat direction
                        if (checkWallMove(cat.getCoordinate(), newDirection, maze, false)) {
                            nonWallMove = true;
                        } else {
                            if (prevDirectionList.size() == 0) { //add to a history list of previous directions for the generation move
                                prevDirectionList.add(newDirection);
                            } else {
                                boolean prevDirectionListFlag = false;
                                int j = 0;
                                while (!prevDirectionListFlag && j < prevDirectionList.size()) { //if found that newly generated move matches a previously generated move, generate a new one
                                    if (prevDirectionList.get(j) == newDirection) {
                                        prevDirectionListFlag = true;
                                    } else {
                                        j++;
                                    }
                                }
                                if (!prevDirectionListFlag) {
                                    prevDirectionList.add(newDirection);
                                } else if (prevDirectionList.size() == 3) {
                                    deadEnd = true;
                                    if (cat.getPrevDirection() == null) { //if starting position and deadend
                                        //generates list of validInputs
                                        List<ValidInput> validInputList = Generator.getRandomDirections();

                                        //Compare 2 arrays of direction and obtain difference of them
                                        boolean foundNewDirection = false;

                                        int n = 0;
                                        while (!foundNewDirection && n < validInputList.size()) { //set anything that is the same to INVALID in validInputList
                                            int k = 0;
                                            boolean sameDirection = false;
                                            while (!sameDirection && k < prevDirectionList.size()) {
                                                if (prevDirectionList.get(k) == validInputList.get(n)) {
                                                    sameDirection = true;
                                                    validInputList.set(n, ValidInput.INVALID);
                                                } else {
                                                    k++;
                                                }
                                            }
                                            if (!sameDirection) {
                                                foundNewDirection = true;
                                            } else {
                                                n++;
                                            }
                                        }

                                        //Loop through validInputList and set anything that isn't INVALID as the newDirection;
                                        for (ValidInput validinput : validInputList) {
                                            if (validinput != ValidInput.INVALID) {
                                                newDirection = validinput;
                                            }
                                        }
                                    } else {
                                        newDirection = cat.getPrevDirection();
                                    }
                                }
                            }
                        }
                    }
                }

                try {
                    //Obtain next coordinate
                    Coordinate nextCoordinate = move(currentCoordinate, newDirection);

                    //add This cat to the coordinates
                    cat.setCoordinate(nextCoordinate);

                    //Set previous direction for cat;
                    cat.setPrevDirection(flipCatDirection(newDirection));

                    maze.setCats(cats);

                    //Set maze coordinate for cat in new coordinate
                    Cell[][] tempMaze = maze.getMaze();
                    tempMaze[nextCoordinate.getRow()][nextCoordinate.getCol()].addCat(cat.getID(), nextCoordinate);

                    //Remove maze coordinate for cat from previous coordinate
                    tempMaze[currentCoordinate.getRow()][currentCoordinate.getCol()].removeCat(cat.getID());
                    maze.setMaze(tempMaze);
                } catch (Exception e) {
                    //Do nothing if nextCoordinate is null
                }
            }
        }
    }


    //Player

    /**
     * Move player a certain direction in the maze.
     *
     * @param direction      ValidInput direction
     * @param maze           Maze to move player
     * @param cellRadiusView the number of cell blocks the player is able to see from his position
     * @return True if move is successful
     */
    public static boolean movePlayer(ValidInput direction, Maze maze, int cellRadiusView) {
        Cell[][] cellArray = maze.getMaze();

        if (checkWallMove(maze.getPlayer().getCoordinate(), direction, maze, true)) {
            Coordinate nextCoordinate = move(maze.getPlayer().getCoordinate(), direction);

            //Sets previous player coordinate to false
            Cell cellWithoutPlayer = cellArray[maze.getPlayer().getCoordinate().getRow()][maze.getPlayer().getCoordinate().getCol()];
            cellWithoutPlayer.setPlayer(false);
            maze.setCell(cellWithoutPlayer, maze.getPlayer().getCoordinate());

            //Sets the new players coordinates to true
            Cell cellWithPlayer = cellArray[nextCoordinate.getRow()][nextCoordinate.getCol()];
            cellWithPlayer.setPlayer(true);
            maze.setCell(cellWithPlayer, nextCoordinate);

            //Update the coordinates of the Player object in the maze.
            Player player = maze.getPlayer();
            player.setCoordinate(nextCoordinate);
            maze.setPlayer(player);

            //reveals the area around the next coordinate
            revealArea(nextCoordinate, maze, cellRadiusView);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Set the Cell's around currPos to revealed.
     *
     * @param coordinate     Coordinate
     * @param maze           Maze
     * @param cellRadiusView the number of cell blocks the player is able to see from his position
     */
    public static void revealArea(Coordinate coordinate, Maze maze, int cellRadiusView) {
        for (int i = -cellRadiusView; i < cellRadiusView + 1; i++) {
            for (int j = -cellRadiusView; j < cellRadiusView + 1; j++) {
                try {
                    if (!maze.getMaze()[coordinate.getRow() + i][coordinate.getCol() + j].isBorder()) {
                        Cell discoveredCell = maze.getMaze()[coordinate.getRow() + i][coordinate.getCol() + j];
                        discoveredCell.setDiscovered(true);
                        maze.setCell(discoveredCell, new Coordinate(coordinate.getRow() + i, coordinate.getCol() + j));
                    }
                } catch (Exception e) {
                    //In the case we are trying to reveal a block that is out of bounds,
                    //just ignore it.
                }
            }
        }
    }

    /**
     * Set death location
     *
     * @param player Player object
     * @param maze   Maze to set player death location
     */
    public static void setDeathLocation(Player player, Maze maze) {
        Cell[][] cellArray = maze.getMaze();
        cellArray[player.getCoordinate().getRow()][player.getCoordinate().getCol()].setPlayerDead();
        maze.setMaze(cellArray);
    }
}