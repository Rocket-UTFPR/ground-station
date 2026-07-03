package com.rocket.groundstation.controller;

import com.rocket.groundstation.app.AppCommons;
import com.rocket.groundstation.model.SerialData;
import com.rocket.groundstation.serial.interfaces.DataListener;
import com.rocket.groundstation.service.InFrameFixer;
import com.rocket.groundstation.view.MapInFrame;
import java.io.File;
import javax.swing.SwingUtilities;
import org.mapsforge.map.reader.header.MapFileException;


public class MapInFrameCtrl {
    private MapInFrame mapInFrame;
    private AppCommons appCommons;
    private DataListener<SerialData> displayDataListener;
    private DataListener<SerialData> trackDataListener;
    private DataListener<SerialData> drawDataListener;
    
    public MapInFrameCtrl(MapInFrame mapInFrame, AppCommons appCommons){
        this.mapInFrame = mapInFrame;
        this.appCommons = appCommons;
        
        new InFrameFixer().fix(this.mapInFrame);
        
        mapSetup();
        dataListenersSetup();
        addListeners();
    }
    
    public MapInFrame getMapInFrame(){
        return mapInFrame;
    }
        
    private void mapSetup(){
        try{
            File cacheFile = new File("maps/cache");
            cacheFile.mkdir();
            mapInFrame.initMap(
                    new File("maps/Brasil-Coast-South_oam.osm.map"),
                    cacheFile,
                    new File("maps/themes/elevate/Elevate.xml")
            );
        } catch(MapFileException ex){
            mapInFrame.showErrorMsg(
                    "Arquivo não encontrado: maps\\Brasil-Coast-South_oam.osm.map", 
                    "Erro ao carregar o mapa"
            );
        }
    }
    
    private void dataListenersSetup(){
        displayDataListener = (oldData, newData) -> {
            SwingUtilities.invokeLater(()->{
                mapInFrame.setAltTfText(String.format("%.6f", newData.getAltitude()));
                mapInFrame.setLatTfText(String.format("%.6f", newData.getLatitude()));
                mapInFrame.setLonTfText(String.format("%.6f", newData.getLongitude()));
            });
        };
    }
    
    private void addListeners(){
        appCommons.getDecodedDataDispatcher().addDataListener(displayDataListener);
    }
}
