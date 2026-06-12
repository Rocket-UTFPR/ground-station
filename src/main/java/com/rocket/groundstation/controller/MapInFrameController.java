package com.rocket.groundstation.controller;

import com.rocket.groundstation.view.MapInFrame;


public class MapInFrameController {
    private MapInFrame mapInFrame;
    
    public MapInFrameController(MapInFrame mapInFrame){
        this.mapInFrame = mapInFrame;
                
    }
    
    public MapInFrame getMapInFrame(){
        return mapInFrame;
    }
    
}
