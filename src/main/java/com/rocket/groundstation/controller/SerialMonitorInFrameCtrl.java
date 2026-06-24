package com.rocket.groundstation.controller;

import com.fazecast.jSerialComm.SerialPort;
import com.rocket.groundstation.app.AppCommons;
import com.rocket.groundstation.model.SettingsModel;
import com.rocket.groundstation.serial.services.SerialReadService;
import com.rocket.groundstation.view.SerialMonitorInFrame;
import java.awt.event.ItemEvent;


public class SerialMonitorInFrameCtrl {
    private SerialMonitorInFrame serialMonitorInFrame;
    private SettingsModel settings;
    private AppCommons appCommons;
    private SerialPort port;
    private boolean readingSerial;
    
    public SerialMonitorInFrameCtrl(SerialMonitorInFrame serialMonitorInFrame,
            SettingsModel settings, AppCommons appCommons
    ){
        this.serialMonitorInFrame = serialMonitorInFrame;
        this.settings = settings;
        this.appCommons = appCommons;
        this.readingSerial = false;
        port = SerialPort.getCommPorts()[0];
        
        updatePortsCb();        
        dispatcherSetUp();
        addListeners();
    }
    
    public SerialMonitorInFrame getSerialMonitorInFrame(){
        return serialMonitorInFrame;
    }
    
    public boolean isReadingSerial(){
        return readingSerial;
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
    
    private void dispatcherSetUp(){
        appCommons.getRawDataDispatcher().addSerialDataListener((oldData, newData)->{
            serialMonitorInFrame.appendBytes(newData);
        });
    }
    
    private void addListeners(){
        serialMonitorInFrame.addPortsCbListener((e)->portsCbListener(e));
        serialMonitorInFrame.addSerialReadTbListener((e)->toggleSerialRead());
    }
    
    private void portsCbListener(ItemEvent e){
        System.out.println("aaaa");
        port = SerialPort.getCommPort(serialMonitorInFrame.getSelectedPort());
    }
    
    private void toggleSerialRead(){
        if(!readingSerial){
            port = SerialPort.getCommPort(serialMonitorInFrame.getSelectedPort());
            
            SerialReadService srs = new SerialReadService(
                    settings.getDecoder(), 
                    appCommons.getRawDataDispatcher(), appCommons.getDecodedDataDispatcher(), 
                    port, serialMonitorInFrame.getSelectedBaud(), 
                    settings.getTimeOutMode(), settings.getReadTimeOut(), settings.getBufferSize()
            );
            try{
                srs.startSerialRead();
                readingSerial = true;
                serialMonitorInFrame.portsCbSetEnabled(false);
            } catch(Exception ex){}
        } else{
            //stop reading
            //readingSerial = false;
            serialMonitorInFrame.portsCbSetEnabled(true);
        }
    }
}
