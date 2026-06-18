package com.rocket.groundstation.app;

import com.rocket.groundstation.controller.MainController;
import com.rocket.groundstation.model.SettingsModel;
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
    }
}
