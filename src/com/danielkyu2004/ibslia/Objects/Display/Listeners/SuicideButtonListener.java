package com.danielkyu2004.ibslia.Objects.Display.Listeners;

import com.danielkyu2004.ibslia.Main;
import com.danielkyu2004.ibslia.Objects.Display.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuicideButtonListener implements ActionListener {
    JPanel panel;
    Component source;

    public SuicideButtonListener(JPanel panel, Component source){
        this.panel=panel;
        this.source=source;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.remove(source);
        Main.window.updateFrame();
    }
}
