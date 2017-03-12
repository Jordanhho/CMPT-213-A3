package ca.cmpt213.as3.MazeGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by patri on 2/15/2017.
 */
class CoordinateTest {
    @Test
    void up() {
        Coordinate oldCoordinate = new Coordinate(0,0);
        Coordinate newCoordinate = oldCoordinate.up();
        assertEquals (oldCoordinate.getRow(), newCoordinate.getRow() + 1);
        assertEquals (oldCoordinate.getCol(), newCoordinate.getCol());
    }

    @Test
    void down() {
        Coordinate coordinate = new Coordinate(0,0);
        Coordinate downCoordinate = coordinate.down();
        assertEquals (coordinate.getRow(), downCoordinate.getRow() - 1);
        assertEquals (coordinate.getCol(), downCoordinate.getCol());
    }

    @Test
    void left() {
        Coordinate coordinate = new Coordinate(0,0);
        Coordinate leftCoordinate = coordinate.left();
        assertEquals (coordinate.getRow(), leftCoordinate.getRow());
        assertEquals (coordinate.getCol(), leftCoordinate.getCol() + 1);
    }

    @Test
    void right() {
        Coordinate coordinate = new Coordinate(0,0);
        Coordinate rightCoordinate = coordinate.right();
        assertEquals (coordinate.getRow(), rightCoordinate.getRow());
        assertEquals (coordinate.getCol(), rightCoordinate.getCol() - 1);
    }

    @Test
    void equals() {
        Coordinate coordinate = new Coordinate(0,0);
        Coordinate dupCoordinate = new Coordinate(0,0);
        assertEquals (coordinate, dupCoordinate);
    }

}