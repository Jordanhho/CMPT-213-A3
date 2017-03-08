package ca.cmpt213.as2.MazeGame;

import java.util.ArrayList;
import java.util.List;

/**
 * The Maze keeps contains all the objects (cat, mice, cheese) that are needed
 * for the maze game.  An instance of this class must first be initialized by
 * the MazeGenerator to get a fully working maze.
 */
public class Maze {
    //Maze Fields
    private int height;
    private int width;
    private boolean revealAll = false;

    //Player
    private Cell[][] maze;
    private static final Coordinate INITIAL_PLAYER_COORDINATE = new Coordinate(1, 1);
    private Player player = new Player(INITIAL_PLAYER_COORDINATE);

    //Cats
    private List<Cat> cats = new ArrayList<Cat>() {
        {
            add(new Cat(0, new Coordinate(1, 13)));
            add(new Cat(1, new Coordinate(18, 1)));
            add(new Cat(2, new Coordinate(18, 13)));
        }
    };

    //Cheese
    private Coordinate cheeseCoordinates;

    /**
     * Instantiates an non-playable maze with a given height and width (including borders)
     *
     * @param height Height of the maze.
     * @param width  Width of the maze.
     */
    public Maze(int height, int width) {
        this.height = height;
        this.width = width;
        this.maze = new Cell[height][width];
    }

    //Getters and Setters
    static Coordinate getInitialPlayerPosition() {
        return INITIAL_PLAYER_COORDINATE;
    }

    public Cell[][] getMaze() {
        return maze;
    }

    public boolean setCell(Cell cell, Coordinate coordinate) {
        try {
            maze[coordinate.getRow()][coordinate.getCol()] = cell;
            return true;
        } catch (Exception e) {
            //Catches the ArrayOutOfBounds exception.
            return false;
        }
    }

    public void setMaze(Cell[][] maze) {
        this.maze = maze;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isRevealAll() {
        return revealAll;
    }

    public void setRevealAll(boolean revealAll) {
        this.revealAll = revealAll;
    }

    public Coordinate getCheeseCoordinates() {
        return cheeseCoordinates;
    }

    public void setCheeseCoordinates(Coordinate coordinate) {
        this.cheeseCoordinates = coordinate;
    }

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}

