package com.danielkyu2004.ibslia.Objects.Display.Extras;
import com.danielkyu2004.ibslia.Objects.Directions.InputObject;
import com.google.gson.Gson;


import java.awt.*;
import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class FileManager {
        public File file;

        public FileManager (){

        }

        public Vector<InputObject> readFile() throws IOException {
                Vector<InputObject> vec = new Vector<>();
                Scanner fileScan=new Scanner(this.file);
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

        public boolean readExplorer(int mode) throws IOException {
                FileExplorer fe=new FileExplorer(mode);

                try{
                String filePath =fe.explore();
                if(!filePath.endsWith(".json"))
                        filePath+=".json";
                file=new File(filePath);}
                catch(ArrayIndexOutOfBoundsException e){}
                return file!=null;

        }




}
