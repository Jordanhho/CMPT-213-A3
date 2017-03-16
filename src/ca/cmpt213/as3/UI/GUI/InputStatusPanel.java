package ca.cmpt213.as3.UI.GUI;

import ca.cmpt213.as3.UI.INPUT.UserInput;

import javax.swing.*;

/**
 * Created by Nova on 10/03/2017.
 */
public class InputStatusPanel extends JPanel {

    private JLabel statusText;

    public InputStatusPanel() {
        this.add(new JLabel("Enter a key"));
        UserInput.registerKey(statusText);
    }

}
