package com.rocket.groundstation.map.controller;

import com.rocket.groundstation.exceptions.InvalidPathException;
import com.rocket.groundstation.app.TelemetryModel;
import com.rocket.groundstation.app.VelocityCalculator;
import com.rocket.groundstation.map.service.MapBuilder;
import com.rocket.groundstation.map.view.MapInFrame;
import com.rocket.groundstation.map.service.TrajectoryManager;
import com.rocket.groundstation.settings.SettingsModel;
import com.rocket.groundstation.serial.core.dispatch.DataListener;
import com.rocket.groundstation.serial.core.read.SerialReadService;
import com.rocket.groundstation.util.InFrameFixer;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ItemEvent;
import java.util.Locale;
import javax.swing.SwingUtilities;


public class MapInFrameCtrl {
    private MapInFrame mapInFrame;
    private SettingsModel settings;
    private SerialReadService<TelemetryModel> srs;
    private TrajectoryManager tm;
    private MapBuilder mb;
    private VelocityCalculator vc;
    private volatile double lastLatRead;
    private volatile double lastLonRead;
    private DataListener<TelemetryModel> displayUpdater;
    private DataListener<TelemetryModel> positionMarker;
    private DataListener<TelemetryModel> tracker;
    private DataListener<TelemetryModel> routeDrawer;
    
    public MapInFrameCtrl(
            MapInFrame mapInFrame, SettingsModel settings, 
            SerialReadService<TelemetryModel> srs, TrajectoryManager rs
    ){
        this.mapInFrame = mapInFrame;
        this.settings = settings;
        this.srs = srs;
        this.tm = rs;
        lastLatRead = -21.938391;
        lastLonRead = -48.950188;
        vc = new VelocityCalculator(settings.getNumberOfDistances());
        
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
                vc.addPoint(newData.getAltitude(), newData.getLatitude(), newData.getLongitude(), newData.getUptime());
                mapInFrame.infoLbSetText(
                        String.format(Locale.US, "%.6f", newData.getAltitude()),
                        String.format(Locale.US, "%.6f", newData.getLatitude()),
                        String.format(Locale.US, "%.6f", newData.getLongitude()),
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
                tm.trajectoryAddData(newData);
            });
        };
    }
    
    private void addListeners(){
        srs.getDecodedDataDispatcher().addDataListener(displayUpdater);
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
            srs.getDecodedDataDispatcher().addDataListener(positionMarker);
            mapInFrame.positionMarkerSetVisible(true);
        } else{
            mapInFrame.positionMarkerSetVisible(false);
            srs.getDecodedDataDispatcher().removeDataListener(positionMarker);
        }
    }
    
    private void trackPosition(ItemEvent e){
        if(e.getStateChange()==ItemEvent.SELECTED){
            mapInFrame.mapSetCenter(lastLatRead, lastLonRead);
            srs.getDecodedDataDispatcher().addDataListener(tracker);
        } else{
            srs.getDecodedDataDispatcher().removeDataListener(tracker);
        }
    }
    
    private void drawRoute(ItemEvent e){
        if(e.getStateChange()==ItemEvent.SELECTED){
            tm.startNewTrajectory(mapInFrame.getMap(), mapInFrame.trajectoryNameTfGetText());
            srs.getDecodedDataDispatcher().addDataListener(routeDrawer);
            mapInFrame.trajectoryTbSetText("Finalizar rota");
            mapInFrame.positionMarkerToFront();
        } else{
            srs.getDecodedDataDispatcher().removeDataListener(routeDrawer);
            mapInFrame.trajectoryTbSetText("Iniciar nova rota");
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
