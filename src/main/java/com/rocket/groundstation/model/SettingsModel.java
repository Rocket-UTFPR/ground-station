package com.rocket.groundstation.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class SettingsModel {
    private DisplayMode displayMode;    
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    
    public SettingsModel(){
        displayMode = DisplayMode.WINDOWED;
    }
    
    public void setDisplayMode(Object o){
        DisplayMode old = displayMode;
        displayMode = DisplayMode.getDisplayMode(o);
    
        pcs.firePropertyChange("displayMode", old, displayMode);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
}
