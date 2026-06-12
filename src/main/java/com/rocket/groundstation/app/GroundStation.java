package com.rocket.groundstation.app;

import com.rocket.groundstation.controller.MainController;
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
                MainForm mainForm = new MainForm();
                MainController mainController = new MainController(mainForm);
                mainController.start();
        });
    }
}
