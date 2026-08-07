package com.rocket.groundstation.map.controller;

import com.rocket.groundstation.exceptions.InvalidPathException;
import com.rocket.groundstation.app.TelemetryModel;
import com.rocket.groundstation.app.VelocityCalculator;
import com.rocket.groundstation.map.service.MapBuilder;
import com.rocket.groundstation.map.view.MapInFrame;
import com.rocket.groundstation.map.service.LayerService;
import com.rocket.groundstation.serial.core.dispatch.DataDispatcher;
import com.rocket.groundstation.settings.SettingsModel;
import com.rocket.groundstation.serial.core.dispatch.DataListener;
import com.rocket.groundstation.util.GpsUtils;
import com.rocket.groundstation.util.InFrameFixer;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ItemEvent;
import java.util.Locale;
import javax.swing.SwingUtilities;


public class MapInFrameCtrl {
    private MapInFrame mapInFrame;
    private SettingsModel settings;
    private DataDispatcher<TelemetryModel> ddd;
    private LayerService ls;
    private MapBuilder mb;
    private VelocityCalculator vc;
    private volatile double lastLatRead;
    private volatile double lastLonRead;
    private DataListener<TelemetryModel> displayUpdater;
    private DataListener<TelemetryModel> positionMarker;
    private DataListener<TelemetryModel> tracker;
    private DataListener<TelemetryModel> routeDrawer;
    
    public MapInFrameCtrl(MapInFrame mapInFrame, SettingsModel settings, DataDispatcher<TelemetryModel> ddd, LayerService rs){
        this.mapInFrame = mapInFrame;
        this.settings = settings;
        this.ddd = ddd;
        this.ls = rs;
        lastLatRead = -21.938391;
        lastLonRead = -48.950188;
        vc = new VelocityCalculator(settings.getDistanceSample(), settings.getAltSample());
        
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
            ls.setMap(mapInFrame.getMap());
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
                vc.addData(newData);
                mapInFrame.infoLbSetText(
                        String.format(Locale.US, "%.1f m", newData.getAltitude()),
                        GpsUtils.format(newData.getLatitude()),
                        GpsUtils.format(newData.getLongitude()),
                        String.format(Locale.US, "%.2f km/h", vc.getVerticalVelocity()*3.6),
                        String.format(Locale.US, "%.2f km/h", vc.getHorizontalVelocity()*3.6),
                        String.format(Locale.US, "%.2f km/h", vc.getResultantVelocity()*3.6)
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
                ls.trajectoryAddData(newData);
            });
        };
    }
    
    private void addListeners(){
        ddd.addDataListener(displayUpdater);
        mapInFrame.addCopyBtListener((e)->copyCoordinatesToClipboard());
        mapInFrame.addPositionMarkerCbListener((e)->markPosition(e));
        mapInFrame.addTrackCbListener((e)->trackPosition(e));
        mapInFrame.addSatCbListener((e)->toggleSat(e));
        mapInFrame.addTrajectoryTbListener((e)->drawRoute(e));
        mapInFrame.addCenterMapBtActionListener((e)->centerMap());
    }
    
    private void copyCoordinatesToClipboard(){
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
                new StringSelection(
                        GpsUtils.format(lastLatRead)
                        + ", " +
                        GpsUtils.format(lastLonRead)
                ), 
                null
        );
    }
    
    private void markPosition(ItemEvent e){
        if(e.getStateChange()==ItemEvent.SELECTED){
            mapInFrame.positionMarkerUpdate(lastLatRead, lastLonRead);
            ddd.addDataListener(positionMarker);
            mapInFrame.positionMarkerSetVisible(true);
        } else{
            mapInFrame.positionMarkerSetVisible(false);
            ddd.removeDataListener(positionMarker);
        }
    }
    
    private void trackPosition(ItemEvent e){
        if(e.getStateChange()==ItemEvent.SELECTED){
            mapInFrame.mapSetCenter(lastLatRead, lastLonRead);
            ddd.addDataListener(tracker);
        } else{
            ddd.removeDataListener(tracker);
        }
    }
    
    private void drawRoute(ItemEvent e){
        if(e.getStateChange()==ItemEvent.SELECTED){
            ls.startNewTrajectory(mapInFrame.trajectoryNameTfGetText());
            ddd.addDataListener(routeDrawer);
            mapInFrame.trajectoryTbSetText("Finalizar trajetória");
            mapInFrame.trajectoryNameTfSetEnabled(false);
            mapInFrame.positionMarkerToFront();
        } else{
            ls.saveCurrentTrajectory();
            ddd.removeDataListener(routeDrawer);
            mapInFrame.trajectoryTbSetText("Iniciar trajetória");
            mapInFrame.trajectoryNameTfSetEnabled(true);
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
