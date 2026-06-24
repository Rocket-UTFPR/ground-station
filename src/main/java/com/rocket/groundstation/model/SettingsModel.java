package com.rocket.groundstation.model;

import com.rocket.groundstation.service.StandardDecoder;
import com.rocket.groundstation.serial.interfaces.SerialDataDecoder;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class SettingsModel {
    //-----General settings-----//
    private DisplayMode displayMode;
    
    //-----Serial settings-----//
    private SerialDataDecoder decoder;
    private int bufferSize;
    private int timeOutMode;
    private int readTimeOut;
    
    //--------- Misc ---------//
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    
    public SettingsModel(){
        displayMode = DisplayMode.WINDOWED;
        
        decoder = new StandardDecoder();
        bufferSize = 64;
        timeOutMode = com.fazecast.jSerialComm.SerialPort.TIMEOUT_READ_SEMI_BLOCKING;
        readTimeOut = 0;
    }
    
    public void setDisplayMode(Object o){
        DisplayMode old = displayMode;
        displayMode = DisplayMode.valueOf(o);
    
        pcs.firePropertyChange("displayMode", old, displayMode);
    }
    
    public void setDisplayMode(DisplayMode dm){
        DisplayMode old = displayMode;
        displayMode = dm;
    
        pcs.firePropertyChange("displayMode", old, displayMode);
    }
    
    public DisplayMode getDisplayMode(){
        return displayMode;
    }

    public SerialDataDecoder getDecoder() {
        return decoder;
    }

    public int getBufferSize() {
        return bufferSize;
    }

    public int getTimeOutMode() {
        return timeOutMode;
    }

    public int getReadTimeOut() {
        return readTimeOut;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
}
