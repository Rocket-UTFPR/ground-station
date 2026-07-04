package com.rocket.groundstation.controller;

import com.rocket.groundstation.app.AppCommons;
import com.rocket.groundstation.exceptions.InvalidPathException;
import com.rocket.groundstation.model.SerialData;
import com.rocket.groundstation.model.SettingsModel;
import com.rocket.groundstation.serial.interfaces.DataListener;
import com.rocket.groundstation.service.InFrameFixer;
import com.rocket.groundstation.service.MapBuilder;
import com.rocket.groundstation.view.MapInFrame;
import java.awt.event.ItemEvent;
import javax.swing.SwingUtilities;


public class MapInFrameCtrl {
    private MapInFrame mapInFrame;
    private SettingsModel settings;
    private AppCommons appCommons;
    private DataListener<SerialData> displayDataListener;
    private DataListener<SerialData> trackDataListener;
    private DataListener<SerialData> drawDataListener;
    
    public MapInFrameCtrl(MapInFrame mapInFrame, SettingsModel settings, AppCommons appCommons){
        this.mapInFrame = mapInFrame;
        this.settings = settings;
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
            mapInFrame.showMap(new MapBuilder().buildMap(
                    settings.getMapPath(),
                    settings.getRenderThemePath()
            ));
        } catch(InvalidPathException ex){
            mapInFrame.showErrorMsg(
                    "Arquivo não encontrado: " + ex.getPath(), 
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
        
        trackDataListener = (oldData, newData) -> {
            SwingUtilities.invokeLater(()->{
                mapInFrame.mapSetCenter(
                        newData.getLatitude(),
                        newData.getLongitude()
                );
            });
        };
    }
    
    private void addListeners(){
        appCommons.getDecodedDataDispatcher().addDataListener(displayDataListener);
        mapInFrame.addTrackCbListener((e)->trackPosition(e));
    }
    
    private void trackPosition(ItemEvent e){
        if(e.getStateChange()==ItemEvent.SELECTED){
            appCommons.getDecodedDataDispatcher().addDataListener(trackDataListener);
        } else{
            appCommons.getDecodedDataDispatcher().removeDataListener(trackDataListener);
        }
    }
}
