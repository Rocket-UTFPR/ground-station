package com.rocket.groundstation.controller;

import com.rocket.groundstation.model.*;
import com.rocket.groundstation.view.*;
import java.beans.PropertyChangeEvent;


public class MainController {
    private final MainForm mainForm;
    private SettingsModel settings;
    private MapInFrameController mapInFrameCtrl;
    private SettingsInFrameController settingsInFrameCtrl;
    

    public MainController(MainForm mainForm, SettingsModel settings) {       
        this.mainForm = mainForm;
        this.settings = settings;
        
        mainForm.addOpenMapBtListener((e)->openMapInFrame());
        mainForm.addOpenSettingsBtListener((e)->openSettingsInFrame());
        settings.addPropertyChangeListener((e)->settingsChanged(e));
    }

    public void start() {
        mainForm.setVisible(true);
        
    }
    
    private void openMapInFrame(){
        if(mapInFrameCtrl==null) mapInFrameCtrl = new MapInFrameController(new MapInFrame());
        mainForm.showInFrame(mapInFrameCtrl.getMapInFrame());
    }
    
    private void openSettingsInFrame(){
        if(settingsInFrameCtrl==null) 
            settingsInFrameCtrl = new SettingsInFrameController(new SettingsInFrame(), settings);
        mainForm.showInFrame(settingsInFrameCtrl.getSettingsInFrame());
    }
    
    private void settingsChanged(PropertyChangeEvent e){
        if(e.getPropertyName().equals("displayMode")) changeDisplayMode(e);
    }
    
    private void changeDisplayMode(PropertyChangeEvent e){
        if(e.getNewValue()!=null) mainForm.setDisplayMode((DisplayMode) e.getNewValue());
    }
}
