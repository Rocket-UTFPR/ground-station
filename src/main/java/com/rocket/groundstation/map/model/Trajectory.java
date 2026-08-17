package com.rocket.groundstation.map.model;

import com.rocket.groundstation.telemetry.TelemetryModel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.graphics.Style;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.map.awt.graphics.AwtGraphicFactory;
import org.mapsforge.map.awt.view.MapView;
import org.mapsforge.map.layer.overlay.Polyline;


public class Trajectory{
    private String name;
    private final List<TelemetryModel> telemetryData;
    private final Polyline polyline;
    private final MapView map;
    
    public Trajectory(String name, MapView map){
        this.name = name;
        this.map = map;
        telemetryData = new ArrayList<>();
        
        Paint paint = AwtGraphicFactory.INSTANCE.createPaint();
        paint.setStrokeWidth(2.8f);
        paint.setColor(0xFF9F4BF4);
        paint.setStyle(Style.STROKE);
        polyline = new Polyline(paint, AwtGraphicFactory.INSTANCE);
        polyline.setStrokeIncrease(1.2);
        
        if(map!=null) map.addLayer(polyline);
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
    
    public Color getColor(){
        return new Color(polyline.getPaintStroke().getColor());
    }
    
    public MapView getMap(){
        return map;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setColor(Color color){
        polyline.getPaintStroke().setColor(color.getRGB());
        polyline.requestRedraw();
    }
    
    public void toggleVisibility(){
        polyline.setVisible(!polyline.isVisible());
    }
    
    public void addData(TelemetryModel data){
        if(data==null) return;
        
        telemetryData.add(data);
        polyline.addPoint(new LatLong(data.getLatitude(), data.getLongitude()));
    }
}
