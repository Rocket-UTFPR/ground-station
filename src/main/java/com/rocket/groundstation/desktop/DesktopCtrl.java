package com.rocket.groundstation.desktop;

import com.rocket.groundstation.settings.DisplayMode;
import com.rocket.groundstation.settings.SettingsModel;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import javax.swing.AbstractAction;


public class DesktopCtrl {
    private final DesktopForm desktopForm;
    private SettingsModel settings;
    private DesktopNav desktop;

    public DesktopCtrl(DesktopForm desktopForm, SettingsModel settings, DesktopNav desktop) {       
        this.desktopForm = desktopForm;
        this.settings = settings;
        this.desktop = desktop;
        
        addListeners();        
    }

    public void start() {
        desktopForm.setVisible(true);
    }
    
    private void addListeners(){
        desktopForm.addOpenMapBtListener((e)->desktopForm.showInFrame(desktop.openMapInFrame()));
        desktopForm.addOpenLayersBtListener((e)->desktopForm.showInFrame(desktop.openLayersInFrame()));
        desktopForm.addOpenSerialMonitorBtListener((e)->desktopForm.showInFrame(desktop.openSerialMonitorInFrame()));
        desktopForm.addOpenFileBtListener((e)->desktopForm.showInFrame(desktop.openFileInFrame()));
        desktopForm.addOpenSettingsBtListener((e)->desktopForm.showInFrame(desktop.openSettingsInFrame()));
        desktopForm.addToggleFullscreenAction(desktopToggleDisplayMode());
        
        settings.addPropertyChangeListener((e)->settingsChanged(e));
    }
    
    private AbstractAction desktopToggleDisplayMode(){
        return new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(desktopForm.getDisplayMode()==DisplayMode.WINDOWED) 
                    settings.setDisplayMode(desktopForm.getOldDisplayMode(), true);
                else settings.setDisplayMode(DisplayMode.WINDOWED, true);
            }
        };
    }
    
    private void settingsChanged(PropertyChangeEvent e){
        if(e.getPropertyName().equals("displayMode")) changeDisplayMode(e);
    }
    
    private void changeDisplayMode(PropertyChangeEvent e){
        if(e.getNewValue()!=null) desktopForm.setDisplayMode((DisplayMode) e.getNewValue());
    }
}
