package com.danielkyu2004.ibslia.Objects.Display;

import com.danielkyu2004.ibslia.Objects.Display.Listeners.ButtonListener;
import com.danielkyu2004.ibslia.Objects.Display.Listeners.DisplayListener;
import com.danielkyu2004.ibslia.Objects.Display.Listeners.TextListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Window {
    public JFrame frame;
    public JMenuBar menuBar;
    public JMenu menu1;

    public Window(){
        frame=new JFrame("frame title");
        GridBagLayout gbl=new GridBagLayout();
        GridBagConstraints gbc=new GridBagConstraints();

        for(int i=1; i<=50;i++) {
            JButton button = new JButton("butt: " + i);
            gbl.setConstraints(button, gbc);
            button.setBorder(new LineBorder(Color.RED));
            frame.add(button);
            if(i%10==0)
                gbc.gridwidth=GridBagConstraints.REMAINDER;
            else
                gbc.gridwidth=GridBagConstraints.RELATIVE;

        }
        frame.setLayout(gbl);
        frame.setSize(500,500);

//        JTextField input=new JTextField(5);
//        gbl.setConstraints(input,gbc);
//        frame.add(input);
//        input.getDocument().addDocumentListener(new TextListener(input));
//        input.setText("hi");
//        input.setBorder(new LineBorder(Color.RED));


        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.addWindowListener(new DisplayListener());



    }
}
