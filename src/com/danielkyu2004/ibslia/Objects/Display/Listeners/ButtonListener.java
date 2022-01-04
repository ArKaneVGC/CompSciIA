package com.danielkyu2004.ibslia.Objects.Display.Listeners;

import com.danielkyu2004.ibslia.Objects.Directions.InputObject;
import org.apache.commons.lang3.StringUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import static com.danielkyu2004.ibslia.Main.window;

public class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed( ActionEvent e )
    {
        Object s=e.getSource();
        //input button
        if ( s == window.inputButton||s== window.tfInputField||s==window.dropdownMenu)
            if(!window.tfInputField.getText().isEmpty())
            addToOutput(StringUtils.normalizeSpace(window.tfInputField.getText()), Objects.requireNonNull(StringUtils.normalizeSpace((String) window.dropdownMenu.getSelectedItem())));


        //delete from output button
        if ( s == window.DeleteButton )
        {
            List<InputObject> toDelete=window.lsOutputList.getSelectedValuesList();
            for(InputObject io:toDelete){
                window.outputVector.remove(io);
            }
            window.lsOutputList.setListData(window.outputVector);
            window.refresh();
        }

        if ( s == window.FinalButton )
        {
            // Action for FinalButton
        }
    }

    public static void addToOutput(String t, String l){
        window.outputVector.add(new InputObject(t,l));
        boolean contains=false;
        for(int i=0;i<window.dropdownMenu.getItemCount()&&!contains;i++)
            contains= window.dropdownMenu.getItemAt(i).trim().equalsIgnoreCase(l.trim());
        if(!contains)
            window.dropdownMenu.addItem(l);
        window.lsOutputList.setListData(window.outputVector);
        window.tfInputField.setText("");
        window.refresh();
    }
}
