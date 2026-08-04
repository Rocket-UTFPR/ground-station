package com.rocket.groundstation.map.model;

import java.awt.Color;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.graphics.Style;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.map.awt.graphics.AwtGraphicFactory;
import org.mapsforge.map.awt.view.MapView;
import org.mapsforge.map.layer.overlay.Circle;


public class Marker {
    private String name;
    private Circle circle;
    private final MapView map;

    public Marker(String name, double lat, double lon, MapView map) {
        this.name = name;
        this.map = map;
        
        GraphicFactory gf = AwtGraphicFactory.INSTANCE;

        Paint fill = gf.createPaint();
        fill.setColor(0xFF841AAB);
        fill.setStyle(Style.FILL);

        Paint stroke = gf.createPaint();
        stroke.setColor(0xEE050505);
        stroke.setStrokeWidth(2);
        stroke.setStyle(Style.STROKE);
        
        circle = new Circle(
                new LatLong(lat, lon),
                5, fill, stroke
        );
        
        if(map!=null) {
            map.addLayer(circle);
            circle.setRadius((float) (4.4f / Math.pow(1.85, map.getModel().mapViewPosition.getZoomLevel() - 18)));
        }
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return new Color(circle.getPaintFill().getColor());
    }

    public Circle getCircle() {
        return circle;
    }
    
    public MapView getMap(){
        return map;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(Color color) {
        circle.getPaintFill().setColor(color.getRGB());
        circle.requestRedraw();
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }
    
    public void setPosition(double lat, double lon){
        circle.setLatLong(new LatLong(lat, lon));
        circle.requestRedraw();
    }
    
    public void toggleVisibility(){
        circle.setVisible(!circle.isVisible());
    }
    
    public void centralize(){
        if(map!=null) map.setCenter(circle.getPosition());
    }
}
