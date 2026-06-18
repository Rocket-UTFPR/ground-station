package com.rocket.groundstation.controller;

import com.rocket.groundstation.model.SettingsModel;
import com.rocket.groundstation.view.SettingsInFrame;
import java.awt.event.ItemEvent;


public class SettingsInFrameController {
    private SettingsInFrame settingsInFrame;
    private SettingsModel settings;
    
    public SettingsInFrameController(SettingsInFrame settingsInFrame, SettingsModel settings){
        this.settingsInFrame = settingsInFrame;
        this.settings = settings;
        
        settingsInFrame.addDisplayModeListenerCb((il)->changeDisplayMode(il));
    }
    
    public SettingsInFrame getSettingsInFrame(){
        return settingsInFrame;
    }
    
    private void changeDisplayMode(ItemEvent il){
        settings.setDisplayMode(il.getItem());
    }
}
