package ca.cmpt213.as2.MazeGame;

import java.util.ArrayList;
import java.util.List;

/**
 * MazeGenerator Class contains all methods that are related to maze generation.
 * I.e. initializing a playable maze
 */
class MazeGenerator {
    /**
     * Generates the maze
     *
     * @param maze           Maze to initialize
     * @param cellRadiusView the radius of view for the player (default is 1)
     * @param mazeDifficulty difficulty of maze by determining how many blocks to remove ie: the less it is, the harder it is to dodge cats
     */
    static void mazeGen(Maze maze, int cellRadiusView, int mazeDifficulty) {
        //Generate the maze, 0 = wall, 1 = empty space
        //Set all cells to have walls
        initializeMazeCells(maze);

        //Set borders
        setMazeBorders(maze);

        //Start DFS on (0,0), (1,1) for inner maze
        DFSMazeGen(new Coordinate(1, 1), maze);

        //Set the corners of the tempMaze to be empty spaces
        setMazeCornersAsEmpty(maze);

        //Remove some walls from tempMaze
        removeWalls(maze, mazeDifficulty);

        //Set the initial positions of the player
        setInitialPlayerPosition(maze);

        //Set the initial position of the cats
        setInitialCatPositions(maze);

        //Sets revealed area
        setInitialRevealedPositions(maze, cellRadiusView);
    }

    /**
     * Sets the borders of the the maze.
     *
     * @param maze Maze to modify.
     */
    private static void setMazeBorders(Maze maze) {
        Cell[][] cellArray = maze.getMaze();
        //Top border
        for (int col = 0; col < maze.getWidth(); col++) {
            cellArray[0][col].setBorder(true);
        }
        //Bottom border
        for (int col = 0; col < maze.getWidth(); col++) {
            cellArray[maze.getHeight() - 1][col].setBorder(true);
        }
        //Left border
        for (int row = 0; row < maze.getHeight(); row++) {
            cellArray[row][0].setBorder(true);
        }
        //Right border
        for (int row = 0; row < maze.getHeight(); row++) {
            cellArray[row][maze.getWidth() - 1].setBorder(true);
        }
        maze.setMaze(cellArray);
    }

    /**
     * Performs DFS.
     * References from:
     * http://stackoverflow.com/a/6135889/3893713
     * http://www.migapro.com/depth-first-search/
     *
     * @param coordinate Coordinate to start DFS from
     * @param maze       Maze to modify
     */
    private static void DFSMazeGen(Coordinate coordinate, Maze maze) {
        Cell[][] cellArray = maze.getMaze();
        List<ValidInput> directions = Generator.getRandomDirections();
        for (ValidInput direction : directions) {
            //For each direction, check if visited or out of bounds
            switch (direction) {
                case UP:
                    Coordinate upByTwo = coordinate.up().up();
                    Coordinate upByOne = coordinate.up();
                    if (validSpot(upByTwo, maze.getHeight() - 1, Orientation.ROW, maze)) {
                        //Visit coordinate, setting the walls to that coordinate to false.
                        cellArray[upByTwo.getRow()][upByTwo.getCol()].setWall(false);
                        cellArray[upByOne.getRow()][upByOne.getCol()].setWall(false);
                        DFSMazeGen(upByTwo, maze);
                    }
                    break;
                case DOWN:
                    Coordinate downByTwo = coordinate.down().down();
                    Coordinate downByOne = coordinate.down();
                    if (validSpot(downByTwo, maze.getHeight() - 1, Orientation.ROW, maze)) {
                        //Coordinate is valid, perform DFS
                        cellArray[downByTwo.getRow()][downByTwo.getCol()].setWall(false);
                        cellArray[downByOne.getRow()][downByOne.getCol()].setWall(false);
                        DFSMazeGen(downByTwo, maze);
                    }
                    break;
                case LEFT:
                    Coordinate leftByTwo = coordinate.left().left();
                    Coordinate leftByOne = coordinate.left();
                    if (validSpot(leftByTwo, maze.getWidth() - 1, Orientation.COLUMN, maze)) {
                        cellArray[leftByTwo.getRow()][leftByTwo.getCol()].setWall(false);
                        cellArray[leftByOne.getRow()][leftByOne.getCol()].setWall(false);
                        DFSMazeGen(leftByTwo, maze);
                    }
                    break;
                case RIGHT:
                    Coordinate rightByTwo = coordinate.right().right();
                    Coordinate rightByOne = coordinate.right();
                    if (validSpot(rightByTwo, maze.getWidth() - 1, Orientation.COLUMN, maze)) {
                        cellArray[rightByTwo.getRow()][rightByTwo.getCol()].setWall(false);
                        cellArray[rightByOne.getRow()][rightByOne.getCol()].setWall(false);
                        DFSMazeGen(rightByTwo, maze);
                    }
                    break;
                default:
                    assert false;
            }
        }
        maze.setMaze(cellArray);
    }

