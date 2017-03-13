package ca.cmpt213.as3.UI.GUI;

import ca.cmpt213.as3.MazeGame.Maze;
import ca.cmpt213.as3.MazeGame.ValidInput;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nova on 13/03/2017.
 */
public class ButtonPanel extends JPanel {

    public ButtonPanel(ValidInput function, Maze maze) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setPreferredSize(new Dimension(100, 100));
        JButton addBtn;
        switch (function) {
            case MAP:
                addBtn = new JButton("Toggle Map");
                addBtn.addActionListener(
                        event -> maze.setRevealAll(!maze.isRevealAll()));
                add(addBtn);
                break;

                /*
            case HELP:
                addBtn = new JButton("Help?");
                addBtn.addActionListener(
                        event -> ;
                add(addBtn);
                break;
                */
            default:

        }
    }





}
