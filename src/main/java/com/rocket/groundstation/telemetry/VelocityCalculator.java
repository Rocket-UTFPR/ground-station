package com.rocket.groundstation.telemetry;

import com.rocket.groundstation.util.GpsUtils;


public class VelocityCalculator {
    private double horizontalVelocity;
    private double verticalVelocity;
    private double resultantVelocity;
    
    private double horizontalVelocitiesAvrg;
    private double verticalVelocitiesAvrg;
    
    TelemetryModel lastValidGpsData;
    TelemetryModel lastData;
    
    private int distanceSample;
    private int distanceCount;
    private int altSample;
    private int altCount;
    
    
    public VelocityCalculator(int distanceSample, int altSample){
        this(distanceSample, altSample, new TelemetryModel());
    }
    
    public VelocityCalculator(int distanceSample, int altSample, TelemetryModel initialData){
        horizontalVelocity = 0;
        verticalVelocity = 0;
        resultantVelocity = 0;
        this.lastData = initialData;
        this.lastValidGpsData = initialData;
        this.distanceSample = distanceSample>0 ? distanceSample : 1;
        this.altSample = altSample>0 ? altSample : 1;
        distanceCount = 0;
        altCount = 0;
    }
    
    public void addData(TelemetryModel data){
        addData(lastData, data);
    }
    
    public void addData(TelemetryModel data1, TelemetryModel data2){
        this.lastData = data2;
        
        if(data2.isNewGpsData()){
            calcHorizontal(lastValidGpsData, data2);
            lastValidGpsData = data2;
        }
        
        calcVertical(data1, data2);
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
        return distanceSample;
    }
    
    public int getDistanceCount() {
        return distanceCount;
    }
    
    public void setDistanceSample(int distanceSample){
        this.distanceSample = distanceSample>0 ? distanceSample : 1;
        horizontalVelocitiesAvrg = 0;
        resultantVelocity = 0;
        distanceCount = 0;
    }
    
    public void setAltSample(int altSample){
        this.altSample = altSample>0 ? altSample : 1;
        verticalVelocitiesAvrg = 0;
        resultantVelocity = 0;
        altCount = 0;
    }
    
    private void calcHorizontal(TelemetryModel data1, TelemetryModel data2){
        double dt = (data2.getUptime()-data1.getUptime())/1000.0;
        if(dt<=0) return;
        
        horizontalVelocitiesAvrg += GpsUtils.haversineDistance(
                data1.getLatitude(), data1.getLongitude(),
                data2.getLatitude(), data2.getLongitude()
        ) / dt / distanceSample;
        
        distanceCount++;
        
        if(distanceCount==distanceSample){
            horizontalVelocity = horizontalVelocitiesAvrg;
            resultantVelocity = Math.hypot(horizontalVelocity, verticalVelocity);
            horizontalVelocitiesAvrg = 0;
            distanceCount = 0;
        }
    }
    
    private void calcVertical(TelemetryModel data1, TelemetryModel data2){
        double dt = (data2.getUptime()-data1.getUptime())/1000.0;
        if(dt<=0) return;
        
        verticalVelocitiesAvrg += (data2.getAltitude()-data1.getAltitude()) / dt / distanceSample;
        altCount++;
        
        if(altCount==altSample){
            verticalVelocity = verticalVelocitiesAvrg;
            resultantVelocity = Math.hypot(horizontalVelocity, verticalVelocity);
            verticalVelocitiesAvrg = 0;
            altCount = 0;
        }
    }
}
