package com.rocket.groundstation.controller;

import com.rocket.groundstation.view.MapInFrame;


public class MapInFrameCtrl {
    private MapInFrame mapInFrame;
    
    public MapInFrameCtrl(MapInFrame mapInFrame){
        this.mapInFrame = mapInFrame;
                
    }
    
    public MapInFrame getMapInFrame(){
        return mapInFrame;
    }
    
}
