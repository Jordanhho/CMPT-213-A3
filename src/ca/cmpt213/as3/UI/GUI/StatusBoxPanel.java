package ca.cmpt213.as3.UI.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nova on 13/03/2017.
 */
public class StatusBoxPanel extends JPanel {
    private static JLabel statusBox = new JLabel("Status", SwingConstants.CENTER);

    /*
    public StatusBoxPanel() {
        statusBox = new JLabel("Status", SwingConstants.CENTER);
    }
*/


    public static Component getStatusBoxPanel() {
        statusBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        statusBox.setBackground(Color.WHITE);
        return statusBox;
    }

    public static void setStatusBoxText(String text) {
        statusBox.setText(text);
    }
}

