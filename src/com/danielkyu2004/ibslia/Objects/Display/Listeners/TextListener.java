package com.danielkyu2004.ibslia.Objects.Display.Listeners;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TextListener implements DocumentListener {
    public JTextField textArea;

    public TextListener(JTextField ta){
        textArea=ta;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        try {
            System.out.println(e.getDocument().getText(0,e.getDocument().getLength()));
        } catch (BadLocationException ex) {
            System.out.println("Nothing in text field");
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        try {
            System.out.println(e.getDocument().getText(0,e.getDocument().getLength()));
        } catch (BadLocationException ex) {
            System.out.println("Nothing in text field");
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        System.out.println(e.getDocument().toString());
    }
}
