package com.danielkyu2004.ibslia.Objects.Display.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.danielkyu2004.ibslia.Main.*;

import static com.danielkyu2004.ibslia.Main.window;

public class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed( ActionEvent e )
    {
        if ( e.getSource() == window.InputButton )
        {
            // Action for InputButton
        }
        if ( e.getSource() == window.DeleteButton )
        {
            // Action for DeleteButton
        }
        if ( e.getSource() == window.FinalButton )
        {
            // Action for FinalButton
        }
    }
}
