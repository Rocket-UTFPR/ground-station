package com.rocket.groundstation.settings;

import com.rocket.groundstation.app.StandardDecoder;
import com.rocket.groundstation.serial.core.consume.SerialDataDecoder;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.nio.file.Path;
import java.nio.file.Paths;


public class SettingsModel {
    //-------General settings-------//
    private DisplayMode displayMode;
    
    //-------Serial settings-------//
    private SerialDataDecoder decoder;
    private int bufferSize;
    private int timeOutMode;
    private int readTimeOut;
    
    //--------Map settings--------//
    private final String mapDirectory;
    private final String mapThemesDirectory;
    private String mapFileName;
    private String renderThemeSubPath;
    
    //--------- Misc ---------//
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    
    
    public SettingsModel(){
        displayMode = DisplayMode.WINDOWED;
        
        decoder = new StandardDecoder();
        bufferSize = 38;
        timeOutMode = com.fazecast.jSerialComm.SerialPort.TIMEOUT_READ_BLOCKING;
        readTimeOut = 0;
        
        mapDirectory = "maps";
        mapThemesDirectory = "maps/themes";
        mapFileName = "teste.map";
        renderThemeSubPath = "Elevate.xml";
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
    
    public Path getMapPath(){
        return Paths.get(mapDirectory, mapFileName);
    }
    
    public Path getRenderThemePath(){
        return Paths.get(mapThemesDirectory, renderThemeSubPath);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
}
