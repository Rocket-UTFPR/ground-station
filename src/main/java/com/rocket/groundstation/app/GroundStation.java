package com.rocket.groundstation.app;

import com.fazecast.jSerialComm.SerialPort;
import com.rocket.groundstation.controller.MainController;
import com.rocket.groundstation.model.SettingsModel;
import com.rocket.groundstation.service.DispatchService;
import com.rocket.groundstation.service.SerialReadService;
import com.rocket.groundstation.view.MainForm;
import javax.swing.SwingUtilities;


public class GroundStation {

    public static void main(String[] args) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }                
            }
        } catch (Exception ex) {}
        
        SwingUtilities.invokeLater(()->{
                SettingsModel settingsModel = new SettingsModel();
                MainForm mainForm = new MainForm();
                MainController mainController = new MainController(mainForm, settingsModel);
                mainController.start();
        });
//        DispatchService dispatcher = new DispatchService(null);        
//        dispatcher.addSerialDataListener((oldData, newData)->{
//            System.out.println(oldData);
//            System.out.println(newData);
//        });
//        SerialReadService srs = new SerialReadService(
//                dispatcher, 
//                SerialPort.getCommPorts()[0], 115200, SerialPort.TIMEOUT_READ_BLOCKING, 0,
//                34
//        );
//        srs.startSerialRead();
    }
}
