package com.rocket.groundstation.controller;

import com.rocket.groundstation.view.MapInFrame;
import org.mapsforge.map.reader.header.MapFileException;


public class MapInFrameCtrl {
    private MapInFrame mapInFrame;
    
    public MapInFrameCtrl(MapInFrame mapInFrame){
        this.mapInFrame = mapInFrame;
        
        mapSetup();
    }
    
    public MapInFrame getMapInFrame(){
        return mapInFrame;
    }
        
    private void mapSetup(){
        try{
            mapInFrame.initMap();
        } catch(MapFileException ex){
            mapInFrame.showErrorMsg(
                    "Arquivo não encontrado: maps\\Brasil-Coast-South_oam.osm.map", 
                    "Erro ao carregar o mapa"
            );
        }
    }
}
