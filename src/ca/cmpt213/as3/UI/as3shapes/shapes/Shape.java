package ca.cmpt213.as3.UI.as3shapes.shapes;

import ca.cmpt213.as3.MazeGame.Coordinate;

import java.awt.*;

/**
 * Created by Nova on 03/03/2017.
 */
public interface Shape {

    public Coordinate getLocation();

    public void setBorderCharacter(char borderCharacter);

    public char getBorderCharacter();

    public void setColor(Color color);

    public Color getColor();

    public void draw();
}

