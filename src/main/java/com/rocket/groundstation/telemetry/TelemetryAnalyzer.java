package com.rocket.groundstation.telemetry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;


public class TelemetryAnalyzer {
    private List<TelemetryModel> telemetryData;
    private TelemetryModel launch;
    private TelemetryModel apogee;
    private TelemetryModel impact;
    
    private VelocityCalculator vc;
    
    
    public TelemetryAnalyzer(List<TelemetryModel> telemetryData){
        this.telemetryData = new ArrayList<>(telemetryData);
    }
    
    public TelemetryModel getLaunch(){
        return launch;
    }
    
    public TelemetryModel getApogee(){
        return apogee;
    }
    
    public TelemetryModel getImpact(){
        return impact;
    }
    
    public double getAscentVelocity(){
        double dt = (apogee.getUptime()-launch.getUptime())/1000.0;
        if(dt<=0) return 0;
        
        return (apogee.getAltitude()-launch.getAltitude()) / dt;
    }
    
    public void setTelemetryData(List<TelemetryModel> telemetryData){
        this.telemetryData = new ArrayList<>(telemetryData);
        vc = new VelocityCalculator(1, 1);
    }
    
    public void updateValues(){
        int apogeeIndex = updateApogee();
        updateLaunch(apogeeIndex);
    }
    
    private int updateApogee(){
        apogee = telemetryData.getFirst();
        int apogeeIndex = 0;
        int i = 0;
        for(TelemetryModel tm : telemetryData){
            if(tm.getAltitude()>apogee.getAltitude()){
                apogee = tm;
                apogeeIndex = i;
            }
            i++;
        }
        return apogeeIndex;
    }
    
    private void updateLaunch(int apogeeIndex){
        TelemetryModel startingPoint = null;
        int strPointIndex = 0;
        for(TelemetryModel tm : telemetryData){
            if(apogee.getUptime()-tm.getUptime()<=20000){
                startingPoint = tm;
                break;
            }
            strPointIndex++;
        }
        if(startingPoint==null) return;
        
        List<TelemetryModel> points = telemetryData.subList(strPointIndex, apogeeIndex);
        
        WeightedObservedPoints wop = new WeightedObservedPoints();
        
        for(TelemetryModel point : points){
            wop.add(point.getUptime()/1000, point.getAltitude());
        }
        
        PolynomialCurveFitter pcf = PolynomialCurveFitter.create(4);
        double[] c = pcf.fit(wop.toList());
        
        System.out.println(Arrays.toString(c));
        
        for(TelemetryModel point : points){
            double t = point.getUptime()/1000;
            double velocity = c[1] + 2*c[2]*t + 3*c[3]*t*t + 4*c[4]*t*t*t;
            if(velocity>3){
                launch = point;
                break;
            }
        }
    }
}
