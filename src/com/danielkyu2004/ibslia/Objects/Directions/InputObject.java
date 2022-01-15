package com.danielkyu2004.ibslia.Objects.Directions;

import com.danielkyu2004.ibslia.Main;
import com.danielkyu2004.ibslia.Objects.Directions.PlaceIDs.PlaceIDResponse;

public class InputObject implements Comparable<InputObject> {
    public String task;
    public String location;
    public PlaceIDResponse response;
    public int waypointNum;

    public InputObject (String t, String l){
        task=t;
        location=l;
    }

    @Override
    public String toString(){
        return task + ", at "+location;
    }

    @Override
    public int compareTo(InputObject o) {
        if(this.waypointNum>o.waypointNum)
            return 1;
        else return -1;
    }

    public String toURL() {
        return DirectionsConnection.toEncodedURL(location);
    }
}
