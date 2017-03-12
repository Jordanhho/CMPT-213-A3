package ca.cmpt213.as3.UI.as3shapes;

import ca.cmpt213.as3.UI.as3shapes.shapes.*;
import ca.cmpt213.as3.UI.as3shapes.shapes.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.Shape;
import java.util.*;
import java.util.List;

/**
 * Created by Nova on 10/03/2017.
 */
public class PicturePanel extends JPanel {

    private List<ca.cmpt213.as3.UI.as3shapes.shapes.Shape> shapeList = new ArrayList<>();
    private ca.cmpt213.as3.UI.as3shapes.Canvas canvas;

    private JFrame mainFrame;
    private String title;
    private int width;
    private int height;
    private JLabel topTitle;
    private JLabel bottomCanvasIcon;


    public PicturePanel(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.canvas = new Canvas(width, height);


        CanvasIcon icon = new CanvasIcon(canvas);

        topTitle = new JLabel(title);
        //topTitle.setLayout();
        setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
    }

    public void addFront(ca.cmpt213.as3.UI.as3shapes.shapes.Shape shape) {
        shape.draw(canvas);
        shapeList.add(0, shape);
    }

    public void addBack(ca.cmpt213.as3.UI.as3shapes.shapes.Shape shape) {
        shape.draw(canvas);
        shapeList.add(shape);
    }



}


