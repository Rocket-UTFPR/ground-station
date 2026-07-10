package com.rocket.groundstation.controller;

import com.rocket.groundstation.app.AppCommons;
import com.rocket.groundstation.exceptions.InvalidPathException;
import com.rocket.groundstation.model.SerialData;
import com.rocket.groundstation.model.SettingsModel;
import com.rocket.groundstation.serial.interfaces.DataListener;
import com.rocket.groundstation.service.InFrameFixer;
import com.rocket.groundstation.service.MapBuilder;
import com.rocket.groundstation.view.MapInFrame;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ItemEvent;
import java.util.Locale;
import javax.swing.SwingUtilities;


public class MapInFrameCtrl {
    private MapInFrame mapInFrame;
    private SettingsModel settings;
    private AppCommons appCommons;
    private MapBuilder mb;
    private String latLon;
    private DataListener<SerialData> displayUpdater;
    private DataListener<SerialData> positionMarker;
    private DataListener<SerialData> tracker;
    private DataListener<SerialData> routeDrawer;
    
    public MapInFrameCtrl(MapInFrame mapInFrame, SettingsModel settings, AppCommons appCommons){
        this.mapInFrame = mapInFrame;
        this.settings = settings;
        this.appCommons = appCommons;
        this.latLon = "";
        
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
            mb = new MapBuilder(
                    settings.getMapPath(),
                    settings.getRenderThemePath()
            ); 
            mapInFrame.setMap(mb.getMap());
        } catch(InvalidPathException ex){
            mapInFrame.showErrorMsg(
                    "Arquivo não encontrado: " + ex.getPath(), 
                    "Erro ao carregar o mapa"
            );
        }
    }
    
    private void dataListenersSetup(){
        displayUpdater = (oldData, newData) -> {
            
            String lat = String.format(Locale.US, "%.6f", newData.getLatitude());
            String lon = String.format(Locale.US, "%.6f", newData.getLongitude());
            latLon = lat + ", " + lon;
            
            SwingUtilities.invokeLater(()->{
                mapInFrame.setCoordinatesLbText(
                        String.format(Locale.US, "%.6f", newData.getAltitude()),
                        lat,
                        lon
                );
            });
        };
        
        positionMarker = (oldData, newData) ->{
            SwingUtilities.invokeLater(()->{
                mapInFrame.updatePositionMarker(
                        newData.getLatitude(),
                        newData.getLongitude()
                );
            });
        };
        
        tracker = (oldData, newData) -> {
            SwingUtilities.invokeLater(()->{
                mapInFrame.mapSetCenter(
                        newData.getLatitude(),
                        newData.getLongitude()
                );
            });
        };
    }
    
    private void addListeners(){
        appCommons.getDecodedDataDispatcher().addDataListener(displayUpdater);
        mapInFrame.addCopyBtListener((e)->Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(latLon), null));
        mapInFrame.addPositionMarkerCbListener((e)->markPosition(e));
        mapInFrame.addTrackCbListener((e)->trackPosition(e));
        mapInFrame.addSatCbListener((e)->toggleSat(e));
    }
    
    private void markPosition(ItemEvent e){
        if(e.getStateChange()==ItemEvent.SELECTED){
            appCommons.getDecodedDataDispatcher().addDataListener(positionMarker);
            mapInFrame.setPositionMarkerVisible(true);
        } else{
            mapInFrame.setPositionMarkerVisible(false);
            appCommons.getDecodedDataDispatcher().removeDataListener(positionMarker);
        }
    }
    
    private void trackPosition(ItemEvent e){
        if(e.getStateChange()==ItemEvent.SELECTED){
            appCommons.getDecodedDataDispatcher().addDataListener(tracker);
        } else{
            appCommons.getDecodedDataDispatcher().removeDataListener(tracker);
        }
    }
    
    private void toggleSat(ItemEvent e){
        if(e.getStateChange()==ItemEvent.SELECTED) mb.addSatLayer();
        else mb.removeSatLayer();
    }
}
