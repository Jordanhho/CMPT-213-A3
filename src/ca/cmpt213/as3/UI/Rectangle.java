package ca.cmpt213.as3shapes.A3;

/**
 * Rectangle class to create a rectangle
 */
public class Rectangle {

    private int topLeftCoord;
    private int topRightCoord;
    private int bottomLeftCoord;
    private int bottomRightCoord;

    public Rectangle(int topLeftCoord, int topRightCoord, int bottomLeftCoord, int bottomRightCoord) {
        this.topLeftCoord = topLeftCoord;
        this.topRightCoord = topRightCoord;
        this.bottomLeftCoord = bottomLeftCoord;
        this.bottomRightCoord = bottomRightCoord;
    }

    protected boolean isBorder(int something, int something2) {
        return true;
    }

    protected boolean isInside(int something, int something2) {
        return true;
    }
}
