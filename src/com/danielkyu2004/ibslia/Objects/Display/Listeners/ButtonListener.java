package com.danielkyu2004.ibslia.Objects.Display.Listeners;

import com.danielkyu2004.ibslia.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    public JTextField textField;

    public ButtonListener(JTextField tf){
        textField=tf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(textField.getText());
        Main.window.outputToPanel(textField.getText());
        textField.setText("");
    }
}
