package ca.cmpt213.as3.UI.as3shapes.shapes;

import ca.cmpt213.as3.MazeGame.Coordinate;
import ca.cmpt213.as3.UI.as3shapes.Canvas;
import ca.cmpt213.as3.UI.as3shapes.shapes.Rectangle;

/**
 * Created by Nova on 03/03/2017.
 */
public class TextBox extends Rectangle {

    private  String textMessage;

    public TextBox(Coordinate location, int width, int height, String textMessage) {
        super(location, width, height);
        this.textMessage = textMessage;
    }

    public String getMessage() {
        return textMessage;
    }

    public void setMessage(String textMessage) {
        this.textMessage = textMessage;
    }


    public void draw(Canvas canvas) {

    }
}
