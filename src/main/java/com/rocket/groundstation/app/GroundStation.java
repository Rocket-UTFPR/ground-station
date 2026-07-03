package com.rocket.groundstation.app;

import com.rocket.groundstation.controller.MainCtrl;
import com.rocket.groundstation.model.SettingsModel;
import com.rocket.groundstation.serial.services.DispatchService;
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
                
                AppCommons appCommons = new AppCommons(
                        new DispatchService<>(),
                        new DispatchService<>()
                );
                
                MainForm mainForm = new MainForm();
                
                MainCtrl mainController = new MainCtrl(mainForm, settingsModel, appCommons);
                mainController.start();
        });        
    }
}
