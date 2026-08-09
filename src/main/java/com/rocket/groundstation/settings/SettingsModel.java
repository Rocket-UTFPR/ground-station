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
    private String mapPath;
    private String renderThemePath;
    private String satRenderThemePath;
    
    //----------Calculator settings----------//
    private int distanceSample;
    private int altSample;
    
    //---------- Misc ----------//
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    
    
    public SettingsModel(){
        displayMode = DisplayMode.WINDOWED;
        
        decoder = new StandardDecoder();
        bufferSize = 38;
        timeOutMode = com.fazecast.jSerialComm.SerialPort.TIMEOUT_READ_BLOCKING;
        readTimeOut = 0;
        
        mapPath = "maps/teste.map";
        renderThemePath = "maps/themes/Elevate.xml";
        satRenderThemePath = "maps/themes/sat.xml";
        
        distanceSample = 2;
        altSample = 2;
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
        return Paths.get(mapPath);
    }
    
    public Path getRenderThemePath(){
        return Paths.get(renderThemePath);
    }
    
    public Path getSatRenderThemePath(){
        return Paths.get(satRenderThemePath);
    }
    
    public int getDistanceSample(){
        return distanceSample;
    }
    
    public int getAltSample(){
        return altSample;
    }
    
    public void setDisplayMode(DisplayMode dm, boolean checkLastValue){
        if(checkLastValue && displayMode==dm) return;
        
        DisplayMode old = displayMode;
        displayMode = dm;
        pcs.firePropertyChange("displayMode", old, displayMode);
    }
    
    public void setMapPath(String mapPath, boolean checkLastValue){
        if(checkLastValue && mapPath.equals(this.mapPath)) return;
        
        String old = this.mapPath;
        this.mapPath = mapPath;
        pcs.firePropertyChange("mapPath", old, mapPath);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
}
