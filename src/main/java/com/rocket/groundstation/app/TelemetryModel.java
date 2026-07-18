package com.rocket.groundstation.app;

import java.time.Instant;


public class TelemetryModel {
    private double altitude;
    private double latitude;
    private double longitude;
    private long uptime; // rocket
    private Instant transmissionTime; // rocket
    private Instant receptionTime; // application
    
    public TelemetryModel(){
        this.altitude = 0;
        this.latitude = 0;
        this.longitude = 0;
        this.uptime = 0;
    }
    
    public TelemetryModel(double altitude, double latitude, double longitude, long uptime, Instant transmissionTime, Instant receptionTime) {
        this.altitude = altitude;
        this.latitude = latitude;
        this.longitude = longitude;
        this.uptime = uptime;
        this.transmissionTime = transmissionTime;
        this.receptionTime = receptionTime;
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
    
    public long getUptime(){
        return uptime;
    }
    
    public Instant getTransmissionTime() {
        return transmissionTime;
    }
    
    public Instant getReceptionTime() {
        return receptionTime;
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
    
    public void setUptime(long uptime){
        this.uptime = uptime;
    }
    
    public void setTransmissionTime(Instant transmissionTime) {
        this.transmissionTime = transmissionTime;
    }
    
    public void setReceptionTime(Instant receptionTime) {
        this.receptionTime = receptionTime;
    }
}
