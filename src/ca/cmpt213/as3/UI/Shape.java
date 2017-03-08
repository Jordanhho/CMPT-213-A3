package ca.cmpt213.as3shapes.A3;

import java.awt.*;

/**
 * Created by Nova on 03/03/2017.
 */
public interface Shape {

    public int getLocationX();

    public int getLocationY();

    public void setBorder(char character);

    public char getBorderChar();

    public void setColor(Color color);

    public Color getColor();

    public void draw();
}

