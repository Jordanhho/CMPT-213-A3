package ca.cmpt213.as3.UI.as3shapes.shapes;

import ca.cmpt213.as3.MazeGame.Coordinate;

/**
 * Rectangle class to create a rectangle
 */
public class Rectangle extends ShapeImpl {

    private int width;
    private int height;

    public Rectangle(Coordinate location, int width, int height) {
        super(location, width, height);
        this.width = width;
        this.height = height;
    }

    protected boolean isBorder(Coordinate location) {
        return true;
    }

    protected boolean isInside(Coordinate location) {
        return true;
    }
}
