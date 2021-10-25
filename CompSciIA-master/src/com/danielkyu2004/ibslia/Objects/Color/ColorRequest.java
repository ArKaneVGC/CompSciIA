package com.danielkyu2004.ibslia.Objects.Color;

import java.util.*;

public class ColorRequest {
    public String kind;
    public String updated;
    public Map<String, ColorObject> calendar;
    public Map<String, ColorObject> event;

    public ColorRequest(){}

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("Kind: "+kind+"\n");
        sb.append("Updated: "+updated+"\n");
        sb.append("calendar: \n");
        for(Map.Entry<String,ColorObject> e:calendar.entrySet())
            sb.append(e.getKey()+": \n"+e.getValue()+"\n");
        sb.append("\nevent: \n");
        for(Map.Entry<String,ColorObject> e:event.entrySet())
            sb.append(e.getKey()+": \n"+e.getValue()+"\n");
        return sb.toString();
    }



}
