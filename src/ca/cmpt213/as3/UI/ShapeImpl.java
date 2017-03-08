package ca.cmpt213.as3shapes.A3;

import java.awt.*;

/**
 * Created by Nova on 03/03/2017.
 */
public abstract class ShapeImpl implements ca.cmpt213.as3shapes.A3.Shape {

    public ShapeImpl(int something, int something2, int something3, int something4) { //constructor

    }

    public void setBorder(char character) {

    }

    public char getBorderChar() {
        return 0;
    }


    public void setColor(Color color) {

    }
    public Color getColor() {
        return null;
    }

    public int getLocationX() {
        return 0;
    }


    public int getLocationY() {
        return 0;
    }

    protected int getWidth() {
        return 0;
    }

    protected int getHeight() {
        return 0;
    }

    public void draw() {

    }

    protected abstract boolean isBorder(int something, int something2);

    protected abstract boolean isInside(int something, int something2);
}




