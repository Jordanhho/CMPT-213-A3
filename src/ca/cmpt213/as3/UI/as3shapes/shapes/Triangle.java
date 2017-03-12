package ca.cmpt213.as3.UI.as3shapes.shapes;

import ca.cmpt213.as3.MazeGame.Coordinate;

/**
 * Triangle class to create a triangle object
 */
public class Triangle extends ShapeImpl {

    private int size;

    public Triangle(int xLocation, int yLocation, int size) {
        super(xLocation, yLocation, 0, 0);
        this.size = size;
    }

    protected boolean isBorder(int xLocation, int yLocation) {
        return true;
    }

    protected boolean isInside(int xLocation, int yLocation) {

        return true;
    }
}
