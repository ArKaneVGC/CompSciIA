package com.danielkyu2004.ibslia.Objects;

import javax.swing.*;
import java.awt.*;

public class Window {
    public JFrame frame;

    public Window(){
        frame=new JFrame();
        frame.setSize(new Dimension(500,300));
        frame.setJMenuBar(new JMenuBar());



        frame.setVisible(true);
        frame.setSize(new Dimension(300,500));

        frame.dispose();
    }
}
