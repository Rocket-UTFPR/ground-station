package com.rocket.groundstation.serial.core.dispatch;

import java.util.concurrent.CopyOnWriteArrayList;


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
    
    @Override
    public void addDataListener(DataListener<T> dl){
        dataListeners.add(dl);
    }
    
    @Override
    public void removeDataListener(DataListener<T> dl){
        dataListeners.remove(dl);
    }
    
    private void fireOnData(T newData){
        dataListeners.forEach((dl)->{dl.onData(oldData, newData);});
    }
}
