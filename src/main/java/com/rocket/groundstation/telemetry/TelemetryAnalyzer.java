package com.rocket.groundstation.telemetry;

import java.util.ArrayList;
import java.util.List;


public class TelemetryAnalyzer {
    private List<TelemetryModel> telemetryData;
    private TelemetryModel launch;
    private TelemetryModel apogee;
    private TelemetryModel impact;
    
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
        if(apogee==null||launch==null) return 0;
        
        double dt = (apogee.getUptime()-launch.getUptime())/1000.0;
        if(dt<=0) return 0;
        
        return (apogee.getAltitude()-launch.getAltitude()) / dt;
    }
    
    public double getDescentVelocity(){
        if(apogee==null||impact==null) return 0;
        
        double dt = (impact.getUptime()-apogee.getUptime())/1000.0;
        if(dt<=0) return 0;
        
        return (apogee.getAltitude()-impact.getAltitude()) / dt;
    }
    
    public void setTelemetryData(List<TelemetryModel> telemetryData){
        this.telemetryData = new ArrayList<>(telemetryData);
    }
    
    public void updateValues(){
        int launchIndex = -1;
        int i = 0;
        for(TelemetryModel tm : telemetryData){
            if(tm.isIgnition()){
                launchIndex = i;
                launch = tm;
                break;
            }
            i++;
        }
        if(launchIndex==-1) return;
        
        telemetryData = telemetryData.subList(launchIndex, telemetryData.size()-1);
        
        int apogeeIndex = updateApogee();
        updateImpact(apogeeIndex);
    }
    
    private int updateApogee(){
        apogee = new TelemetryModel();
        int apogeeIndex = 0;
        int i = 0;
        for(TelemetryModel tm : telemetryData){
            if(tm.getAltitude()>apogee.getAltitude() && tm.getAltitude()<9000){
                apogee = tm;
                apogeeIndex = i;
            }
            i++;
        }
        return apogeeIndex;
    }
    
    private void updateImpact(int apogeeIndex){
        List<TelemetryModel> descent = telemetryData.subList(apogeeIndex, telemetryData.size()-1);
        
        int endPointIndex = 0;
        for(TelemetryModel tm : descent){
            if(tm.getUptime()-apogee.getUptime()>=300000) break;
            endPointIndex++;
        }
        
        int startingPointIndex = 0;
        double minAlt = 0.6 * apogee.getAltitude();
        for(TelemetryModel tm : descent){
            if(tm.getAltitude()<=minAlt && tm.getAltitude()>0) break;
            startingPointIndex++;
        }
        
        if(endPointIndex<=startingPointIndex) return;
        
        descent = descent.subList(startingPointIndex, endPointIndex);
        
        int window = 20;
        
        ArrayList<TelemetryModel> sample = f(descent, window);
        ArrayList<TelemetryModel> oldSample = sample;
        
        while(sample!=null && !sample.isEmpty()){
            oldSample = sample;
            window /= 2;
            sample = f(sample, window);
        }
        impact = oldSample.getLast();
    }
    
    private ArrayList f(List<TelemetryModel> data, int window){
        if(window<=1) return null;
        
        double mean = 0;
        double mean2 = 0;
        int count = 0;
        int index = 0;
        boolean dataEnded = false;
        ArrayList<TelemetryModel> points = new ArrayList<>();
        
        while(!dataEnded){
            if(index>=data.size()) return points;
            
            points.clear();
            for(int i = 0; i<window; i++){
                if(index<data.size()){
                    points.add(data.get(index));
                }else{
                    window = i;
                    if(window<=1) return points;
                    dataEnded = true;
                    break;
                }
                index++;
            }
            
            for(TelemetryModel point : points){
                if(count<window/2){
                    mean += point.getAltitude() / (window/2);
                    count++;
                } else if(count<window){
                    mean2 += point.getAltitude() / (window/2);
                    count++;
                }
            }
            double d = mean - mean2;
            if(-2<d && d<2){
                return points;
            }
            mean = 0;
            mean2 = 0;
            count = 0;
            index = index - window + 1;
        }
        return points;
    }
}
