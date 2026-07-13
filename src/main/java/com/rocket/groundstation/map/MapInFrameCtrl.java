package com.rocket.groundstation.map;

import com.rocket.groundstation.app.AppCommons;
import com.rocket.groundstation.exceptions.InvalidPathException;
import com.rocket.groundstation.app.TelemetryModel;
import com.rocket.groundstation.settings.SettingsModel;
import com.rocket.groundstation.serial.core.dispatch.DataListener;
import com.rocket.groundstation.util.InFrameFixer;
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
    private volatile double lastLatRead;
    private volatile double lastLonRead;
    private DataListener<TelemetryModel> displayUpdater;
    private DataListener<TelemetryModel> positionMarker;
    private DataListener<TelemetryModel> tracker;
    private DataListener<TelemetryModel> routeDrawer;
    
    public MapInFrameCtrl(MapInFrame mapInFrame, SettingsModel settings, AppCommons appCommons){
        this.mapInFrame = mapInFrame;
        this.settings = settings;
        this.appCommons = appCommons;
        lastLatRead = -21.938391;
        lastLonRead = -48.950188;
        
        InFrameFixer.fix(this.mapInFrame);
        
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
            lastLatRead = newData.getLatitude();
            lastLonRead = newData.getLongitude();
            
            SwingUtilities.invokeLater(()->{
                mapInFrame.coordinatesLbSetText(
                        String.format(Locale.US, "%.6f", newData.getAltitude()),
                        String.format(Locale.US, "%.6f", newData.getLatitude()),
                        String.format(Locale.US, "%.6f", newData.getLongitude())
                );
            });
        };
        
        positionMarker = (oldData, newData) ->{
            SwingUtilities.invokeLater(()->{
                mapInFrame.positionMarkerUpdate(
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
        
        routeDrawer = (oldData, newData) -> {
            SwingUtilities.invokeLater(()->{
                mapInFrame.routeAddPoint(
                        newData.getLatitude(),
                        newData.getLongitude() 
                );
            });
        };
    }
    
    private void addListeners(){
        appCommons.getDecodedDataDispatcher().addDataListener(displayUpdater);
        mapInFrame.addCopyBtListener((e)->copyCoordinatesToClipboard());
        mapInFrame.addPositionMarkerCbListener((e)->markPosition(e));
        mapInFrame.addTrackCbListener((e)->trackPosition(e));
        mapInFrame.addSatCbListener((e)->toggleSat(e));
        mapInFrame.addRouteTbListener((e)->drawRoute(e));
        mapInFrame.addCenterMapBtActionListener((e)->centerMap());
    }
    
    private void copyCoordinatesToClipboard(){
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
                new StringSelection(
                        String.format(Locale.US, "%.6f", lastLatRead)
                        + ", " +
                        String.format(Locale.US, "%.6f", lastLonRead)
                ), 
                null
        );
    }
    
    private void markPosition(ItemEvent e){
        if(e.getStateChange()==ItemEvent.SELECTED){
            mapInFrame.positionMarkerUpdate(lastLatRead, lastLonRead);
            appCommons.getDecodedDataDispatcher().addDataListener(positionMarker);
            mapInFrame.positionMarkerSetVisible(true);
        } else{
            mapInFrame.positionMarkerSetVisible(false);
            appCommons.getDecodedDataDispatcher().removeDataListener(positionMarker);
        }
    }
    
    private void trackPosition(ItemEvent e){
        if(e.getStateChange()==ItemEvent.SELECTED){
            mapInFrame.mapSetCenter(lastLatRead, lastLonRead);
            appCommons.getDecodedDataDispatcher().addDataListener(tracker);
        } else{
            appCommons.getDecodedDataDispatcher().removeDataListener(tracker);
        }
    }
    
    private void drawRoute(ItemEvent e){
        if(e.getStateChange()==ItemEvent.SELECTED){
            appCommons.getDecodedDataDispatcher().addDataListener(routeDrawer);
            mapInFrame.routeTbSetText("Finalizar rota");
        } else{
            appCommons.getDecodedDataDispatcher().removeDataListener(routeDrawer);
            mapInFrame.routeTbSetText("Iniciar nova rota");
        }
    }
    
    private void toggleSat(ItemEvent e){
        if(e.getStateChange()==ItemEvent.SELECTED) mb.addSatLayer();
        else mb.removeSatLayer();
    }
    
    private void centerMap(){
        try{
        mapInFrame.mapSetCenter(
                Double.parseDouble(mapInFrame.latTfGetText()), 
                Double.parseDouble(mapInFrame.lonTfGetText())
        );
        } catch(NumberFormatException ex){
            mapInFrame.showErrorMsg("Use apenas números e ponto", "Formato inválido");
        }
    }
}
