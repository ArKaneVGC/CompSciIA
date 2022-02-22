package com.danielkyu2004.ibslia.Objects.Display.Extras;

import com.danielkyu2004.ibslia.Objects.Directions.DirectionCall;
import com.danielkyu2004.ibslia.Objects.Directions.DirectionsConnection;
import com.danielkyu2004.ibslia.Objects.Directions.InputObject;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

import static com.danielkyu2004.ibslia.Main.window;

public class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object s=e.getSource();
        System.out.println(e.getActionCommand());
        //input button
        if ( s == window.inputButton||s== window.tfInputField||(s==window.dropdownMenu&& !Objects.equals(e.getActionCommand(), "comboBoxChanged")))
            if(!window.tfInputField.getText().isEmpty())
            window.addToOutput(StringUtils.normalizeSpace(window.tfInputField.getText()), Objects.requireNonNull(StringUtils.normalizeSpace((String) window.dropdownMenu.getSelectedItem())));


        //delete from output button
        if ( s == window.deleteButton)
        {
            List<InputObject> toDelete=window.outputList.getSelectedValuesList();
            for(InputObject io:toDelete){
                window.outputVector.remove(io);
            }
            window.outputList.setListData(window.outputVector);
            window.refresh();
        }

        if ( s == window.finalButton)
        {
            DirectionCall call=null;
            if(window.onFirstPage) {
                DirectionsConnection dirCon = new DirectionsConnection();
                try {
                    dirCon.addWaypoints(dirCon.findPlaceIDs(window.outputVector));
                    dirCon.addOrigin(window.outputVector.get(0));

                    call=dirCon.getRoute();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            sort(call, window.onFirstPage, window.outputVector);
            window.changePage();

        }

        if(s== window.saveFileItem){
            FileManager fm=new FileManager();
            try {
                if(fm.readExplorer(FileDialog.SAVE))
                    fm.createFile(window.outputVector);

            } catch (IOException ex) {JOptionPane.showMessageDialog(window, "Error has occurred.");}
        }

        if(s== window.loadFileItem){
            FileManager fm=new FileManager();
            try {
                if(fm.readExplorer(FileDialog.LOAD))
                    window.outputVector=fm.readFile();
                    window.outputList.setListData(window.outputVector);
                    window.refresh();}
            catch (IOException ex) {JOptionPane.showMessageDialog(window, "Error has occurred.");}
        }
    }



    public static void sort(DirectionCall dirCall, boolean firstPage, Vector<InputObject> vec){
        Vector<InputObject> outVec=new Vector<>();
        outVec.add(vec.get(0));
        if(firstPage)
            for (int i = 0; i < dirCall.routes[0].waypoint_order.length; i++)
                outVec.add(vec.get(dirCall.routes[0].waypoint_order[i]+1));
            window.outputVector=outVec;
    }

}
