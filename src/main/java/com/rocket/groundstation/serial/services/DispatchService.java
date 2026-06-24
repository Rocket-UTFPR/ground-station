package com.rocket.groundstation.serial.services;

import com.rocket.groundstation.serial.interfaces.DataDispatcher;
import java.util.concurrent.CopyOnWriteArrayList;
import com.rocket.groundstation.serial.interfaces.DataListener;


public class DispatchService<T> implements DataDispatcher<T>{
    private T oldData;
    private final CopyOnWriteArrayList<DataListener<T>> dataListeners;
    
    public DispatchService(){
        oldData = null;
        dataListeners = new CopyOnWriteArrayList<>();
    }
    
    @Override
    public void dispatch(T newData){
        fireOnData(newData);
        oldData = newData;
    }
    
    public void addSerialDataListener(DataListener<T> sdl){
        dataListeners.add(sdl);
    }
    
    public void removeSerialDataListener(DataListener<T> sdl){
        dataListeners.remove(sdl);
    }
    
    public void fireOnData(T newData){
        dataListeners.forEach((dl)->{dl.onData(oldData, newData);});
    }
}