    /**
     * Used by DFSMazeGen to check
     *
     * @param coordinate  Coordinate to check
     * @param bound       Bound for range checking
     * @param orientation "r" for row checking, "c" for column checking
     * @param maze        Maze to modify
     * @return True if the passed coordinate is within the bound and the coordinate is not a wall.
     */
    private static boolean validSpot(Coordinate coordinate, int bound, Orientation orientation, Maze maze) {
        if (orientation == Orientation.ROW) {
            if (coordinate.getRow() >= 0 && coordinate.getRow() <= bound &&
                    (!maze.getMaze()[coordinate.getRow()][coordinate.getCol()].isBorder() && maze.getMaze()[coordinate.getRow()][coordinate.getCol()].isWall())) {
                return true;
            }
        } else if (orientation == Orientation.COLUMN) {
            if (coordinate.getCol() >= 0 && coordinate.getCol() <= bound &&
                    (!maze.getMaze()[coordinate.getRow()][coordinate.getCol()].isBorder() && maze.getMaze()[coordinate.getRow()][coordinate.getCol()].isWall())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sets the corners of the playable area of the maze as empty.
     *
     * @param maze Maze to modify.
     */
    private static void setMazeCornersAsEmpty(Maze maze) {
        Cell[][] cellArray = maze.getMaze();
        cellArray[1][1].setWall(false); //(1,1)
        cellArray[1][maze.getWidth() - 2].setWall(false); //(1,13)
        cellArray[maze.getHeight() - 2][1].setWall(false); //(18,1)
        cellArray[maze.getHeight() - 2][maze.getWidth() - 2].setWall(false); //(18,13)
        maze.setMaze(cellArray);
    }

    /**
     * Removes walls until the parameter is met.
     * numWallsToRemove Total number of walls you want removed from the maze.
     *
     * @param maze             Maze to modify
     * @param numWallsToRemove Total number of walls you want removed from the maze.
     */
    private static void removeWalls(Maze maze, int numWallsToRemove) {
        Cell[][] cellArray = maze.getMaze();
        int numRemovedWalls = 0;
        //count number of already removed walls in tempMaze
        for (int row = 0; row <= maze.getHeight() - 2; row++) {
            for (int col = 0; col <= maze.getWidth() - 2; col++) {
                if (!cellArray[row][col].isWall()) {
                    numRemovedWalls++;
                }
            }
        }
        while (numRemovedWalls < numWallsToRemove) {
            Coordinate wallToRemove = Generator.getRandomCoordinate(maze.getHeight() - 1, maze.getWidth() - 1);
            if (cellArray[wallToRemove.getRow()][wallToRemove.getCol()].isWall()) {
                cellArray[wallToRemove.getRow()][wallToRemove.getCol()].setWall(false);
                ;
                numRemovedWalls++;
            }
        }
        maze.setMaze(cellArray);
    }


    /**
     * Sets initial player position.
     *
     * @param maze Maze to modify
     */
    private static void setInitialPlayerPosition(Maze maze) {
        Cell[][] cellArray = maze.getMaze();
        cellArray[Maze.getInitialPlayerPosition().getRow()][Maze.getInitialPlayerPosition().getCol()].setPlayer(true);
        maze.setMaze(cellArray);
    }

    /**
     * Sets initial cat positions
     *
     * @param maze Maze to modify.
     */
    private static void setInitialCatPositions(Maze maze) {
        Cell[][] cellArray = maze.getMaze();
        List<Cat> cats = maze.getCats();
        for (Cat cat : cats) {
            List<Cat> singleCat = new ArrayList<>();
            singleCat.add(cat);
            cellArray[cat.getCoordinate().getRow()][cat.getCoordinate().getCol()].setCats(singleCat);
        }
        maze.setMaze(cellArray);
    }

    /**
     * Reveals initial area around player spawn point.
     */
    private static void setInitialRevealedPositions(Maze maze, int cellRadiusView) {
        MazeController.revealArea(maze.getPlayer().getCoordinate(), maze, cellRadiusView);
    }

    /**
     * Sets all the Cells of the maze to be walls initially.
     *
     * @param maze Maze to modify
     */
    private static void initializeMazeCells(Maze maze) {
        Cell[][] cellArray = maze.getMaze();
        for (int row = 0; row < maze.getHeight(); row++) {
            for (int col = 0; col < maze.getWidth(); col++) {
                cellArray[row][col] = new Cell();
                cellArray[row][col].setWall(true);
            }
        }
        maze.setMaze(cellArray);
    }

    /**
     * Enumerators used in the validSpot().
     */
    private enum Orientation {
        ROW, COLUMN
    }
}
