package com.danielkyu2004.ibslia.Objects.Display;

import com.danielkyu2004.ibslia.Objects.Display.Listeners.ButtonListener;

import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


//All generated with jvider
public class Window extends JFrame {

    public JPanel InputPanel;
    public JTextField tfInputField;
    public JButton InputButton;

    public JPanel OutputPanel;
    public JButton DeleteButton;
    public JList lsOutputList;
    public JButton FinalButton;

    //window constructor
    public Window()
    {
        super();
        setTitle("DayScheduler");

        GridBagLayout gbWindow = new GridBagLayout();
        GridBagConstraints gbcWindow = new GridBagConstraints();
        setLayout( gbWindow );

        InputPanel = new JPanel();
        InputPanel.setBorder( BorderFactory.createTitledBorder( "Input:" ) );
        GridBagLayout gbInputPanel = new GridBagLayout();
        GridBagConstraints gbcInputPanel = new GridBagConstraints(1,1,10,2,1,0,11,2,new Insets( 5,30,5,30 ),0,0);
        InputPanel.setLayout( gbInputPanel );

        tfInputField = new JTextField( );
        tfInputField.setMargin( new Insets( 0,50,0,50 ) );
        gbInputPanel.setConstraints( tfInputField, gbcInputPanel );
        InputPanel.add( tfInputField );

        InputButton = new JButton( "Enter"  );
        InputButton.addActionListener(new ButtonListener());
        gbcInputPanel=new GridBagConstraints(4,3,4,1,1,0,11,0,gbcInputPanel.insets,0,0);
        gbInputPanel.setConstraints( InputButton, gbcInputPanel );
        InputPanel.add( InputButton );

        gbcInputPanel=new GridBagConstraints(4,5,11,5,1,0,11,1,new Insets(0,50,0,50),0,0);
        gbWindow.setConstraints( InputPanel, gbcWindow );
        add( InputPanel );

        //outputpanel initialization
        OutputPanel = new JPanel();
        OutputPanel.setBorder( BorderFactory.createTitledBorder( "Output:" ) );
        GridBagLayout gbOutputPanel = new GridBagLayout();
        GridBagConstraints gbcOutputPanel = new GridBagConstraints(9,2,3,3,1,0,13,3,new Insets(0,0,0,50),0,0);
        OutputPanel.setLayout( gbOutputPanel );

        DeleteButton = new JButton( "Delete"  );
        DeleteButton.addActionListener( new ButtonListener() );
        gbOutputPanel.setConstraints( DeleteButton, gbcOutputPanel );
        OutputPanel.add( DeleteButton );

        lsOutputList = new JList<String>();
        gbcOutputPanel.gridx = 0;
        gbcOutputPanel.gridy = 0;
        gbcOutputPanel.gridwidth = 9;
        gbcOutputPanel.gridheight = 7;
        gbcOutputPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcOutputPanel.weightx = 1;
        gbcOutputPanel.weighty = 1;
        gbcOutputPanel.anchor = GridBagConstraints.NORTH;
        gbOutputPanel.setConstraints( lsOutputList, gbcOutputPanel );
        OutputPanel.add( lsOutputList );
        gbcWindow.gridx = 4;
        gbcWindow.gridy = 13;
        gbcWindow.gridwidth = 11;
        gbcWindow.gridheight = 5;
        gbcWindow.fill = GridBagConstraints.BOTH;
        gbcWindow.weightx = 1;
        gbcWindow.weighty = 0;
        gbcWindow.anchor = GridBagConstraints.NORTH;
        gbcWindow.insets = new Insets( 5,25,0,0 );
        gbWindow.setConstraints( OutputPanel, gbcWindow );
        add( OutputPanel );

        FinalButton = new JButton( "Complete"  );
        FinalButton.addActionListener( new ButtonListener() );
        gbcWindow.gridx = 6;
        gbcWindow.gridy = 19;
        gbcWindow.gridwidth = 7;
        gbcWindow.gridheight = 1;
        gbcWindow.fill = GridBagConstraints.VERTICAL;
        gbcWindow.weightx = 1;
        gbcWindow.weighty = 0;
        gbcWindow.anchor = GridBagConstraints.NORTH;
        gbcWindow.insets = new Insets( 30,0,30,0 );
        gbWindow.setConstraints( FinalButton, gbcWindow );
        add( FinalButton );
        this.setSize(500,500);
    }
}
