package com.danielkyu2004.ibslia;


import com.danielkyu2004.ibslia.Objects.Directions.DirectionsConnection;
import com.danielkyu2004.ibslia.Objects.Display.Window;
import com.google.gson.Gson;

import java.io.*;
import java.net.*;


public class Main {
    public static Window window;

    //create window
    public static void main(String[] args) {
        window =new Window();
        window.setVisible(true);
    }
}
