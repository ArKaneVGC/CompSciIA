package com.danielkyu2004.ibslia.Objects.Display.Listeners;
import com.danielkyu2004.ibslia.Objects.Directions.InputObject;
import com.google.gson.Gson;


import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class FileManager {
        public File file;

        public FileManager (File f){
                file=f;
        }

        public Vector<InputObject> readFile() throws IOException {
                Vector<InputObject> vec = new Vector<>();
                Scanner fileScan=new Scanner(this.file);
                StringBuilder fileString=new StringBuilder();
                Gson gson=new Gson();
                while(fileScan.hasNextLine())
                        vec.add(gson.fromJson(fileScan.nextLine(),InputObject.class));
                for(int i=0;i<vec.size();i++)
                        System.out.println(vec.get(i));
                return vec;

        }

        public File createFile(Vector<InputObject> vec) throws IOException{
                File newFile=new File(file.getPath());
                FileWriter fw=new FileWriter(newFile);
                Gson gson =new Gson();
                for(int i=0;i<vec.size();i++)
                        fw.append(gson.toJson(vec.get(i))).append("\n");
                fw.flush();
                return newFile;

        }




}
