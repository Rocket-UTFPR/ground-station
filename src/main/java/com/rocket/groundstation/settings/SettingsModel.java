package com.rocket.groundstation.settings;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
        
        mapPath = "maps/teste.map";
        renderThemePath = "maps/themes/Elevate.xml";
        satRenderThemePath = "maps/themes/sat.xml";
        
        distanceSample = 2;
        altSample = 2;
    }
    
    @JsonCreator
    public SettingsModel(
            @JsonProperty("displayMode") DisplayMode displayMode,
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
    
    public void setMapPath(String mapPath, boolean checkLastValue){
        if(checkLastValue && mapPath.equals(this.mapPath)) return;
        
        String old = this.mapPath;
        this.mapPath = mapPath;
        pcs.firePropertyChange("mapPath", old, mapPath);
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
