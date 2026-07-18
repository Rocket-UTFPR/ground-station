package com.rocket.groundstation.map.model;

import com.rocket.groundstation.app.TelemetryModel;
import java.util.ArrayList;
import java.util.List;
import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.graphics.Style;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.map.awt.graphics.AwtGraphicFactory;
import org.mapsforge.map.layer.overlay.Polyline;


public class Trajectory{
    private String name;
    private final List<TelemetryModel> telemetryData;
    private final Polyline polyline;
    
    public Trajectory(String name){
        this.name = name;
        telemetryData = new ArrayList<>();
        
        Paint paint = AwtGraphicFactory.INSTANCE.createPaint();
        paint.setStrokeWidth(2.8f);
        paint.setColor(0xFF9F4BF4);
        paint.setStyle(Style.STROKE);
        polyline = new Polyline(paint, AwtGraphicFactory.INSTANCE);
        polyline.setStrokeIncrease(1.2);
    }
    
    public String getName() {
        return name;
    }

    public List<TelemetryModel> getTelemetryData() {
        return telemetryData;
    }
    
    public Polyline getPolyline(){
        return polyline;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void addData(TelemetryModel data){
        if(data==null) return;
        
        telemetryData.add(data);
        polyline.addPoint(new LatLong(data.getLatitude(), data.getLongitude()));
    }
}
