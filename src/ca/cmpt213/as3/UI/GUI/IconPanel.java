package ca.cmpt213.as3.UI.GUI;

import ca.cmpt213.as3.UI.MazeElements;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Nova on 12/03/2017.
 */
public class IconPanel {

    //Stored Icons Fields
    private ImageIcon catIcon;

    private ImageIcon deadIcon;

    private ImageIcon emptyIcon;

    private ImageIcon undiscoveredIcon;

    private ImageIcon cheeseIcon;

    private ImageIcon wallIcon;

    private ImageIcon playerIcon;

    public IconPanel() {

       playerIcon = new ImageIcon(getClass().getResource("GameIcons/playerIcon.png"));

       catIcon = new ImageIcon(getClass().getResource("/GameIcons/catIcon.png"));

       deadIcon  = new ImageIcon(getClass().getResource("/GameIcons/deadIcon.png"));

       emptyIcon = new ImageIcon(getClass().getResource("//GameIcons/emptyIcon.png"));

       undiscoveredIcon = new ImageIcon(getClass().getResource("/GameIcons/undiscoveredIcon.png"));

       cheeseIcon = new ImageIcon(getClass().getResource("/GameIcons/cheeseIcon.png"));

       wallIcon = new ImageIcon(getClass().getResource("/GameIcons/wallIcon.png"));
   }


    /**
     * Method to obtain the icon of the current cell
     * @param iconChar the character that the maze has generated to determine what the icon should be
     * @return returns the icon
     */
    public ImageIcon getImageIcon(char iconChar) {
            if(iconChar == MazeElements.getMouseSymbol()) {
                return playerIcon;
            }
            else if(iconChar == MazeElements.getCatSymbol()) {
                return catIcon;
            }
            else if(iconChar == MazeElements.getDeadSymbol()) {
                return deadIcon;
            }
            else if(iconChar == MazeElements.getEmptySpaceSymbol()) {
                return emptyIcon;
            }
            else if(iconChar == MazeElements.getUnDiscoveredSymbol()) {
                return undiscoveredIcon;
            }
            else if(iconChar == MazeElements.getCheeseSymbol()) {
                return cheeseIcon;
            }
            else { //Border and Wall
                return wallIcon;
            }
    }


    public ImageIcon getScaleImageIcon(ImageIcon icon, int width, int height) {
        return new ImageIcon(getScaledImage(icon.getImage(), width, height));
    }


    private Image getScaledImage(Image srcImg, int width, int height){
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
