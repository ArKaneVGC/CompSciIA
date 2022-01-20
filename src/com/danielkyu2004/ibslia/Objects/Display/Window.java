package com.danielkyu2004.ibslia.Objects.Display;

import com.danielkyu2004.ibslia.Objects.Directions.DirectionCall;
import com.danielkyu2004.ibslia.Objects.Directions.InputObject;
import com.danielkyu2004.ibslia.Objects.Display.Listeners.ButtonListener;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;


//All generated with jvider
public class Window extends JFrame {

    public JPanel inputPanel, outputPanel,finalPanel;
    public JTextField tfInputField;
    public JButton inputButton, deleteButton, finalButton;
    public JList<InputObject> outputList;
    public Vector<InputObject> outputVector, finalVector;
    public DirectionCall apiRequest;
    public JComboBox<String> dropdownMenu;
    public GridBagLayout gbWindow;
    public GridBagConstraints gbcWindow;
    public boolean onFirstPage, addObjects;
    public JLabel title;

    //window constructor
    public Window()
    {
        //initialize variables
        super();
        outputVector=new Vector<>(); finalVector=new Vector<>();
        apiRequest=new DirectionCall();
        dropdownMenu=new JComboBox<>();
        addObjects=true;
        reinit();

        setTitle("DayScheduler");
        setLayout( gbWindow );

        //setup for first page
        setup();
        setFirstPage();
        onFirstPage=true;
        addObjects =false;



        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500,700);
    }


    public void setup(){
        //input panel
        inputPanel.setBorder( BorderFactory.createTitledBorder( "Input to do list:" ) );
        GridBagLayout gbInputPanel = new GridBagLayout();
        GridBagConstraints gbcInputPanel = new GridBagConstraints(1,0,20,1,1,0,11,2,new Insets( 5,30,5,30 ),0,0);
        inputPanel.setLayout( gbInputPanel );

        tfInputField.setText("Enter first item to do");
        tfInputField.addActionListener(new ButtonListener());
        gbInputPanel.setConstraints( tfInputField, gbcInputPanel );
        inputPanel.add( tfInputField );

        inputButton.addActionListener(new ButtonListener());
        gbcInputPanel=new GridBagConstraints(4,3,4,1,1,0,11,0,new Insets(5,30,5,30),0,0);
        gbInputPanel.setConstraints(inputButton, gbcInputPanel );
        inputPanel.add(inputButton);

        dropdownMenu.setEditable(true);
        gbcInputPanel=new GridBagConstraints(9,3,4,1,0,0,11,1,new Insets(5,0,5,30),0,0);
        gbInputPanel.setConstraints(dropdownMenu, gbcInputPanel );
        if(addObjects) {
            dropdownMenu.addItem("Enter Starting Location");
            dropdownMenu.addActionListener(new ButtonListener());
        }

        inputPanel.add(dropdownMenu);

        gbcWindow=new GridBagConstraints(4,5,11,5,1,0,11,1,new Insets(0,50,0,50),0,0);
        gbWindow.setConstraints(inputPanel, gbcWindow );

        //finalpanel initialization
        gbWindow.setConstraints(finalPanel,gbcWindow);
        finalPanel.add(outputList);

        //outputpanel initialization
        outputPanel.setBorder( BorderFactory.createTitledBorder( "Output:" ) );
        GridBagLayout gblOutputPanel = new GridBagLayout();

        GridBagConstraints gbcOutputPanel = new GridBagConstraints(9,2,3,3,1,0,13,3,new Insets(0,0,0,0),0,0);
        outputPanel.setLayout( gblOutputPanel );
        deleteButton.addActionListener( new ButtonListener() );
        gblOutputPanel.setConstraints(deleteButton, gbcOutputPanel );
        outputPanel.add(deleteButton);

        //Outputted list
        outputList.setListData(outputVector);
        gbcOutputPanel=new GridBagConstraints(0,0,9,15,1,1,11,2,new Insets(5,0,0,0),0,0);
        gblOutputPanel.setConstraints( outputList, gbcOutputPanel );
        outputPanel.add( outputList );


        gbcWindow=new GridBagConstraints(4,13,11,5,1,0,11,1,new Insets(5,25,0,25),0,0);
        gbWindow.setConstraints(outputPanel, gbcWindow );

        //final button
        finalButton.addActionListener( new ButtonListener() );
        gbcWindow=new GridBagConstraints(6,19,7,1,1,0,15,3,new Insets(30,0,30,0),0,0);
        gbWindow.setConstraints(finalButton, gbcWindow );

        title = new JLabel( "DAY SCHEDULER"  );
        title.setFont(title.getFont().deriveFont(32.0f));
        gbcWindow=new GridBagConstraints(5,1,9,3,1,0,11,0,new Insets(0,0,0,0),0,0);
        gbWindow.setConstraints( title, gbcWindow );

    }

    public void setFirstPage(){

        add(inputPanel);
        add(outputPanel);
        add(finalButton);
        add(title);
        onFirstPage=true;
    }

    public void setSecondPage(){

        System.out.println(onFirstPage);
        add(finalPanel);
        add(title);
        add(finalButton);
        onFirstPage=false;
    }

    public void changePage(){
        System.out.println(onFirstPage);
        getContentPane().removeAll();
        addObjects=false;
        reinit();
        setup();
        addObjects=true;
        if(onFirstPage)
            setSecondPage();
        else
            setFirstPage();
        setLayout(gbWindow);
        refresh();
    }




    public void refresh()
    {        System.out.println("hi");

        revalidate();
        repaint();
    }

    @Override
    public  Component add(Component a){
        if(addObjects)
            super.add(a);
        return a;
    }

    public void reinit(){
        inputPanel=new JPanel(); outputPanel=new JPanel(); finalPanel=new JPanel();
        tfInputField=new JTextField();
        inputButton=new JButton("Enter");
        deleteButton =new JButton("Delete");finalButton =new JButton("Complete");
        outputList=new JList<>();
        gbWindow=new GridBagLayout();
        gbcWindow=new GridBagConstraints();
        //only add components on first time setup

    }
}
