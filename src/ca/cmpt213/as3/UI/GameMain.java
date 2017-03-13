package ca.cmpt213.as3.UI;

import ca.cmpt213.as3.MazeGame.Maze;
import ca.cmpt213.as3.MazeGame.MazeFactory;
import ca.cmpt213.as3.MazeGame.ValidInput;
import ca.cmpt213.as3.UI.GUI.ButtonPanel;
import ca.cmpt213.as3.UI.GUI.GameGrid;
import ca.cmpt213.as3.UI.GUI.InputStatusPanel;
import ca.cmpt213.as3.UI.GUI.StatusBoxPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nova on 11/03/2017.
 */
public class GameMain {
    //Game settings
    private static int numCheese = 5;
    private static int cellRadiusView = 1;
    private static int mazeDifficulty = 155; //the lower the harder: between 0 to 266
    private static int maxCheese = 100;
    private static int maxDifficulty = 100;

    private static void setNumCheese(int numCheese) {
        GameMain.numCheese = numCheese;
    }

    private static void setMazeDifficulty(int mazeDifficultyNew) {
        mazeDifficulty = Math.round(266 * ((float) (100 - mazeDifficultyNew) / 100));
    }

    private static boolean increaseCellRadiusView() {
        if (cellRadiusView == 100) {
            return false;
        } else {
            cellRadiusView = cellRadiusView + 1;
            return true;
        }
    }

    private static boolean decreaseCellRadiusView() {
        if (cellRadiusView == 0) {
            return false;
        } else {
            cellRadiusView = cellRadiusView - 1;
            return true;
        }
    }

    public GameMain() {
        Maze maze = MazeFactory.makeDefaultMaze(cellRadiusView, mazeDifficulty);
        JFrame gameFrame = new JFrame();
        gameFrame.setLayout(new BorderLayout());
        gameFrame.add(new JLabel("Maze", SwingConstants.CENTER), BorderLayout.NORTH);
        gameFrame.add(GameGrid.makeMazeGrid(maze), BorderLayout.CENTER);

        //Adding a frame to south
        JFrame statusFrame = new JFrame();
        gameFrame.add(statusFrame, BorderLayout.SOUTH);
        statusFrame.add(new InputStatusPanel(), BorderLayout.NORTH);
        statusFrame.add(StatusBoxPanel.getStatusBoxPanel(), BorderLayout.CENTER);
        statusFrame.add(new ButtonPanel(ValidInput.MAP, maze), BorderLayout.SOUTH);




        //frame.add(new InputStatusPanel(), BorderLayout.SOUTH);
        //frame.add(StatusBoxPanel.getStatusBoxPanel(), BorderLayout.SOUTH);

        statusFrame.pack();
        statusFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        statusFrame.setVisible(true);

        gameFrame.pack();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new GameMain();
    }

}
