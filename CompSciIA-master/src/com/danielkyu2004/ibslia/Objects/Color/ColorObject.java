package com.danielkyu2004.ibslia.Objects.Color;

public class ColorObject {
    public String background;
    public String foreground;

    public ColorObject(){}

    @Override
    public String toString(){
        return "\tBackground: "+background+"\n\tForeground: "+foreground;
    }

}
