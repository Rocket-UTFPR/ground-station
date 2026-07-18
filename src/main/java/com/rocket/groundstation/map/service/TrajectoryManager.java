package com.rocket.groundstation.map.service;

import com.rocket.groundstation.app.TelemetryModel;
import com.rocket.groundstation.map.model.Trajectory;
import java.util.ArrayList;
import java.util.List;
import org.mapsforge.map.awt.view.MapView;


public class TrajectoryManager {
    private final List<Trajectory> trajectories;
    private Trajectory currentTrajectory;
    private boolean currentTrajectorySaved;
    
    public TrajectoryManager(){
        trajectories = new ArrayList<>();
        currentTrajectorySaved = false;
    }
    
    public void startNewTrajectory(MapView map, String name){
        if(currentTrajectory!=null){
            if(currentTrajectorySaved) currentTrajectory.getPolyline().setVisible(false);
            else map.getLayerManager().getLayers().remove(currentTrajectory.getPolyline());
        }
        currentTrajectory = new Trajectory(name);
        map.addLayer(currentTrajectory.getPolyline());
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
}
