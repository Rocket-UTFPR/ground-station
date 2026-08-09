package com.rocket.groundstation.settings;

import com.rocket.groundstation.util.InFrameFixer;
import java.beans.PropertyChangeEvent;


public class SettingsInFrameCtrl {
    private SettingsInFrame settingsInFrame;
    private SettingsModel settings;
    
    public SettingsInFrameCtrl(SettingsInFrame settingsInFrame, SettingsModel settings){
        this.settingsInFrame = settingsInFrame;
        this.settings = settings;
        
        InFrameFixer.fix(this.settingsInFrame);
        
        restoreGeneralTab();
        restoreMapTab();
        restoreSerialTab();
        addListeners();
    }
    
    public SettingsInFrame getSettingsInFrame(){
        return settingsInFrame;
    }
    
    private void restoreGeneralTab(){
        settingsInFrame.displayModeCbSetDisplayMode(settings.getDisplayMode());
    }
    private void restoreMapTab(){
        settingsInFrame.mapPathTfSetText(settings.getMapPath().toString());
    }
    private void restoreSerialTab(){
        
    }
    
    
    private void addListeners(){
        settingsInFrame.addGeneralApplyBtListener((e)->generalApply());
        settingsInFrame.addMapApplyBtListener((e)->mapApply());
        settingsInFrame.addSerialApplyBtListener((e)->serialApply());
        settingsInFrame.addGeneralRestoreBtListener((e)->restoreGeneralTab());
        settingsInFrame.addMapRestoreBtListener((e)->restoreMapTab());
        settingsInFrame.addSerialRestoreBtListener((e)->restoreSerialTab());
        settings.addPropertyChangeListener((e)->settingsChanged(e));
    }
    
    private void generalApply(){
        settings.setDisplayMode(settingsInFrame.displayModeCbGetDisplayMode(), true);
    }
    
    private void mapApply(){
        settings.setMapPath(settingsInFrame.mapPathTfGetText(), true);
    }
    
    private void serialApply(){
        
    }
    
    private void settingsChanged(PropertyChangeEvent e){
        if(e.getPropertyName().equals("displayMode")) settingsInFrame.displayModeCbSetDisplayMode((DisplayMode) e.getNewValue());
    }
}
