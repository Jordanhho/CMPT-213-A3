package ca.cmpt213.as3.UI.GUI;

import ca.cmpt213.as3.UI.as3shapes.Canvas;
import ca.cmpt213.as3.UI.as3shapes.CanvasIcon;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nova on 10/03/2017.
 */
public class GameGrid {

    private static Canvas canvas = new Canvas(15, 20);

    public static Component makeMazeGrid() {
        CanvasIcon icon = new CanvasIcon(canvas);
        return new JLabel(icon);
    }
}
