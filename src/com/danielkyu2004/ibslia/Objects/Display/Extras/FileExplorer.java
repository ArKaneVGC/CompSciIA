package com.danielkyu2004.ibslia.Objects.Display.Extras;

import javax.swing.JFrame;
import java.awt.*;
import java.io.*;


public class FileExplorer{
    private FileDialog fd;

    public FileExplorer(int mode){
        fd=new FileDialog(new JFrame());
        fd.setFile("*.json");
        fd.setMode(mode);

    }

    public String explore(){
        fd.setVisible(true);
        return fd.getFiles()[0].getAbsolutePath();
    }

}
