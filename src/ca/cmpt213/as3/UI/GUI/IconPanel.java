package ca.cmpt213.as3.UI.GUI;

import ca.cmpt213.as3.MazeGame.Coordinate;
import ca.cmpt213.as3.UI.MazeElements;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Nova on 12/03/2017.
 */
public class IconPanel extends JPanel {

    private static BufferedImage image;
   // private ImageIcon icon;


    /*
    public ImageIcon getIcon() {
        return icon;
    }
    */

    /*
    public IconPanel(char iconChar) {
        try {
            if(iconChar == MazeElements.getMouseSymbol()) {
                this.icon = new ImageIcon("/GameIcons/Player.png");
               // InputStream stream = getClass().getResourceAsStream("Player.png");
                //this.icon = new ImageIcon(ImageIO.read(stream));

                //icon = ImageIO.read(new ImageIcon(getClass().getClassLoader().getResource("Player.png")));
                //IconPanel.class.getResource("Player.png");
                //icon = new JLabel(IconPanel.class.getResource("Player.png"));
                //icon = new JLabel();
                //icon = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("resource/images/polygon.jpg")));
                //new ImageIcon("Player.png");
            }


            /*
            else if(iconChar == MazeElements.getCatSymbol()) {

                InputStream stream = getClass().getResourceAsStream("Cat.png");
                this.icon = new ImageIcon(ImageIO.read(stream));

                //icon = new ImageIcon("C:/Users/Nova/CMPT213-A3/src/ca/cmpt213/as3/UI/GUI/GameIcons/Cat.png");
            }
            else if(iconChar == MazeElements.getDeadSymbol()) {
                InputStream stream = getClass().getResourceAsStream("Dead.png");
                this.icon = new ImageIcon(ImageIO.read(stream));

                //icon = new ImageIcon("C:/Users/Nova/CMPT213-A3/src/ca/cmpt213/as3/UI/GUI/GameIcons/Dead.png");
            }
            else if(iconChar == MazeElements.getEmptySpaceSymbol()) {
                InputStream stream = getClass().getResourceAsStream("EmptyTile.png");
                this.icon = new ImageIcon(ImageIO.read(stream));

                //icon = new ImageIcon("C:/Users/Nova/CMPT213-A3/src/ca/cmpt213/as3/UI/GUI/GameIcons/sEmptyTile.png");
            }
            else if(iconChar == MazeElements.getUnDiscoveredSymbol()) {
                InputStream stream = getClass().getResourceAsStream("UndiscoveredTile.png");
                this.icon = new ImageIcon(ImageIO.read(stream));
                //icon = new ImageIcon("C:/Users/Nova/CMPT213-A3/src/ca/cmpt213/as3/UI/GUI/GameIcons/UndiscoveredTile.png");
            }
            else if(iconChar == MazeElements.getCheeseSymbol()) {
                InputStream stream = getClass().getResourceAsStream("Cheese.png");
                this.icon = new ImageIcon(ImageIO.read(stream));
                //icon = new ImageIcon("C:/Users/Nova/CMPT213-A3/src/ca/cmpt213/as3/UI/GUI/GameIcons/Cheese.png");
            }

            else { //Border and Wall
                InputStream stream = getClass().getResourceAsStream("Wall.png");
                this.icon = new ImageIcon(ImageIO.read(stream));
                //icon = new ImageIcon("C:/Users/Nova/CMPT213-A3/src/ca/cmpt213/as3/UI/GUI/GameIcons/Wall.png");
            }
            */

      //  }
      //  catch (IOException ex) {

     //   }
    //}



    public static ImageIcon getImageIcon(char iconChar) {
            ImageIcon icon;
            if(iconChar == MazeElements.getMouseSymbol()) {
                icon = new ImageIcon("C:/Users/Nova/CMPT213-A3/src/ca/cmpt213/as3/UI/GUI/GameIcons/Player.png");
                //InputStream stream = getClass().getResourceAsStream("Player.png");
                //icon = new ImageIcon(ImageIO.read(stream));

                //icon = ImageIO.read(new ImageIcon(getClass().getClassLoader().getResource("Player.png")));
                //IconPanel.class.getResource("Player.png");
                //icon = new JLabel(IconPanel.class.getResource("Player.png"));
                //icon = new JLabel();
                //icon = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("resource/images/polygon.jpg")));
                        //new ImageIcon("Player.png");
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



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters
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
