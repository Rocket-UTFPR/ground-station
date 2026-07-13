package com.rocket.groundstation.desktop;

import com.rocket.groundstation.app.AppCommons;
import com.rocket.groundstation.map.MapInFrame;
import com.rocket.groundstation.map.MapInFrameCtrl;
import com.rocket.groundstation.serial.serialmonitor.SerialMonitorInFrame;
import com.rocket.groundstation.serial.serialmonitor.SerialMonitorInFrameCtrl;
import com.rocket.groundstation.settings.SettingsInFrame;
import com.rocket.groundstation.settings.SettingsInFrameCtrl;
import com.rocket.groundstation.settings.SettingsModel;


public class DesktopService {
    private SettingsModel settings;
    private AppCommons appCommons;
    private MapInFrameCtrl mapInFrCtrl;
    private SerialMonitorInFrameCtrl SerialMonitorInFrCtrl;
    private SettingsInFrameCtrl settingsInFrCtrl;
    
    public DesktopService(SettingsModel settings, AppCommons appCommons){
        this.settings = settings;
        this.appCommons = appCommons;
    }
    
    public MapInFrame openMapInFrame(){
        if(mapInFrCtrl==null) mapInFrCtrl = new MapInFrameCtrl(new MapInFrame(), settings, appCommons);
        
        return mapInFrCtrl.getMapInFrame();
    }
    
    public SerialMonitorInFrame openSerialMonitorInFrame(){
        if(SerialMonitorInFrCtrl==null) 
            SerialMonitorInFrCtrl = new SerialMonitorInFrameCtrl(new SerialMonitorInFrame(), settings, appCommons);
        
        return SerialMonitorInFrCtrl.getSerialMonitorInFrame();
    }
    
    public SettingsInFrame openSettingsInFrame(){
        if(settingsInFrCtrl==null) settingsInFrCtrl = new SettingsInFrameCtrl(new SettingsInFrame(), settings);
        
        return settingsInFrCtrl.getSettingsInFrame();
    }
}
