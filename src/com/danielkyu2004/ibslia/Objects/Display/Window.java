package com.danielkyu2004.ibslia.Objects.Display;

import com.danielkyu2004.ibslia.Objects.Display.Listeners.ButtonListener;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;


//All generated with jvider
public class Window extends JFrame {

    public JPanel inputPanel, outputPanel;
    public JTextField tfInputField;
    public JButton inputButton;

    public JButton DeleteButton;
    public JList<String> lsOutputList;
    public Vector<String> outputVector;
    public JButton FinalButton;

    //window constructor
    public Window()
    {
        super();
        setTitle("DayScheduler");

        GridBagLayout gbWindow = new GridBagLayout();
        GridBagConstraints gbcWindow = new GridBagConstraints();
        setLayout( gbWindow );


        //input panel
        inputPanel = new JPanel();
        inputPanel.setBorder( BorderFactory.createTitledBorder( "Input:" ) );
        GridBagLayout gbInputPanel = new GridBagLayout();
        GridBagConstraints gbcInputPanel = new GridBagConstraints(1,1,10,2,1,0,11,2,new Insets( 5,30,5,30 ),0,0);
        inputPanel.setLayout( gbInputPanel );

        tfInputField = new JTextField( );
        tfInputField.addActionListener(new ButtonListener());
        gbInputPanel.setConstraints( tfInputField, gbcInputPanel );
        inputPanel.add( tfInputField );

        inputButton = new JButton( "Enter"  );
        inputButton.addActionListener(new ButtonListener());
        gbcInputPanel=new GridBagConstraints(4,3,4,1,1,0,11,0,gbcInputPanel.insets,0,0);
        gbInputPanel.setConstraints(inputButton, gbcInputPanel );
        inputPanel.add(inputButton);

        gbcWindow=new GridBagConstraints(4,5,11,5,1,0,11,1,new Insets(0,50,0,50),0,0);
        gbWindow.setConstraints(inputPanel, gbcWindow );
        add(inputPanel);

        //outputpanel initialization
        outputPanel = new JPanel();
        outputPanel.setBorder( BorderFactory.createTitledBorder( "Output:" ) );
        GridBagLayout gblOutputPanel = new GridBagLayout();

        GridBagConstraints gbcOutputPanel = new GridBagConstraints(9,2,3,3,1,0,13,3,new Insets(0,0,0,0),0,0);
        outputPanel.setLayout( gblOutputPanel );
        DeleteButton = new JButton( "Delete"  );
        DeleteButton.addActionListener( new ButtonListener() );
        gblOutputPanel.setConstraints( DeleteButton, gbcOutputPanel );
        outputPanel.add( DeleteButton );

        //Outputted list
        lsOutputList = new JList<>();
        outputVector=new Vector<>();
        gbcOutputPanel=new GridBagConstraints(0,0,9,15,1,1,11,2,new Insets(5,0,0,0),0,0);
        gblOutputPanel.setConstraints( lsOutputList, gbcOutputPanel );
        outputPanel.add( lsOutputList );


        gbcWindow=new GridBagConstraints(4,13,11,5,1,0,11,1,new Insets(5,25,0,25),0,0);
        gbWindow.setConstraints(outputPanel, gbcWindow );
        add(outputPanel);


        //final button
        FinalButton = new JButton( "Complete"  );
        FinalButton.addActionListener( new ButtonListener() );
        gbcWindow=new GridBagConstraints(6,19,7,1,1,0,15,3,new Insets(30,0,30,0),0,0);
        gbWindow.setConstraints( FinalButton, gbcWindow );
        add( FinalButton );

        JLabel title = new JLabel( "DAY SCHEDULER"  );
        title.setFont(title.getFont().deriveFont(32.0f));
        gbcWindow=new GridBagConstraints(5,1,9,3,1,0,11,0,new Insets(0,0,0,0),0,0);
        gbWindow.setConstraints( title, gbcWindow );
        add( title );

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500,700);
    }

    public void refresh(){
        invalidate();
        validate();
        repaint();
    }
}
