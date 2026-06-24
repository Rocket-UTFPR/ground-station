package com.rocket.groundstation.controller;

import com.rocket.groundstation.app.AppCommons;
import com.rocket.groundstation.model.*;
import com.rocket.groundstation.view.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import javax.swing.AbstractAction;


public class MainCtrl {
    private final MainForm mainForm;
    private SettingsModel settings;
    private AppCommons appCommons;
    private MapInFrameCtrl mapInFrCtrl;
    private SerialMonitorInFrameCtrl SerialMonitorInFrCtrl;
    private SettingsInFrameCtrl settingsInFrCtrl;
    

    public MainCtrl(MainForm mainForm, SettingsModel settings, AppCommons appCommons) {       
        this.mainForm = mainForm;
        this.settings = settings;
        this.appCommons = appCommons;
        
        addEventListeners();        
    }

    public void start() {
        mainForm.setVisible(true);
        
    }
    
    private void addEventListeners(){
        mainForm.addOpenMapBtListener((e)->openMapInFrame());
        mainForm.addOpenSerialMonitorBtListener((e)->openSerialMonitorInFrame());
        mainForm.addOpenSettingsBtListener((e)->openSettingsInFrame());
        mainForm.addToggleFullscreenAction(desktopToggleDisplayMode());
        
        settings.addPropertyChangeListener((e)->settingsChanged(e));
    }
    
    private void openMapInFrame(){
        if(mapInFrCtrl==null) mapInFrCtrl = new MapInFrameCtrl(new MapInFrame());
        
        mainForm.showInFrame(mapInFrCtrl.getMapInFrame());
    }
    
    private void openSerialMonitorInFrame(){
        if(SerialMonitorInFrCtrl==null) 
            SerialMonitorInFrCtrl = new SerialMonitorInFrameCtrl(new SerialMonitorInFrame(), settings, appCommons);
        
        mainForm.showInFrame(SerialMonitorInFrCtrl.getSerialMonitorInFrame());
    }
    
    private void openSettingsInFrame(){
        if(settingsInFrCtrl==null) settingsInFrCtrl = new SettingsInFrameCtrl(new SettingsInFrame(), settings);
        
        mainForm.showInFrame(settingsInFrCtrl.getSettingsInFrame());
    }
    
    private AbstractAction desktopToggleDisplayMode(){
        return new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(mainForm.getDisplayMode()==DisplayMode.WINDOWED) 
                    settings.setDisplayMode(mainForm.getOldDisplayMode());
                else settings.setDisplayMode(DisplayMode.WINDOWED);
            }
        };
    }
    
    private void settingsChanged(PropertyChangeEvent e){
        if(e.getPropertyName().equals("displayMode")) changeDisplayMode(e);
    }
    
    private void changeDisplayMode(PropertyChangeEvent e){
        if(e.getNewValue()!=null) mainForm.setDisplayMode((DisplayMode) e.getNewValue());
    }
}
