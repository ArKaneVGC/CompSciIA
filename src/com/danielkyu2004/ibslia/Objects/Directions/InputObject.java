package com.danielkyu2004.ibslia.Objects.Directions;

import com.danielkyu2004.ibslia.Objects.Directions.PlaceIDs.PlaceIDResponse;

public class InputObject {
    public String task;
    public String location;
    public PlaceIDResponse response;

    public InputObject (String t, String l){
        task=t;
        location=l;
    }

    @Override
    public String toString(){
        return task + ", at "+location;
    }

}
