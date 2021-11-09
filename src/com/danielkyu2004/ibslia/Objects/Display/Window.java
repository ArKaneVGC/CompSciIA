package com.danielkyu2004.ibslia.Objects.Display;

import com.danielkyu2004.ibslia.Objects.Display.Listeners.ButtonListener;
import com.danielkyu2004.ibslia.Objects.Display.Listeners.DisplayListener;
import com.danielkyu2004.ibslia.Objects.Display.Listeners.SuicideButtonListener;

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
        frameGBC.insets=new Insets(5,5,5,5);
        frameGBC.anchor = GridBagConstraints.NORTH;

        //create input panel

        makeinputPanel();
        frameGBL.setConstraints(inputPanel, frameGBC);



        //create output panel
        makeOutputPanel();
        frameGBL.setConstraints(outputPanel, frameGBC);

        frame.setSize(1000, 750);
        frame.setLayout(frameGBL);
        resizeFrame(frame);

        frame.addComponentListener(new DisplayListener());
        frame.setVisible(true);
        frame.toFront();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



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
        JLabel inTitle=new JLabel("INPUT: Type your destinations");
        inputPanelGBC.gridwidth=GridBagConstraints.REMAINDER;
        inputPanelGBL.setConstraints(inTitle,inputPanelGBC);
        inputPanel.add(inTitle);
        inputPanelGBC.gridwidth=GridBagConstraints.RELATIVE;

        inputPanel.add(label);
        inputPanel.add(input);
        inputPanelGBC.gridwidth = GridBagConstraints.REMAINDER;
        inputPanel.add(enterButton);
        frame.add(inputPanel);

        //create listener
        input.addActionListener(new ButtonListener(input));
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
        JLabel outTitle=new JLabel("OUTPUT: Click items to remove them");
        outputPanelGBC.gridwidth=GridBagConstraints.REMAINDER;
        outputPanelGBL.setConstraints(outTitle,outputPanelGBC);
        outputPanel.add(outTitle);

        outputPanelGBC.gridwidth=GridBagConstraints.RELATIVE;

        outputPanel.setLayout(outputPanelGBL);
        frame.add(outputPanel);


    }

    //output to output panel
    public void outputToPanel(String output) {
        System.out.println(output);
        JButton outputButton = new JButton(output);
        outputPanelGBL.setConstraints(outputButton, outputPanelGBC);
        outputPanel.add(outputButton);
        outputButton.addActionListener(new SuicideButtonListener(outputPanel,outputButton));
        updateFrame();
    }

    //repaint panel
    public void updateFrame(){
        frame.invalidate();
        frame.validate();
        frame.repaint();
    }

    public void resizeFrame(Component comp){
        Dimension d=new Dimension(comp.getWidth()*3/5,comp.getHeight()/3);
        outputPanel.setPreferredSize(d);
        inputPanel.setPreferredSize(d);
        updateFrame();
    }

}
