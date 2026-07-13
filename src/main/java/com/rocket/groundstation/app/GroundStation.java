package com.rocket.groundstation.app;

import com.rocket.groundstation.desktop.DesktopCtrl;
import com.rocket.groundstation.settings.SettingsModel;
import com.rocket.groundstation.serial.core.dispatch.DataDispatchService;
import com.rocket.groundstation.desktop.DesktopForm;
import com.rocket.groundstation.desktop.DesktopService;
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
                SettingsModel settings = new SettingsModel();
                
                AppCommons appCommons = new AppCommons(
                        new DataDispatchService<>(),
                        new DataDispatchService<>()
                );
                
                DesktopForm mainForm = new DesktopForm();
                
                DesktopCtrl mainController = new DesktopCtrl(
                        mainForm, settings, 
                        new DesktopService(settings, appCommons)
                );
                mainController.start();
        });        
    }
}
