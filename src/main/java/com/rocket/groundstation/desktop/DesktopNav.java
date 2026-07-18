package com.rocket.groundstation.desktop;

import com.rocket.groundstation.app.TelemetryModel;
import com.rocket.groundstation.map.view.MapInFrame;
import com.rocket.groundstation.map.controller.MapInFrameCtrl;
import com.rocket.groundstation.map.service.TrajectoryManager;
import com.rocket.groundstation.serial.core.read.SerialReadService;
import com.rocket.groundstation.serial.serialmonitor.SerialMonitorInFrame;
import com.rocket.groundstation.serial.serialmonitor.SerialMonitorInFrameCtrl;
import com.rocket.groundstation.settings.SettingsInFrame;
import com.rocket.groundstation.settings.SettingsInFrameCtrl;
import com.rocket.groundstation.settings.SettingsModel;


public class DesktopNav {
    private SettingsModel settings;
    private SerialReadService<TelemetryModel> srs;
    private TrajectoryManager tm;
    private MapInFrameCtrl mapInFrCtrl;
    private SerialMonitorInFrameCtrl SerialMonitorInFrCtrl;
    private SettingsInFrameCtrl settingsInFrCtrl;
    
    public DesktopNav(SettingsModel settings){
        this.settings = settings;
        srs = new SerialReadService();
        tm = new TrajectoryManager();
    }
    
    public MapInFrame openMapInFrame(){
        if(mapInFrCtrl==null) mapInFrCtrl = new MapInFrameCtrl(new MapInFrame(), settings, srs, tm);
        
        return mapInFrCtrl.getMapInFrame();
    }
    
    public SerialMonitorInFrame openSerialMonitorInFrame(){
        if(SerialMonitorInFrCtrl==null) 
            SerialMonitorInFrCtrl = new SerialMonitorInFrameCtrl(new SerialMonitorInFrame(), settings, srs);
        
        return SerialMonitorInFrCtrl.getSerialMonitorInFrame();
    }
    
    public SettingsInFrame openSettingsInFrame(){
        if(settingsInFrCtrl==null) settingsInFrCtrl = new SettingsInFrameCtrl(new SettingsInFrame(), settings);
        
        return settingsInFrCtrl.getSettingsInFrame();
    }
}
