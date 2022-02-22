package com.danielkyu2004.ibslia.Objects.Display.Extras;
import com.danielkyu2004.ibslia.Objects.Directions.InputObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.awt.*;
import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class FileManager {
        public File file;
        public final static String fileExt=".json";

        public FileManager (){

        }


        public File createFile(Vector<InputObject> vec) throws IOException{
                File newFile=new File(file.getPath());
                FileWriter fw=new FileWriter(newFile);
                Gson gson =new Gson();
                fw.append(gson.toJson(vec));
                fw.flush();
                return newFile;

        }

        public Vector<InputObject> readFile() throws IOException {
                Vector<InputObject> vec;
                Scanner fileScan=new Scanner(this.file);
                Gson gson=new Gson();
                vec=gson.fromJson(fileScan.nextLine(),new TypeToken<Vector<InputObject>>(){}.getType());
                return vec;

        }



        public boolean readExplorer(int mode) throws IOException {
                FileExplorer fe=new FileExplorer(mode);

                try{
                String filePath =fe.explore();
                if(!filePath.endsWith(fileExt))
                        filePath+=fileExt;
                file=new File(filePath);}
                catch(ArrayIndexOutOfBoundsException e){}
                return file!=null;

        }




}
