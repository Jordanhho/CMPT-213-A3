package ca.cmpt213.as2.MazeGame;

/**
 * Player class keeps track of player coordinate and cheese collected.
 */
public class Player {
    //Fields
    private int cheeseCollected = 0;
    private Coordinate coordinate = new Coordinate(1, 1);

    /**
     * Creates a player with an initial coordinate.
     *
     * @param coordinate Players initial coordinate.
     */
    public Player(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    /**
     * Get the players current coordinates.
     *
     * @return Coordinates
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Sets the players coordinates.
     *
     * @param coordinate Players new coordinates.
     */
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    /**
     * Get the number of cheese collected.
     *
     * @return Number of cheese collected.
     */
    public int getCheeseCollected() {
        return cheeseCollected;
    }

    /**
     * Increments number of cheese player has collected.
     */
    public void incrementCheeseCollected() {
        cheeseCollected++;
    }
}
