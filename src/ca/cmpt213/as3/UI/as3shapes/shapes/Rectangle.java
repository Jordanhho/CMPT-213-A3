package ca.cmpt213.as3.UI.as3shapes.shapes;

/**
 * Rectangle class to create a rectangle
 */
public class Rectangle extends ShapeImpl {

    public Rectangle(int xLocation, int yLocation, int width, int height) {
        super(xLocation, yLocation, width, height);
    }

    protected boolean isBorder(int testLocationX, int testLocationY) {

        if ((testLocationX == getLocationX() || testLocationX == getLocationX() + getWidth() - 1) && (testLocationY == getLocationY() || testLocationY == getLocationY() + getHeight() - 1)) {
            return true;
        } else {
            return false;
        }
    }

        /*
        for(int i = getLocationY(); i < getLocationY() + width - 1; i++) { //Row Y
            for(int j = getLocationX(); j < getLocationX() + height - 1; j--) { //Col X
                if((testLocationX == getLocationX())) {

                }
                else {

                }
            }
        }
        */


    protected boolean isInside(int testLocationX, int testLocationY) {
        if ((testLocationX > getLocationX() && testLocationX < getLocationX() + getWidth() - 1) && (testLocationY > getLocationY() && testLocationY < getLocationY() + getHeight() - 1)) {
            return true;
        } else {
            return false;
        }
    }
}
