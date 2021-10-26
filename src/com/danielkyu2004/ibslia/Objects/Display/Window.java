package com.danielkyu2004.ibslia.Objects.Display;

import com.danielkyu2004.ibslia.Objects.Display.Listeners.ButtonListener;
import com.danielkyu2004.ibslia.Objects.Display.Listeners.DisplayListener;

import javax.swing.*;
import java.awt.*;

public class Window {
    public JFrame frame;
    public JMenuBar menuBar;
    public JMenu menu1;

    public Window(){
        frame=new JFrame("frame title");
        frame.setSize(500,500);
        JMenu butt= new JMenu("UwU butt OwO");
        JMenuBar menu =new JMenuBar();
        menu.add(butt);
        menu.setVisible(true);
        frame.add(menu);
        butt.setVisible(true);

        butt.addActionListener(new ButtonListener());
        frame.addWindowListener(new DisplayListener());



        frame.setVisible(true);
    }
}
