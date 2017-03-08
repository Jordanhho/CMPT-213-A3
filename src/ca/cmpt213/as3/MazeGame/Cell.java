package ca.cmpt213.as3.MazeGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Cell class keeps track of all the different cats, cheese, player, wall, empty space, border and discovered positions.
 */
public class Cell {
    //Fields
    private List<Cat> cats = new ArrayList<>();
    private boolean player;
    private boolean cheese;
    private boolean wall;
    private boolean discovered;
    private boolean border;
    private boolean deadPlayer = false;

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }

    /**
     * Adds a cat to the cell.
     *
     * @param ID         ID of cat
     * @param coordinate Coordinate
     */
    public void addCat(int ID, Coordinate coordinate) {
        cats.add(new Cat(ID, coordinate));
    }

    public void removeCat(int ID) {
        for (int i = 0; i < cats.size(); i++) {
            if (cats.get(i).getID() == ID) {
                cats.remove(i);
            }
        }
    }

    public boolean playerDead() {
        return deadPlayer;
    }

    public void setPlayerDead() {
        this.deadPlayer = true;
    }

    public boolean hasPlayer() {
        return player;
    }

    public boolean hasCheese() {
        return cheese;
    }

    public boolean isWall() {
        return wall;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public boolean isBorder() {
        return border;
    }

    public boolean hasCats() {
        return (cats != null && cats.size() > 0);
    }

    public void setPlayer(boolean player) {
        this.player = player;
    }

    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }

    public void setWall(boolean wall) {
        this.wall = wall;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }

    public void setBorder(boolean border) {
        this.border = border;
    }
}
