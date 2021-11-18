package com.danielkyu2004.ibslia;


import com.danielkyu2004.ibslia.Objects.Color.ColorObject;
import com.danielkyu2004.ibslia.Objects.Color.ColorRequest;
import com.danielkyu2004.ibslia.Objects.Directions.DirectionsConnection;
import com.danielkyu2004.ibslia.Objects.Display.Window;
import com.google.gson.Gson;

import java.io.*;
import java.net.*;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Window window;
    public static void main(String[] args) throws IOException {
//        String baseURL= "https://www.googleapis.com/calendar/v3";
//        URL url =new URL(baseURL+"/colors?key="+API_KEY);
//        HttpURLConnection con = (HttpURLConnection)url.openConnection();
//        con.setRequestMethod("GET");
//        Gson gson=new Gson();
//
//        Scanner s=new Scanner(con.getInputStream());
//        StringBuilder sb=new StringBuilder();
//        while(s.hasNextLine())
//            sb.append(s.nextLine());
//        ColorRequest cr=gson.fromJson(sb.toString(), ColorRequest.class);
//        System.out.println(cr);

        window =new Window();
        window.setVisible(true);
        DirectionsConnection dc=new DirectionsConnection();

    }
}
