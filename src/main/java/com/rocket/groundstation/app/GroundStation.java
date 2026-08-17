package com.rocket.groundstation.app;

import com.rocket.groundstation.desktop.DesktopCtrl;
import com.rocket.groundstation.settings.SettingsModel;
import com.rocket.groundstation.desktop.DesktopForm;
import com.rocket.groundstation.desktop.DesktopNav;
import com.rocket.groundstation.settings.SettingsService;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class GroundStation {
    private static SettingsModel settings;
    
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }                
            }
        } catch (Exception ex) {}
        
        try {
            settings = SettingsService.load();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                null,
                ex.getMessage(),
                "Erro ao carregar configurações",
                JOptionPane.ERROR_MESSAGE
            );
            settings = new SettingsModel();
        }
        
        SwingUtilities.invokeLater(()->{
                DesktopForm mainForm = new DesktopForm();
                
                DesktopCtrl mainController = new DesktopCtrl(
                        mainForm, settings, 
                        new DesktopNav(settings)
                );
                mainController.start();
        });        
    }
}
