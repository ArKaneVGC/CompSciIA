package com.danielkyu2004.ibslia.Objects.Directions;

//information between 2 locations on the route
//found in array in DirectionsRoute

public class DirectionsLeg {
    public String end_address;
    public String start_address;
    public LatLngLiteral end_location;
    public LatLngLiteral start_location;
    public DirectionsStep[] steps;
    public DirectionsTrafficSpeedEntry[] traffic_speed_entry;
    public DirectionsViaWaypoint[] via_waypoint;
    public TextValueObject distance;
    public TextValueObject duration;

    public DirectionsLeg(){}
}
