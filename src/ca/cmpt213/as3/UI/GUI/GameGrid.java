package ca.cmpt213.as3.UI.GUI;

import ca.cmpt213.as3.MazeGame.Cell;
import ca.cmpt213.as3.MazeGame.Maze;
import ca.cmpt213.as3.UI.Display;
import ca.cmpt213.as3.UI.MazeElements;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nova on 10/03/2017.
 */
public class GameGrid {

    public static Component makeMazeGrid(Maze maze) {
        Display.printMazePackageToScreen(maze, 1);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(maze.getWidth(), maze.getHeight()));

        Cell[][] cellMaze = maze.getMaze();
        for (int col = 0; col < maze.getWidth(); col++) {
            for (int row = 0; row < maze.getHeight(); row++) {
                JLabel iconLabel = new JLabel();
                Cell currentCell = maze.getMaze()[row][col];
                char iconChar = MazeElements.getCellSymbol(currentCell, maze.isRevealAll());

                ImageIcon gameIcon = IconPanel.getImageIcon(iconChar);
                gameIcon = IconPanel.getScaleImageIcon(gameIcon, 45, 45);

                iconLabel.setIcon(gameIcon);
                iconLabel.setPreferredSize(new Dimension(45,45));
                iconLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                panel.add(iconLabel);


            }
        }
        panel.setBorder(BorderFactory.createLineBorder(Color.CYAN, 10));
        return panel;
    }
}
