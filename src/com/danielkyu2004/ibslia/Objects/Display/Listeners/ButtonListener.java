package com.danielkyu2004.ibslia.Objects.Display.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import static com.danielkyu2004.ibslia.Main.window;

public class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed( ActionEvent e )
    {
        //input button
        if ( e.getSource() == window.inputButton)
            addToOutput(window.tfInputField.getText());


        //delete from output button
        if ( e.getSource() == window.DeleteButton )
        {
            List<String> toDelete=window.lsOutputList.getSelectedValuesList();
            for(String str:toDelete){
                window.outputVector.remove(str);
            }
            window.lsOutputList.setListData(window.outputVector);
            window.refresh();
        }

        if ( e.getSource() == window.FinalButton )
        {
            // Action for FinalButton
        }

        //enter on text field button
        if(e.getSource()==window.tfInputField){
            addToOutput(e.getActionCommand());
        }
    }

    public static void addToOutput(String str){
        window.outputVector.add(str);
        window.lsOutputList.setListData(window.outputVector);
        window.tfInputField.setText("");
        window.refresh();
    }
}
