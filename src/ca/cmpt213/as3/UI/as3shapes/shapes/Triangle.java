package ca.cmpt213.as3.UI.as3shapes.shapes;

import ca.cmpt213.as3.MazeGame.Coordinate;

/**
 * Triangle class to create a triangle object
 */
public class Triangle extends ShapeImpl {

    private int size;

    public Triangle(Coordinate location, int width, int height, int size) {
        super(location, width, height);
        this.size = size;
    }

    protected boolean isBorder(Coordinate location) {
        return true;
    }

    protected boolean isInside(Coordinate location) {

        return true;
    }
}
