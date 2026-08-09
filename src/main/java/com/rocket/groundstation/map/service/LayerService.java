package com.rocket.groundstation.map.service;

import com.rocket.groundstation.app.TelemetryModel;
import com.rocket.groundstation.map.model.Marker;
import com.rocket.groundstation.map.model.Trajectory;
import java.util.ArrayList;
import java.util.List;
import org.mapsforge.map.awt.view.MapView;


public class LayerService {
    private MapView map;
    
    private List<Trajectory> trajectories;
    private Trajectory currentTrajectory;
    private boolean currentTrajectorySaved;
    
    private List<Marker> markers;
    
    
    public LayerService(){
        trajectories = new ArrayList<>();
        markers = new ArrayList<>();
        currentTrajectorySaved = false;
    }
    
    public void setMap(MapView map){
        this.map = map;
        if(map==null) return;
        map.getModel().mapViewPosition.addObserver(()->{
            markers.forEach((marker)->{
                marker.getCircle().setRadius((float) (4.4f / Math.pow(1.85, map.getModel().mapViewPosition.getZoomLevel() - 18)));
            });
        });
        trajectories = new ArrayList<>();
        markers = new ArrayList<>();
    }
    
    public void startNewTrajectory(String name){
        if(currentTrajectory!=null){
            if(currentTrajectorySaved) currentTrajectory.getPolyline().setVisible(false);
            else currentTrajectory.getMap().getLayerManager().getLayers().remove(currentTrajectory.getPolyline());
            currentTrajectory = null;
        }
        if(map==null) return;
        currentTrajectory = new Trajectory(name, map);
        currentTrajectorySaved = false;
    }
    
    public void saveCurrentTrajectory(){
        if(currentTrajectory==null) return;
        
        trajectories.add(currentTrajectory);
        currentTrajectorySaved = true;
    }
    
    public void trajectoryAddData(TelemetryModel data){
        if(currentTrajectory==null) return;
        
        currentTrajectory.addData(data);
        currentTrajectory.getPolyline().requestRedraw();
    }
    
    public List<Trajectory> getTrajectories(){
        return trajectories;
    }
    
    public boolean deleteTrajectory(Trajectory trajectory){
        if(trajectory==currentTrajectory && !currentTrajectorySaved) return false;
        if(trajectory.getMap().getLayerManager().getLayers().remove(trajectory.getPolyline())){
            return trajectories.remove(trajectory);
        }
        return false;
    }
    
    public void addMarker(String name, double lat, double lon){
        if(map==null) return;
        markers.add(new Marker(name, lat, lon, map));
    }
    
    public List<Marker> getMarkers(){
        return markers;
    }
    
    public boolean deleteMarker(Marker marker){
        if(marker.getMap().getLayerManager().getLayers().remove(marker.getCircle())){
            return markers.remove(marker);
        }
        return false;
    }
}
