package com.rocket.groundstation.service;

import com.rocket.groundstation.model.TelemetryModel;
import java.util.concurrent.CopyOnWriteArrayList;
import com.rocket.groundstation.interfaces.SerialDataListener;
import com.rocket.groundstation.model.SerialData;


public class DispatchService {
    private SerialData data;
    private TelemetryModel model;
    private CopyOnWriteArrayList<SerialDataListener> dataListeners;    
    
    public DispatchService(TelemetryModel model){
        this.model = model;
        dataListeners = new CopyOnWriteArrayList<>();
        
    }
    
    public void dispatch(SerialData newData){
        dataListeners.forEach((dl)->{dl.onData(data, newData);});
        data = newData;
    }
    
    public void addSerialDataListener(SerialDataListener sdl){
        dataListeners.add(sdl);
    }
    
    public void removeSerialDataListener(SerialDataListener sdl){
        dataListeners.remove(sdl);
    }
        
}
