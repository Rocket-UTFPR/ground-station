package com.rocket.groundstation.settings;

import com.fazecast.jSerialComm.SerialPort;
import com.rocket.groundstation.util.InFrameFixer;
import java.beans.PropertyChangeEvent;
import java.io.IOException;


public class SettingsInFrameCtrl {
    private SettingsInFrame settingsInFrame;
    private SettingsModel settings;
    
    public SettingsInFrameCtrl(SettingsInFrame settingsInFrame, SettingsModel settings){
        this.settingsInFrame = settingsInFrame;
        this.settings = settings;
        
        InFrameFixer.fix(this.settingsInFrame);
        
        restoreGeneralTab();
        restoreMapTab();
        restoreSerialTab();
        addListeners();
    }
    
    public SettingsInFrame getSettingsInFrame(){
        return settingsInFrame;
    }
    
    private void restoreGeneralTab(){
        settingsInFrame.displayModeCbSetDisplayMode(settings.getDisplayMode());
        settingsInFrame.wpPathTfSetText(settings.getWallpaperPath());
    }
    private void restoreMapTab(){
        settingsInFrame.mapPathTfSetText(settings.getMapPath().toString());
        settingsInFrame.themePathTfSetText(settings.getRenderThemePath().toString());
        settingsInFrame.satThemePathTfSetText(settings.getSatRenderThemePath().toString());
    }
    private void restoreSerialTab(){
        settingsInFrame.bufferSizeSpnrSetValue(settings.getBufferSize());
        switch(settings.getTimeOutMode()){
            case SerialPort.TIMEOUT_NONBLOCKING -> settingsInFrame.timeOutModeCbSetMode("Não Bloqueante");
            case SerialPort.TIMEOUT_READ_SEMI_BLOCKING -> settingsInFrame.timeOutModeCbSetMode("Semi Bloqueante");
            case SerialPort.TIMEOUT_READ_BLOCKING -> settingsInFrame.timeOutModeCbSetMode("Bloqueante");
        }
        settingsInFrame.readTimeOutSpnrSetValue(settings.getReadTimeOut());
    }
    
    
    private void addListeners(){
        settingsInFrame.addGeneralApplyBtListener((e)->generalApply());
        settingsInFrame.addMapApplyBtListener((e)->mapApply());
        settingsInFrame.addSerialApplyBtListener((e)->serialApply());
        settingsInFrame.addGeneralRestoreBtListener((e)->restoreGeneralTab());
        settingsInFrame.addMapRestoreBtListener((e)->restoreMapTab());
        settingsInFrame.addSerialRestoreBtListener((e)->restoreSerialTab());
        settings.addPropertyChangeListener((e)->settingsChanged(e));
    }
    
    private void generalApply(){
        settings.setDisplayMode(settingsInFrame.displayModeCbGetDisplayMode(), true);
        settings.setWallpaperPath(settingsInFrame.wpPathTfGetText(), true);
    }
    
    private void mapApply(){
        settings.setMapPath(settingsInFrame.mapPathTfGetText(), true);
        settings.setRenderThemePath(settingsInFrame.themePathTfGetText(), true);
        settings.setSatRenderThemePath(settingsInFrame.satThemePathTfGetText(), true);
    }
    
    private void serialApply(){
        settings.setBufferSize(settingsInFrame.bufferSizeSpnrGetValue(), true);
        switch(settingsInFrame.timeOutModeCbGetSelected()){
            case "Não Bloqueante" -> settings.setTimeOutMode(SerialPort.TIMEOUT_NONBLOCKING, true);
            case "Semi Bloqueante" -> settings.setTimeOutMode(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, true);
            case "Bloqueante" -> settings.setTimeOutMode(SerialPort.TIMEOUT_READ_BLOCKING, true);
        }
        settings.setReadTimeOut(settingsInFrame.readTimeOutSpnrGetValue(), true);
    }
    
    private void settingsChanged(PropertyChangeEvent e){
        try {
            SettingsService.save(settings);
        } catch (IOException ex) {
            settingsInFrame.showErrorMsg(ex.getMessage(), "Erro ao salvar as configurações no arquivo");
        }
        
        if(e.getPropertyName().equals("displayMode")) settingsInFrame.displayModeCbSetDisplayMode((DisplayMode) e.getNewValue());
    }
}
