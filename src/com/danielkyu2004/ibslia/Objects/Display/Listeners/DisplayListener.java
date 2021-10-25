package com.danielkyu2004.ibslia.Objects.Display.Listeners;

import java.awt.event.*;

public class DisplayListener implements WindowListener {
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        e.getWindow().dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("helo");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("goodbye");
    }
}
