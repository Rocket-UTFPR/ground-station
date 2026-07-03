package com.rocket.groundstation.controller;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortInvalidPortException;
import com.rocket.groundstation.app.AppCommons;
import com.rocket.groundstation.model.SerialData;
import com.rocket.groundstation.model.SettingsModel;
import com.rocket.groundstation.serial.exceptions.CantOpenPortException;
import com.rocket.groundstation.serial.services.SerialReadService;
import com.rocket.groundstation.service.InFrameFixer;
import com.rocket.groundstation.view.SerialMonitorInFrame;
import java.awt.event.ItemEvent;
import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;


public class SerialMonitorInFrameCtrl {
    private SerialMonitorInFrame serialMonitorInFrame;
    private SettingsModel settings;
    private AppCommons appCommons;
    private SerialReadService<SerialData> srs;
    
    public SerialMonitorInFrameCtrl(SerialMonitorInFrame serialMonitorInFrame,
            SettingsModel settings, AppCommons appCommons
    ){
        this.serialMonitorInFrame = serialMonitorInFrame;
        this.settings = settings;
        this.appCommons = appCommons;
        
        new InFrameFixer().fix(this.serialMonitorInFrame);
        
        updatePortsCb();
        dispatcherSetup();
        addListeners();
    }
    
    public SerialMonitorInFrame getSerialMonitorInFrame(){
        return serialMonitorInFrame;
    }
    
    private void updatePortsCb(){
        SerialPort[] serialPorts = SerialPort.getCommPorts();
        String[] systemPortNames = new String[serialPorts.length];
        int i = 0;
        for(SerialPort serialPort : serialPorts){
            systemPortNames[i] = serialPort.getSystemPortName();
        }
        serialMonitorInFrame.updatePortsCb(systemPortNames);
    }
    
    private void dispatcherSetup(){
        appCommons.getRawDataDispatcher().addDataListener((oldData, newData)->{
            SwingUtilities.invokeLater(()->serialMonitorInFrame.appendBytes(newData));
        });
    }
    
    private void addListeners(){
        serialMonitorInFrame.addPortsCbListener(portsCbListener());
        serialMonitorInFrame.addSerialReadTbListener((e)->toggleSerialRead(e));
        serialMonitorInFrame.addAutoScrollTbListener((e)->serialMonitorInFrame.toggleAutoScroll());
        serialMonitorInFrame.addBaudCbListener((e)->updateBaudRate());
    }
    
    private PopupMenuListener portsCbListener(){
        return new PopupMenuListener(){
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {updatePortsCb();}
            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {}
        };
    }
    
    private void toggleSerialRead(ItemEvent e){
        if(e.getStateChange() == ItemEvent.SELECTED){
            try{
                srs = new SerialReadService<>(
                        settings.getDecoder(), 
                        appCommons.getRawDataDispatcher(), appCommons.getDecodedDataDispatcher(), 
                        SerialPort.getCommPort(serialMonitorInFrame.getSelectedPort()),
                        serialMonitorInFrame.getSelectedBaud(), 
                        settings.getTimeOutMode(), settings.getReadTimeOut(), settings.getBufferSize()
                );
                srs.startSerialRead();
                serialMonitorInFrame.portsCbSetEnabled(false);
            } catch(SerialPortInvalidPortException | IllegalArgumentException ex){
                serialMonitorInFrame.showErrorMsg("Porta não selecionada", "Erro");
                serialMonitorInFrame.deselectSerialReadTb();
            } catch(CantOpenPortException ex){
                serialMonitorInFrame.showErrorMsg("Não se pôde abrir a porta selecionada", "Erro");
                serialMonitorInFrame.deselectSerialReadTb();
            }
        } else{
            if(srs!=null) srs.stopSerialRead();
            serialMonitorInFrame.portsCbSetEnabled(true);
        }
    }
    
    private void updateBaudRate(){
        if(srs!=null) srs.setPortBaudRate(serialMonitorInFrame.getSelectedBaud());
    }
}
