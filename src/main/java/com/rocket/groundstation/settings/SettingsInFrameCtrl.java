package com.rocket.groundstation.settings;

import com.rocket.groundstation.util.InFrameFixer;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeEvent;


public class SettingsInFrameCtrl {
    private SettingsInFrame settingsInFrame;
    private SettingsModel settings;
    
    public SettingsInFrameCtrl(SettingsInFrame settingsInFrame, SettingsModel settings){
        this.settingsInFrame = settingsInFrame;
        this.settings = settings;
        
        InFrameFixer.fix(this.settingsInFrame);
        
        updateDisplayModeCb(settings.getDisplayMode());
        addListeners();
    }
    
    public SettingsInFrame getSettingsInFrame(){
        return settingsInFrame;
    }
    
    private void updateDisplayModeCb(DisplayMode dm){
        if(null!=dm) switch (dm) {
            case WINDOWED -> settingsInFrame.setDisplayModeCbSelected(0);
            case BORDERLESSWINDOW -> settingsInFrame.setDisplayModeCbSelected(1);
            case FULLSCREEN -> settingsInFrame.setDisplayModeCbSelected(2);
        }
    }
    
    private void addListeners(){
        settingsInFrame.addDisplayModeCbListener((il)->changeDisplayMode(il));
        settings.addPropertyChangeListener((e)->settingsChanged(e));
    }
    
    private void changeDisplayMode(ItemEvent il){
        DisplayMode dm = DisplayMode.valueOf(il.getItem());
        if(dm==settings.getDisplayMode() || il.getStateChange()==ItemEvent.DESELECTED) return;
        settings.setDisplayMode(dm);
    }
    
    private void settingsChanged(PropertyChangeEvent e){
        if(e.getPropertyName().equals("displayMode")) updateDisplayModeCb((DisplayMode) e.getNewValue());
    }
}
