package com.rocket.groundstation.controller;

import com.rocket.groundstation.model.SettingsModel;
import com.rocket.groundstation.view.SerialMonitorInFrame;


public class SerialMonitorInFrameCtrl {
    private SerialMonitorInFrame serialMonitorInFrame;
    private SettingsModel settings;
    
    public SerialMonitorInFrameCtrl(SerialMonitorInFrame serialMonitorInFrame, SettingsModel settings){
        this.serialMonitorInFrame = serialMonitorInFrame;
        this.settings = settings;
    }
    
    public SerialMonitorInFrame getSerialMonitorInFrame(){
        return serialMonitorInFrame;
    }
}
