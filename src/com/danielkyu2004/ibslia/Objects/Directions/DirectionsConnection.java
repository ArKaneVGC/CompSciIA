package com.danielkyu2004.ibslia.Objects.Directions;
import com.danielkyu2004.ibslia.Config;
import com.danielkyu2004.ibslia.Objects.Directions.PlaceIDs.PlaceIDResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;


public class DirectionsConnection {
    public static String baseURL="https://maps.googleapis.com/maps/api/directions/json?";
    public static String findPlaceURL="https://maps.googleapis.com/maps/api/place/findplacefromtext/json?inputtype=textquery&input=";
    public StringBuilder params;
    public static char[] invalidChars= {'!','*','\'','(',')',';',':','@','&','=','+','$', '/','?','%','#','[',']', ' '};

    public DirectionsConnection(){
        params=new StringBuilder(baseURL);
    }

    //add places
    public boolean addOrigin(String placeId){
        params.append("origin=placeid:").append(placeId).append('&');
        return true;
    }

    public boolean addWaypoints(ArrayList<String> placeIds){
        params.append("waypoints=optimize:true");
        for(String placeId:placeIds){
            params.append("|").append(placeId);
        }
        return true;
    }

    //get json and create object
    public DirectionCall getRoute() throws IOException {
        URL url=new URL(baseURL+params.append("&key=").append(Config.API_KEY));
        HttpURLConnection http= (HttpURLConnection)url.openConnection();
        http.setRequestMethod("GET");
        Gson gson = new Gson();
        DirectionCall response =gson.fromJson(http.getOutputStream().toString(),DirectionCall.class);
        http.disconnect();
        return response;
    }

    //static methods for later use
    public static PlaceIDResponse getPlace(String query) throws IOException{
        URL url=new URL(findPlaceURL+toEncodedURL(query));
        HttpURLConnection http=(HttpURLConnection)url.openConnection();
        http.setRequestMethod("GET");
        Gson gson=new Gson();
        PlaceIDResponse response=gson.fromJson(http.getOutputStream().toString(),PlaceIDResponse.class);
        http.disconnect();


        return response;
    }

    //encode strings to url
    public static String toEncodedURL(String query){
        StringBuilder newURL=new StringBuilder();
        for(int i=0;i<query.length();i++){
            boolean searching=true;
            for(int j=0;j< invalidChars.length&&searching;j++){
                if(query.charAt(i)==invalidChars[j]) {
                    newURL.append('%').append(Integer.toHexString(invalidChars[j]));
                    searching=false;
                }
            }
            if(searching)
                newURL.append(query.charAt(i));
        }
        return newURL.toString();

    }








}
