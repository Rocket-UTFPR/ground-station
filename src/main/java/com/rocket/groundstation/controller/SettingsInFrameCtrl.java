package com.rocket.groundstation.controller;

import com.rocket.groundstation.model.DisplayMode;
import com.rocket.groundstation.model.SettingsModel;
import com.rocket.groundstation.view.SettingsInFrame;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeEvent;


public class SettingsInFrameCtrl {
    private SettingsInFrame settingsInFrame;
    private SettingsModel settings;
    
    public SettingsInFrameCtrl(SettingsInFrame settingsInFrame, SettingsModel settings){
        this.settingsInFrame = settingsInFrame;
        this.settings = settings;
        updateDisplayModeCb(settings.getDisplayMode());
        
        settingsInFrame.addDisplayModeCbListener((il)->changeDisplayMode(il));
        settings.addPropertyChangeListener((e)->settingsChanged(e));
    }
    
    public SettingsInFrame getSettingsInFrame(){
        return settingsInFrame;
    }
    
    private void changeDisplayMode(ItemEvent il){        
        if(DisplayMode.valueOf(il.getItem())==settings.getDisplayMode() 
                || il.getStateChange()==ItemEvent.DESELECTED) return;
        settings.setDisplayMode(il.getItem());
    }
    
    private void settingsChanged(PropertyChangeEvent e){
        if(e.getPropertyName().equals("displayMode")) updateDisplayModeCb((DisplayMode) e.getNewValue());
    }
    
    private void updateDisplayModeCb(DisplayMode dm){
        if(null!=dm) switch (dm) {
            case WINDOWED -> settingsInFrame.setDisplayModeCbSelected(0);
            case BORDERLESSWINDOW -> settingsInFrame.setDisplayModeCbSelected(1);
            case FULLSCREEN -> settingsInFrame.setDisplayModeCbSelected(2);
        }
    }
}
