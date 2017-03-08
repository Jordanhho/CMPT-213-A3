package ca.cmpt213.as2.MazeGame;

/**
 * Coordinate class stores (row, column) to keep track of locations in the maze easier.
 */
public class Coordinate {
    private int row;
    private int col;

    /**
     * Creates a new coordinate.
     *
     * @param row Row of coordinate.
     * @param col Column of coordinate.
     */
    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Coordinate up() {
        return new Coordinate(row - 1, col);
    }

    public Coordinate down() {
        return new Coordinate(row + 1, col);
    }

    public Coordinate left() {
        return new Coordinate(row, col - 1);
    }

    public Coordinate right() {
        return new Coordinate(row, col + 1);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Coordinate) &&
                (this.row == ((Coordinate) obj).row && this.col == ((Coordinate) obj).col);
    }
}
