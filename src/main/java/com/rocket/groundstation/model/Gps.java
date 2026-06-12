package com.rocket.groundstation.model;


public class Gps {
    private double altitude;
    private double latitude;
    private double longitude;    
    
    
    public Gps(){
        this.altitude = 0;
        this.latitude = 0;
        this.longitude = 0;
    }
    
    public Gps(double altitude, double latitude, double longitude) {
        this.altitude = altitude;
        this.latitude = latitude;
        this.longitude = longitude;
    }    

    public double getAltitude() {
        return altitude;
    }
    
    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }
    
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }      
    
}