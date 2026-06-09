package com.rocket.groundstation.model;


public class Gps {
    private double latitude;
    private double longitude;

    
    public Gps(){
        this.latitude = 0;
        this.longitude = 0;
    }
    
    public Gps(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }    

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }      
    
}