package com.rocket.groundstation.map.controller;

import com.rocket.groundstation.custom.raven.TableActionEvent;
import com.rocket.groundstation.map.model.Marker;
import com.rocket.groundstation.map.model.Trajectory;
import com.rocket.groundstation.map.service.LayerService;
import com.rocket.groundstation.map.view.LayersInFrame;
import com.rocket.groundstation.map.view.MarkerDialog;
import com.rocket.groundstation.telemetry.TelemetryAnalyzer;
import com.rocket.groundstation.telemetry.TelemetryModel;
import com.rocket.groundstation.util.GpsUtils;
import com.rocket.groundstation.util.InFrameFixer;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class LayersInFrameCtrl {
    private LayersInFrame layersInFrame;
    private LayerService ls;
    private Trajectory detailTrajectory;
    
    public LayersInFrameCtrl(LayersInFrame layersInFrame, LayerService ls){
        this.layersInFrame = layersInFrame;
        this.ls = ls;
        
        layersInFrame.updateMarkersTable(ls.getMarkers());
        
        InFrameFixer.fix(layersInFrame);
        
        addListeners();
    }
    
    public LayersInFrame getLayersInFrame(){
        return layersInFrame;
    }
    
    private void tabPane(){
        switch(layersInFrame.getTabIndex()){
            case 0 -> {
                layersInFrame.updateMarkersTable(ls.getMarkers());
            }
            
            case 1 -> {
                layersInFrame.updateTrajectoryTable(ls.getTrajectories());
            }
            
            case 2 -> {
                updateDetailTab();
            }
            
            default -> {}
        }
    }
    
    private void updateDetailTab(){
        if(detailTrajectory==null) return;
        
        TelemetryAnalyzer ta = new TelemetryAnalyzer(detailTrajectory.getTelemetryData());
        ta.updateValues();
        
        TelemetryModel launch = ta.getLaunch();
        TelemetryModel apogee = ta.getApogee();
        TelemetryModel impact = ta.getImpact();
        
        if(launch==null) launch = new TelemetryModel();
        if(apogee==null) apogee = new TelemetryModel();
        if(impact==null) impact = new TelemetryModel();
            
        layersInFrame.updateDetailTab(
                detailTrajectory, launch, apogee, impact, ta.getAscentVelocity(), ta.getDescentVelocity()
        );
    }
    
    private void addListeners(){
        layersInFrame.addTabPaneListener((e)->tabPane());
        
        layersInFrame.addMarkersTableActionBtListener(markersActionBtListener());
        layersInFrame.addMarkersTableListener(markersMouseListener());
        layersInFrame.addNewMarkerBtListener((e)->newMarker());
        
        layersInFrame.addTrajTableActionBtListener(trajActionBtListener());
        layersInFrame.addTrajectoriesTableListener(trajMouseListener());
    }
    
    // <editor-fold defaultstate="collapsed" desc="Tab 1 - Markers">
    private TableActionEvent markersActionBtListener(){
        return new TableActionEvent(){
            @Override
            public void onEdit(int row) {
                Marker marker = layersInFrame.getMarker(row);
                
                MarkerDialog md = new MarkerDialog(SwingUtilities.getWindowAncestor(layersInFrame), "Editar marcador");
                md.nameTfSetText(marker.getName());
                md.latTfSetText(GpsUtils.format(marker.getCircle().getPosition().getLatitude()));
                md.lonTfSetText(GpsUtils.format(marker.getCircle().getPosition().getLongitude()));
                md.addConfirmBtListener((e)->{
                    try{
                        double lat = GpsUtils.validateLat(md.latTfGetText());
                        double lon = GpsUtils.validateLon(md.lonTfGetText());
                        
                        marker.setName(md.nameTfGetText());
                        marker.setPosition(lat, lon);
                        
                        md.dispose();
                        layersInFrame.updateMarkersTable(ls.getMarkers());
                    } catch(NumberFormatException ex){
                        md.showErrorMsg("Use apenas números e ponto", "Formato inválido");
                    } catch(IllegalArgumentException ex){
                        md.showErrorMsg(ex.getMessage(), "Valor inválido");
                    }
                });
                md.setVisible(true);
            }
            @Override
            public void onDelete(int row) {
                if(layersInFrame.showConfirmDialog(
                        "Tem certeza que quer deletar o marcador?", "Deletar", JOptionPane.WARNING_MESSAGE
                )){
                    layersInFrame.stopCellEditing();
                    ls.deleteMarker(layersInFrame.getMarker(row));
                    layersInFrame.updateMarkersTable(ls.getMarkers());
                }
            }
            @Override
            public void onView(int row) {
                layersInFrame.getMarker(row).toggleVisibility();
            }
        };
    }

    private MouseAdapter markersMouseListener(){
        return new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(layersInFrame.markersTableColorCellSelected()){
                    Marker marker = layersInFrame.getSelectedMarker();

                    Color newColor = layersInFrame.showColorChooser(marker.getColor());
                    if(newColor!=null){
                        marker.setColor(newColor);
                        layersInFrame.updateMarkersTable(ls.getMarkers());
                    }
                } else if(layersInFrame.markersTablePositionCellSelected()){
                    Marker marker = layersInFrame.getSelectedMarker();
                    marker.centralize();
                }
            }
        };
    }
    
    private void newMarker(){
        MarkerDialog md = new MarkerDialog(SwingUtilities.getWindowAncestor(layersInFrame), "Novo marcador");
        md.addConfirmBtListener((e)->{
            try{
                ls.addMarker(
                        md.nameTfGetText(),
                        GpsUtils.validateLat(md.latTfGetText()),
                        GpsUtils.validateLon(md.lonTfGetText())
                );
                md.dispose();
                layersInFrame.updateMarkersTable(ls.getMarkers());
            } catch(NumberFormatException ex){
                md.showErrorMsg("Use apenas números e ponto", "Formato inválido");
            } catch(IllegalArgumentException ex){
                md.showErrorMsg(ex.getMessage(), "Valor inválido");
            }
        });
        md.setVisible(true);
    }
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Tab 2 - Trajectories">
    private TableActionEvent trajActionBtListener(){
        return new TableActionEvent(){
            @Override
            public void onEdit(int row) {
                detailTrajectory = layersInFrame.getTrajectory(row);
                layersInFrame.setTabIndex(2);
            }
            @Override
            public void onDelete(int row) {
                if(layersInFrame.showConfirmDialog(
                        "Tem certeza que quer deletar o trajeto?", "Deletar", JOptionPane.WARNING_MESSAGE
                )){
                    layersInFrame.stopCellEditing();
                    ls.deleteTrajectory(layersInFrame.getTrajectory(row));
                    layersInFrame.updateTrajectoryTable(ls.getTrajectories());
                }
            }
            @Override
            public void onView(int row) {
                layersInFrame.getTrajectory(row).toggleVisibility();
            }
        };
    }

    private MouseAdapter trajMouseListener(){
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(layersInFrame.trajTableColorCellSelected()){
                    Trajectory trajectory = layersInFrame.getSelectedTrajectory();

                    Color newColor = layersInFrame.showColorChooser(trajectory.getColor());
                    if(newColor!=null){
                        trajectory.setColor(newColor);
                        layersInFrame.updateTrajectoryTable(ls.getTrajectories());
                    }
                } else if(layersInFrame.trajTableNameCellSelected()){
                    Trajectory trajectory = layersInFrame.getSelectedTrajectory();
                    
                    String newName = layersInFrame.showNameInputDialog();
                    
                    if(newName!=null){
                        trajectory.setName(newName.trim());
                        layersInFrame.updateTrajectoryTable(ls.getTrajectories());
                    }
                }
            }
        };
    }
    // </editor-fold>
}
