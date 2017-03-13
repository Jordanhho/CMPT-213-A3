package ca.cmpt213.as3.UI.GUI;

import ca.cmpt213.as3.UI.MazeElements;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Nova on 12/03/2017.
 */
public class IconPanel extends JPanel {

    public static ImageIcon getImageIcon(char iconChar) {
            ImageIcon icon;
            if(iconChar == MazeElements.getMouseSymbol()) {
                icon = new ImageIcon("C:/Users/Nova/CMPT213-A3/src/ca/cmpt213/as3/UI/GUI/GameIcons/Player.png");
            }
            else if(iconChar == MazeElements.getCatSymbol()) {
                icon = new ImageIcon("C:/Users/Nova/CMPT213-A3/src/ca/cmpt213/as3/UI/GUI/GameIcons/Cat.png");
            }
            else if(iconChar == MazeElements.getDeadSymbol()) {
                icon = new ImageIcon("C:/Users/Nova/CMPT213-A3/src/ca/cmpt213/as3/UI/GUI/GameIcons/Dead.png");
            }
            else if(iconChar == MazeElements.getEmptySpaceSymbol()) {
                icon = new ImageIcon("C:/Users/Nova/CMPT213-A3/src/ca/cmpt213/as3/UI/GUI/GameIcons/sEmptyTile.png");
            }
            else if(iconChar == MazeElements.getUnDiscoveredSymbol()) {
                icon = new ImageIcon("C:/Users/Nova/CMPT213-A3/src/ca/cmpt213/as3/UI/GUI/GameIcons/UndiscoveredTile.png");
            }
            else if(iconChar == MazeElements.getCheeseSymbol()) {
                icon = new ImageIcon("C:/Users/Nova/CMPT213-A3/src/ca/cmpt213/as3/UI/GUI/GameIcons/Cheese.png");
            }
            else { //Border and Wall
                icon = new ImageIcon("C:/Users/Nova/CMPT213-A3/src/ca/cmpt213/as3/UI/GUI/GameIcons/Wall.png");
            }
            return icon;
    }


    static public ImageIcon getScaleImageIcon(ImageIcon icon, int width, int height) {
        return new ImageIcon(getScaledImage(icon.getImage(), width, height));
    }


    static private Image getScaledImage(Image srcImg, int width, int height){
        BufferedImage resizedImg =
                new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, width, height, null);
        g2.dispose();
        return resizedImg;
    }
}
