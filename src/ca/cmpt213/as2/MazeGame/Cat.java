package ca.cmpt213.as2.MazeGame;

/**
 * Cat class holds identifiers for which cat and coordinate of the maze they are in.
 */
public class Cat {
    private int ID;
    private Coordinate coordinate;
    private ValidInput prevDirection;

    /**
     * Creates a new cat with an ID and coordinate.
     *
     * @param ID         ID of cat.
     * @param coordinate Initial coordinate
     */
    public Cat(int ID, Coordinate coordinate) {
        this.ID = ID;
        this.coordinate = coordinate;
    }

    public int getID() {
        return ID;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public ValidInput getPrevDirection() {
        return prevDirection;
    }

    public void setPrevDirection(ValidInput direction) {
        prevDirection = direction;
    }
}
