package ca.cmpt213.as3.UI.as3shapes.shapes;

import ca.cmpt213.as3.UI.as3shapes.*;

import java.awt.*;

/**
 * Created by Nova on 03/03/2017.
 */
public abstract class ShapeImpl implements Shape {

    private int locationX;
    private int locationY;
    private char borderCharacter = '*';
    private Color color = Color.YELLOW;
    private int width;
    private int height;

    public ShapeImpl(int locationX, int locationY, int width, int height) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.width = width;
        this.height = height;
    }

    public void setBorderChar(char borderCharacter) {
        this.borderCharacter = borderCharacter;
    }

    public char getBorderChar() {
        return borderCharacter;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    protected int getWidth() {
        return width;
    }

    protected int getHeight() {
        return height;
    }

    public void draw(ca.cmpt213.as3.UI.as3shapes.Canvas canvas) {
        int count = 0;
        System.out.println("Width:" + width + " height: " + height);
        for(int i = getLocationX(); i < getLocationX() + width - 1; i++) { //Col X
            for(int j = getLocationY(); j < getLocationY() +  height - 1; j++) { //Row Y
                if(isBorder(i, j)) {
                    canvas.setPointColor(locationX, locationY, getColor());
                    canvas.setPointText(locationX, locationY, getBorderChar());
                }
                else if(isInside(i, j)) {
                    canvas.setPointColor(locationX, locationY, getColor());
                }
            }
        }
    }

    protected abstract boolean isBorder(int xLocation, int yLocation);

    protected abstract boolean isInside(int xLocation, int yLocation);
}




