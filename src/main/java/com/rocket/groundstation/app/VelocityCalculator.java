package com.rocket.groundstation.app;

import com.rocket.groundstation.util.GeoCalculator;


public class VelocityCalculator {
    private double horizontalVelocity;
    private double verticalVelocity;
    private double resultantVelocity;
    
    private double horizontalVelocitiesAvrg;
    private double verticalVelocitiesAvrg;
    
    private double lastAlt;
    private double lastLat;
    private double lastLon;
    
    private long lastTime;
    
    private int numberOfDistances;
    private int distanceCount;
    
    
    public VelocityCalculator(int numberOfDistances){
        this(numberOfDistances, 0, 0, 0, 0);
    }
    
    public VelocityCalculator(int numberOfDistances, double initialAltitude, double initialLatitude, double initialLongitude, long initialTime){
        horizontalVelocity = 0;
        verticalVelocity = 0;
        resultantVelocity = 0;
        this.lastAlt = initialAltitude;
        this.lastLat = initialLatitude;
        this.lastLon = initialLongitude;
        this.lastTime = initialTime;
        this.numberOfDistances = numberOfDistances>0 ? numberOfDistances : 1;
        distanceCount = 0;
    }
    
    public void addPoint(double altitude, double latitude, double longitude, long t){
        addPoints(lastAlt, lastLat, lastLon, lastTime, altitude, latitude, longitude, t);
    }
    
    public void addPoints(
            double alt1, double lat1, double lon1, long t1,
            double alt2, double lat2, double lon2, long t2
    ){
        this.lastAlt = alt2;
        this.lastLat = lat2;
        this.lastLon = lon2;
        this.lastTime = t2;
        
        double dt = (t2-t1)/1000.0;
        if(dt<=0) return;
        
        horizontalVelocitiesAvrg += GeoCalculator.haversineDistance(lat1, lon1, lat2, lon2) / dt / numberOfDistances;
        verticalVelocitiesAvrg += (alt2-alt1) / dt / numberOfDistances;
        distanceCount++;
        
        if(distanceCount==numberOfDistances){
            horizontalVelocity = horizontalVelocitiesAvrg;
            verticalVelocity = verticalVelocitiesAvrg;
            resultantVelocity = Math.hypot(horizontalVelocitiesAvrg, verticalVelocitiesAvrg);
            horizontalVelocitiesAvrg = 0;
            verticalVelocitiesAvrg = 0;
            distanceCount = 0;
        }
    }
    
    public double getHorizontalVelocity() {
        return horizontalVelocity;
    }

    public double getVerticalVelocity() {
        return verticalVelocity;
    }

    public double getResultantVelocity() {
        return resultantVelocity;
    }

    public int getNumberOfDistances() {
        return numberOfDistances;
    }
    
    public int getDistanceCount() {
        return distanceCount;
    }
    
    public void setNumberOfDistances(int numberOfDistances){
        this.numberOfDistances = numberOfDistances>0 ? numberOfDistances : 1;
        horizontalVelocitiesAvrg = 0;
        verticalVelocitiesAvrg = 0;
        resultantVelocity = 0;
        distanceCount = 0;
    }
}
