package com.danielkyu2004.ibslia.Objects.Display;

import com.danielkyu2004.ibslia.Objects.Display.Listeners.ButtonListener;
import com.danielkyu2004.ibslia.Objects.Display.Listeners.DisplayListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Window {
    public JFrame frame;
    public JMenuBar menuBar;
    public JMenu menu1;

    public Window(){
        frame=new JFrame("frame title");
        
        frame.setSize(500,500);
        JMenu menu1=new JMenu("menu1");
        JMenu menu2=new JMenu("menu2");
        JMenu menu3=new JMenu("menu3");
        GridLayout gL=new GridLayout(3,3);
        frame.setLayout(gL);
        JMenuBar mb =new JMenuBar();
        JTextField tf=new JTextField(3);
        mb.setSize(mb.getWidth(),15);
        mb.add(menu1);
        mb.add(menu2);
        for(int i=0;i<5;i++) {
            menu1.add(new JMenuItem("menu item " + (i+1)));
            menu2.add(new JMenuItem("menu item " + (i+1)));
            menu3.add(new JMenuItem("menu item " + (i+1)));
        }

        tf.setBorder(new LineBorder(Color.BLUE));
        frame.add(new Button());
        frame.add(new Button());
        frame.add(new Button()); 
        frame.add(tf);
        frame.add(new Button());
        frame.add(new Button());
        frame.add(new Button());
        frame.add(new Button());
        frame.add(new Button());

        menu2.add(menu3);
        mb.setVisible(true);
        mb.setName("MenuBar");
        frame.setJMenuBar(mb);

        
        menu1.addActionListener(new ButtonListener());
        menu2.addActionListener(new ButtonListener());
        menu3.addActionListener(new ButtonListener());
        tf.addActionListener(new ButtonListener());
        frame.addWindowListener(new DisplayListener());



        frame.setVisible(true);
    }
}
