package com.rocket.groundstation.settings;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rocket.groundstation.telemetry.StandardDecoder;
import com.rocket.groundstation.serial.core.consume.SerialDataDecoder;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.nio.file.Path;
import java.nio.file.Paths;


public class SettingsModel {
    //-------General settings-------//
    private DisplayMode displayMode;
    @JsonProperty
    ("wallpaperPath") private String wallpaperPath;
    
    //-------Serial settings-------//
    @JsonIgnore
    private SerialDataDecoder decoder;
    private String decoderType; 
    private int bufferSize;
    private int timeOutMode;
    private int readTimeOut;
    
    //--------Map settings--------//
    @JsonProperty
    ("mapPath") private String mapPath;
    @JsonProperty
    ("renderThemePath") private String renderThemePath;
    @JsonProperty
    ("satRenderThemePath") private String satRenderThemePath;
    
    //----------Calculator settings----------//
    private int distanceSample;
    private int altSample;
    
    //---------- Misc ----------//
    @JsonIgnore private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    
    
    public SettingsModel(){
        displayMode = DisplayMode.WINDOWED;
        
        decoder = new StandardDecoder();
        decoderType = "appStandard";
        bufferSize = 38;
        timeOutMode = com.fazecast.jSerialComm.SerialPort.TIMEOUT_READ_BLOCKING;
        readTimeOut = 0;
        
        mapPath = "maps/mapa.map";
        renderThemePath = "maps/themes/Elevate.xml";
        satRenderThemePath = "maps/themes/sat.xml";
        
        distanceSample = 2;
        altSample = 2;
    }
    
    @JsonCreator
    public SettingsModel(
            @JsonProperty("displayMode") DisplayMode displayMode,
            @JsonProperty("wallpaperPath") String wallpaperPath,
            @JsonProperty("decoderType") String decoderType,
            @JsonProperty("bufferSize") int bufferSize,
            @JsonProperty("timeOutMode") int timeOutMode,
            @JsonProperty("readTimeOut") int readTimeOut,
            @JsonProperty("mapPath") String mapPath,
            @JsonProperty("renderThemePath") String renderThemePath,
            @JsonProperty("satRenderThemePath") String satRenderThemePath,
            @JsonProperty("distanceSample") int distanceSample,
            @JsonProperty("altSample") int altSample)
    {

        this.displayMode = displayMode;
        this.wallpaperPath = wallpaperPath;
        this.decoderType = decoderType;
        this.bufferSize = bufferSize;
        this.timeOutMode = timeOutMode;
        this.readTimeOut = readTimeOut;
        this.mapPath = mapPath;
        this.renderThemePath = renderThemePath;
        this.satRenderThemePath = satRenderThemePath;
        this.distanceSample = distanceSample;
        this.altSample = altSample;

        this.decoder = createDecoder(decoderType);
    }
    
    public DisplayMode getDisplayMode(){
        return displayMode;
    }
    
    public String getWallpaperPath(){
        return wallpaperPath;
    }

    public SerialDataDecoder getDecoder() {
        return decoder;
    }
    
    public String getDecoderType() {
        return decoderType;
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
    
    @JsonIgnore
    public Path getMapPath(){
        return Paths.get(mapPath);
    }
    
    @JsonIgnore
    public Path getRenderThemePath(){
        return Paths.get(renderThemePath);
    }
    
    @JsonIgnore
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
    
    public void setWallpaperPath(String wallpaperPath, boolean checkLastValue){
        if(checkLastValue && wallpaperPath.equals(this.wallpaperPath)) return;
        
        String old = this.wallpaperPath;
        this.wallpaperPath = wallpaperPath;
        pcs.firePropertyChange("wallpaperPath", old, displayMode);
    }
    
    public void setMapPath(String mapPath, boolean checkLastValue){
        if(checkLastValue && mapPath.equals(this.mapPath)) return;
        
        String old = this.mapPath;
        this.mapPath = mapPath;
        pcs.firePropertyChange("mapPath", old, mapPath);
    }
    
    public void setRenderThemePath(String renderThemePath, boolean checkLastValue){
        if(checkLastValue && renderThemePath.equals(this.renderThemePath)) return;
        
        String old = this.renderThemePath;
        this.renderThemePath = renderThemePath;
        pcs.firePropertyChange("renderThemePath", old, renderThemePath);
    }
    
    public void setSatRenderThemePath(String satRenderThemePath, boolean checkLastValue){
        if(checkLastValue && satRenderThemePath.equals(this.satRenderThemePath)) return;
        
        String old = this.satRenderThemePath;
        this.satRenderThemePath = satRenderThemePath;
        pcs.firePropertyChange("satRenderThemePath", old, satRenderThemePath);
    }
    
    public void setBufferSize(int bufferSize, boolean checkLastValue){
        if(checkLastValue && bufferSize==this.bufferSize) return;
        
        int old = this.bufferSize;
        this.bufferSize = bufferSize;
        pcs.firePropertyChange("bufferSize", old, bufferSize);
    }
    
    public void setTimeOutMode(int timeOutMode, boolean checkLastValue){
        if(checkLastValue && timeOutMode==this.timeOutMode) return;
        
        int old = this.timeOutMode;
        this.timeOutMode = timeOutMode;
        pcs.firePropertyChange("timeOutMode", old, timeOutMode);
    }
    
    public void setReadTimeOut(int readTimeOut, boolean checkLastValue){
        if(checkLastValue && readTimeOut==this.readTimeOut) return;
        
        int old = this.readTimeOut;
        this.readTimeOut = readTimeOut;
        pcs.firePropertyChange("readTimeOut", old, readTimeOut);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
    
    private SerialDataDecoder createDecoder(String decoderType) {
        return switch (decoderType) {
            case "appStandard" -> new StandardDecoder();
            default -> throw new IllegalArgumentException(
                    "Decoder inexistente: " + decoderType
            );
        };
    }
}
