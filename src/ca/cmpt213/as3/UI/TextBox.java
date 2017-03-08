package ca.cmpt213.as3shapes.A3;

/**
 * Created by Nova on 03/03/2017.
 */
public class TextBox extends Rectangle {

    private int topLeftCoord;
    private int topRightCoord;
    private int bottomLeftCoord;
    private int bottomRightCoord;
    private  String textMessage;

    public TextBox(int topLeftCoord, int topRightCoord, int bottomLeftCoord, int bottomRightCoord, String textMessage) {
        this.topLeftCoord = topLeftCoord;
        this.topRightCoord = topRightCoord;
        this.bottomLeftCoord = bottomLeftCoord;
        this.bottomRightCoord = bottomRightCoord;
        this.textMessage = textMessage;
    }

    public String getMessage() {
        return textMessage;
    }

    public void setMessage(String text) {
        this.textMessage = textMessage;
    }

    public void draw(Canvas canvas) {

    }
}
