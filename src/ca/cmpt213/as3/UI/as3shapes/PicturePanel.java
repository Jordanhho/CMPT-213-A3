package ca.cmpt213.as3.UI.as3shapes;

import ca.cmpt213.as3.UI.as3shapes.shapes.Rectangle;
import ca.cmpt213.as3.UI.as3shapes.shapes.ShapeImpl;

/**
 * Created by Nova on 10/03/2017.
 */
public class PicturePanel {

    private Canvas canvas;
    private String title;
    private int width;
    private int height;



    public PicturePanel(String title, int width, int height) {
        this.canvas = new Canvas(width, height);
        this.title = title;
        this.width = width;
        this.height = height;
    }


    public void addFront(ShapeImpl shape) {

    }


    public void addBack(ShapeImpl shape) {

    }



}


