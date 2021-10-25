package com.danielkyu2004.ibslia.Objects.Display;

import com.danielkyu2004.ibslia.Objects.Display.Listeners.DisplayListener;

import javax.swing.*;
import java.awt.*;

public class Window {
    public JFrame frame;
    public JMenuBar menuBar;
    public JMenu menu1;

    public Window(){
        frame=new JFrame("frame title");
        menuBar=new JMenuBar();
        menu1=new JMenu("menu name");
        Button butt = new Button();
        butt.setLabel("butt");
        butt.setVisible(true);
        menu1.add(butt);
        menu1.setText("BUUUTTT");
        menu1.setName("bUUTt");
        menuBar.add(menu1);
        menuBar.setVisible(true);
        menu1.setVisible(true);
        frame.addWindowListener(new DisplayListener());
        frame.setSize(new Dimension(500,300));
        frame.setJMenuBar(menuBar);



        frame.setVisible(true);
    }
}
