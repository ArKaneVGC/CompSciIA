package com.danielkyu2004.ibslia.Objects.Display.Extras;

import javax.swing.JFrame;
import java.awt.*;
import java.io.*;

import static com.danielkyu2004.ibslia.Objects.Display.Extras.FileManager.fileExt;


public class FileExplorer{
    private FileDialog fd;

    //initialize file explorer with default json file
    public FileExplorer(int mode){
        fd=new FileDialog(new JFrame());
        fd.setFile("*"+fileExt);
        fd.setMode(mode);

    }

    //open file explorer and return path to file
    public String explore(){
        fd.setVisible(true);
        return fd.getFiles()[0].getAbsolutePath();
    }

}
