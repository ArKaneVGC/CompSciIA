package com.danielkyu2004.ibslia.Objects.Directions;
import com.danielkyu2004.ibslia.Config;
import com.danielkyu2004.ibslia.Main;
import com.danielkyu2004.ibslia.Objects.Directions.PlaceIDs.PlaceIDResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import static com.danielkyu2004.ibslia.Config.API_KEY;


public class DirectionsConnection {
    public static final String baseURL="https://maps.googleapis.com/maps/api/directions/json?";
    public static final String findPlaceURL="https://maps.googleapis.com/maps/api/place/findplacefromtext/json?inputtype=textquery&fields=formatted_address%2Cplace_id%2Cname&input=";
    public StringBuilder params;
    public static char[] invalidChars= {'!','*','\'','(',')',';',':','@','&','=','+','$', '/','?','%','#','[',']', ' '};

    public DirectionsConnection(){
        params=new StringBuilder(baseURL);
    }

    //add places
    public boolean addOrigin(InputObject placeId){
        params.append("origin=place_id:").append(placeId.response.candidates[0].place_id).append('&');
        params.append("destination=place_id:").append(placeId.response.candidates[0].place_id).append('&');
        return true;
    }

    public boolean addWaypoints(Vector<InputObject> placeIds){
        params.append("waypoints=optimize:true");
        for(int i=1;i<placeIds.size();i++){
            params.append("|place_id:").append(placeIds.get(i).response.candidates[0].place_id);
        }
        params.append('&');
        return true;
    }

    //get json and create object
    public DirectionCall getRoute() throws IOException {
        URL url=new URL(params.append("key=").append(Config.API_KEY).toString());
        HttpURLConnection http= (HttpURLConnection)url.openConnection();
        http.setRequestMethod("GET");
        Gson gson = new Gson();
        Scanner s=new Scanner(http.getInputStream());
        StringBuilder sb=new StringBuilder();
        while(s.hasNextLine()) sb.append(s.nextLine());
        DirectionCall response =gson.fromJson(sb.toString(),DirectionCall.class);
        http.disconnect();
        return response;
    }

    public Vector<InputObject> findPlaceIDs(Vector<InputObject> vec) throws IOException {
        for(int i=0;i<vec.size();i++){
            URL url =new URL(findPlaceURL+vec.get(i).toURL()+"&key="+API_KEY);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            Gson gson=new Gson();
            Scanner s=new Scanner(con.getInputStream());
            StringBuilder sb=new StringBuilder();
            while(s.hasNextLine()) sb.append(s.nextLine());
            vec.get(i).response=gson.fromJson(sb.toString(), PlaceIDResponse.class);
        }
        return vec;
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
