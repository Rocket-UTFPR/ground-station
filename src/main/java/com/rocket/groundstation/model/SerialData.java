package com.rocket.groundstation.model;

import java.time.LocalDateTime;


public class SerialData {
    private double altitude;
    private double latitude;
    private double longitude;
    private LocalDateTime serialDateTime;
    private LocalDateTime actualDateTime;
    
    public SerialData(){
        this.altitude = 0;
        this.latitude = 0;
        this.longitude = 0;
    }
    
    public SerialData(double altitude, double latitude, double longitude) {
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
    
    public LocalDateTime getSerialDateTime() {
        return serialDateTime;
    }
    
    public LocalDateTime getActualDateTime() {
        return actualDateTime;
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
    
    public void getSerialDateTime(LocalDateTime serialDateTime) {
        this.serialDateTime = serialDateTime;
    }
    
    public void getActualDateTime(LocalDateTime actualDateTime) {
        this.actualDateTime = actualDateTime;
    }
}
