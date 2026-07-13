package com.rocket.groundstation.serial.core.dispatch;

import com.rocket.groundstation.serial.core.dispatch.DataDispatcher;
import java.util.concurrent.CopyOnWriteArrayList;
import com.rocket.groundstation.serial.core.dispatch.DataListener;


public class DataDispatchService<T> implements DataDispatcher<T>{
    private T oldData;
    private final CopyOnWriteArrayList<DataListener<T>> dataListeners;
    
    public DataDispatchService(){
        oldData = null;
        dataListeners = new CopyOnWriteArrayList<>();
    }
    
    @Override
    public void dispatch(T newData){
        fireOnData(newData);
        oldData = newData;
    }
    
    public void addDataListener(DataListener<T> sdl){
        dataListeners.add(sdl);
    }
    
    public void removeDataListener(DataListener<T> sdl){
        dataListeners.remove(sdl);
    }
    
    public void fireOnData(T newData){
        dataListeners.forEach((dl)->{dl.onData(oldData, newData);});
    }
}
