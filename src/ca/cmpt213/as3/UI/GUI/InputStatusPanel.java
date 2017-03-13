package ca.cmpt213.as3.UI.GUI;

import ca.cmpt213.as3.UI.INPUT.UserInput;

import javax.swing.*;

/**
 * Created by Nova on 10/03/2017.
 */
public class InputStatusPanel extends JPanel {

    private JLabel statusText;

    public InputStatusPanel() {
        add(statusText = new JLabel("Enter a key"));
        //statusText.setText("Enter a key");
        //setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        UserInput.registerKey(statusText);
        //add(statusText = new JLabel());
        //System.out.println("The input is: " + );


        //registerAsOvserver();
       //setPreferredSize(new Dimension(200, 200));
        //updateStatus();
    }


    /*
    private void registerAsObserver() {
        model.addObserver(
                () -> updateStatus());
    }

    private void updateStatus() {


        if (model.size() > 0) {
            min.setText("Min: " + model.min());
            max.setText("Max: " + model.max());
        } else {
            min.setText("Min: ---");
            max.setText("Max: ---");
        }
        sum.setText("Sum: " + model.sum());
        size.setText("Size: " + model.size());
    }
    */


}
