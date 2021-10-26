package com.danielkyu2004.ibslia.Objects.Directions;

//a single step as a part of a route
//found in an array in DirectionsLeg

public class DirectionsStep {
    public TextValueObject duration;
    public TextValueObject distance;
    public LatLngLiteral start_location;
    public LatLngLiteral end_location;
    public String html_instructions;
    public DirectionsPolyline polyline;
    public TravelMode travel_mode;

    public DirectionsStep(){};

}
