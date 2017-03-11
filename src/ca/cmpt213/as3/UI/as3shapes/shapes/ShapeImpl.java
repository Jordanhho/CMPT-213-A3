package ca.cmpt213.as3.UI.as3shapes.shapes;

import ca.cmpt213.as3.MazeGame.Coordinate;

import java.awt.*;
import java.awt.Color;

/**
 * Created by Nova on 03/03/2017.
 */
public abstract class ShapeImpl implements Shape {

    private Coordinate location;
    private char borderCharacter = '*';
    private Color color = Color.YELLOW;
    private int width;
    private int height;

    public ShapeImpl(Coordinate location, int width, int height) {
        this.location = location;
        this.width = width;
        this.height = height;
    }

    public void setBorderCharacter(char borderCharacter) {
        this.borderCharacter = borderCharacter;
    }

    public char getBorderCharacter() {
        return borderCharacter;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }


    public Coordinate getLocation() {
        return location;
    }

    protected int getWidth() {
        return width
    }

    protected int getHeight() {
        return height
    }


    public void draw() {
    }

    protected abstract boolean isBorder(Coordinate location);

    protected abstract boolean isInside(Coordinate location);
}




