package com.danielkyu2004.ibslia.Objects.Display;

import com.danielkyu2004.ibslia.Objects.Directions.InputObject;
import com.danielkyu2004.ibslia.Objects.Display.Extras.ButtonListener;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

import static com.danielkyu2004.ibslia.Main.window;


//All generated with jvider
public class Window extends JFrame {

    private GroupPanel inputPanel, outputPanel,finalPanel;
    public JTextField tfInputField;
    public JButton inputButton, deleteButton, finalButton;
    public JList<InputObject> outputList;
    public Vector<InputObject> outputVector, finalVector;
    public JComboBox<String> dropdownMenu;
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    public boolean onFirstPage, addObjects;
    private JLabel title;
    private JMenu menu;
    private JMenuBar menuBar;
    public JMenuItem saveFileItem, loadFileItem;

    //window constructor
    public Window()
    {
        //initialize variables
        super();
        outputVector=new Vector<>(); finalVector=new Vector<>();
        dropdownMenu=new JComboBox<>();
        addObjects=true;
        reinit();

        setTitle("DayScheduler");
        setLayout(gbl);
        //setup for first page
        setup();

        setFirstPage();

        onFirstPage=true;
        addObjects =false;

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500,700);
    }



    //set all constraints and listeners
    public void setup(){
        //input panel
        tfInputField.setText("Enter first item to do - Home, Hotel, etc.");
        tfInputField.addActionListener(new ButtonListener());
        inputPanel.add( tfInputField,1,0,20,1,1,0,11,2,new Insets( 5,30,5,30 ),0,0);

        inputButton.addActionListener(new ButtonListener());
        inputPanel.add(inputButton,4,3,4,1,1,0,11,0,new Insets(5,30,5,30),0,0);

        dropdownMenu.setEditable(true);
        if(addObjects) {
            dropdownMenu.addItem("Enter Starting Location");
            dropdownMenu.addActionListener(new ButtonListener());
        }

        inputPanel.add(dropdownMenu,9,3,4,1,0,0,11,1,new Insets(5,0,5,30),0,0);

        constrain(inputPanel,4,5,11,5,1,0,11,1,new Insets(0,50,0,50),0,0);

        //finalpanel initialization
        gbl.setConstraints(finalPanel,gbc);

        //outputpanel initialization

        deleteButton.addActionListener( new ButtonListener() );
        outputPanel.add(deleteButton,9,2,3,3,1,0,13,3,new Insets(0,0,0,0),0,0);

        //Outputted list
        outputList.setListData(outputVector);
        outputPanel.add(outputList,0,0,9,15,1,1,11,2,new Insets(5,0,0,0),0,0);
        if(onFirstPage) {
            finalPanel.add(outputList,0,0,9,15,1,1,11,2,new Insets(5,0,0,0),0,0);
        }



        constrain(outputPanel,4,13,11,5,1,0,11,1,new Insets(5,25,0,25),0,0);

        //final button
        finalButton.addActionListener( new ButtonListener() );
        constrain(finalButton,6,19,7,1,1,0,15,3,new Insets(30,0,30,0),0,0);

        //file button
        loadFileItem.addActionListener(new ButtonListener());
        saveFileItem.addActionListener(new ButtonListener());
        menu.add(loadFileItem);
        menu.add(saveFileItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);



        title = new JLabel( "DAY SCHEDULER"  );
        title.setFont(title.getFont().deriveFont(32.0f));
        constrain(title,5,1,9,3,1,0,11,0,new Insets(0,0,0,0),0,0);

    }


    //add components for first page
    private void setFirstPage(){

        add(inputPanel);
        add(outputPanel);
        add(finalButton);
        add(title);
        onFirstPage=true;
    }

    //add components for second page
    private void setSecondPage(){

        System.out.println(onFirstPage);
        add(finalPanel);
        add(title);
        add(finalButton);
        onFirstPage=false;
    }

    //check which page and switch to other
    public void changePage(){
        //delete page
        getContentPane().removeAll();
        addObjects=false;
        reinit();
        setup();
        addObjects=true;
        if(onFirstPage)
            setSecondPage();
        else
            setFirstPage();
        setLayout(gbl);
        refresh();
    }




    public void refresh()
    {
        revalidate();
        repaint();
    }

    //only add objects if addObjects are true for window
    @Override
    public Component add(Component a){
        if(addObjects)
            super.add(a);
        return a;
    }

    //set constraints with a separate method
    public Component constrain(Component comp, int gx, int gy, int gwidth, int gheight, double wx, double wy, int anch, int f, Insets ins, int ix, int iy){
        gbc.gridx=gx;
        gbc.gridy=gy;
        gbc.gridwidth=gwidth;
        gbc.gridheight=gheight;
        gbc.weightx=wx;
        gbc.weighty=wy;
        gbc.anchor=anch;
        gbc.fill=f;
        gbc.insets=ins;
        gbc.ipadx=ix;
        gbc.ipady=iy;
        gbl.setConstraints(comp,gbc);
        return comp;
    }

    //reinitialize
    public void reinit(){
        inputPanel=new GroupPanel("Input to do List:"); outputPanel=new GroupPanel("Output:"); finalPanel=new GroupPanel();
        tfInputField=new JTextField();
        inputButton=new JButton("Enter");
        deleteButton =new JButton("Delete");
        finalButton =new JButton("Complete");
        saveFileItem= new JMenuItem("Save");
        loadFileItem = new JMenuItem("Load");
        menu=new JMenu("File");
        menuBar=new JMenuBar();
        outputList=new JList<>();
        gbl=new GridBagLayout();
        gbc=new GridBagConstraints();
    }

    //add an input object with task t and location l to output
    public void addToOutput(String t, String l){
        outputVector.add(new InputObject(t,l));
        boolean contains=false;
        for(int i=0;i<dropdownMenu.getItemCount()&&!contains;i++)
            contains= dropdownMenu.getItemAt(i).trim().equalsIgnoreCase(l.trim());
        if(!contains)
            dropdownMenu.addItem(l);
        dropdownMenu.setSelectedItem(l);
        outputList.setListData(window.outputVector);
        tfInputField.setText("");
        refresh();
    }
}
