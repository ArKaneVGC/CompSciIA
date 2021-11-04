package com.danielkyu2004.ibslia.Objects.Display;

import com.danielkyu2004.ibslia.Objects.Display.Listeners.ButtonListener;
import com.danielkyu2004.ibslia.Objects.Display.Listeners.DisplayListener;
import com.danielkyu2004.ibslia.Objects.Display.Listeners.TextListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Window {
    public JFrame frame;
    public JPanel inputPanel;
    public JPanel outputPanel;

    //GBLs and GBCs
    public GridBagLayout frameGBL, inputPanelGBL, outputPanelGBL;
    public GridBagConstraints frameGBC, inputPanelGBC, outputPanelGBC;

    public Window() {
        //initialize variables
        frame = new JFrame("Day Planner");
        frameGBL = new GridBagLayout();
        frameGBC = new GridBagConstraints();

        //set GridBagConstraints
        frameGBC.gridy = GridBagConstraints.RELATIVE;
        frameGBC.gridwidth=GridBagConstraints.REMAINDER;
        frameGBC.ipady = 30;
        frameGBC.ipadx=60;
        frameGBC.anchor = GridBagConstraints.NORTH;

        //create input panel
        makeinputPanel();
        frameGBL.setConstraints(inputPanel, frameGBC);



        //create output panel
        makeOutputPanel();
        frameGBL.setConstraints(outputPanel, frameGBC);

        frame.setSize(500, 500);
        frame.setLayout(frameGBL);


        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.addWindowListener(new DisplayListener());


    }

    //initialize inputPanel
    public void makeinputPanel() {
        //initialize
        inputPanel = new JPanel();
        inputPanel.setBorder(new LineBorder(Color.BLACK));
        inputPanelGBL = new GridBagLayout();
        inputPanelGBC = new GridBagConstraints();


        //set gridbagconstraints
        inputPanelGBC.gridx = GridBagConstraints.RELATIVE;
        inputPanelGBC.weighty = 3;
        inputPanelGBC.ipadx = 10;
        inputPanelGBC.anchor = GridBagConstraints.CENTER;

        //initialize enter button
        inputPanelGBC.weightx = 0.25;
        JButton enterButton = new JButton("Enter");
        inputPanelGBL.setConstraints(enterButton, inputPanelGBC);

        //initialize input field
        inputPanelGBC.weightx = 0.6;
        JTextField input = new JTextField();
        input.setPreferredSize(new Dimension(300, 25));
        inputPanelGBL.setConstraints(input, inputPanelGBC);

        //initialize label
        inputPanelGBC.weightx = 0.15;
        JLabel label = new JLabel("Input: ");
        inputPanelGBL.setConstraints(label, inputPanelGBC);


        //add to panel
        inputPanel.add(label);
        inputPanel.add(input);
        inputPanelGBC.gridwidth = GridBagConstraints.REMAINDER;
        inputPanel.add(enterButton);
        frame.add(inputPanel);

        //create listener
        enterButton.addActionListener(new ButtonListener(input));


        input.setBorder(new LineBorder(Color.GRAY));
        inputPanel.setPreferredSize(new Dimension(500, 100));
        inputPanel.setLayout(inputPanelGBL);

    }

    //output panel
    public void makeOutputPanel() {
        //initialize
        outputPanel = new JPanel();
        outputPanel.setBorder(new LineBorder(Color.BLACK));
        outputPanelGBL = new GridBagLayout();
        outputPanelGBC = new GridBagConstraints();

        //set gridbagconstraints
        outputPanelGBC.gridy = GridBagConstraints.RELATIVE;
        outputPanelGBC.weighty = 3;
        outputPanelGBC.ipadx = 10;
        outputPanelGBC.anchor = GridBagConstraints.CENTER;


        //use variables
        outputPanel.setPreferredSize(new Dimension(400, 100));
        outputPanel.setLayout(outputPanelGBL);
        frame.add(outputPanel);


    }

    //output to output panel
    public void outputToPanel(String output) {
        System.out.println(output);
        JLabel outputLabel = new JLabel(output);
        outputPanelGBL.setConstraints(outputLabel, outputPanelGBC);
        outputPanel.add(outputLabel);

        frame.invalidate();
        frame.validate();
        frame.repaint();

    }
}
