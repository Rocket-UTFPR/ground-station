package com.rocket.groundstation.desktop;

import com.rocket.groundstation.settings.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.KeyStroke;


public class DesktopForm extends javax.swing.JFrame {    
    private Rectangle windowBounds;
    private DisplayMode displayMode;
    private DisplayMode oldDisplayMode;
    private final GraphicsDevice graphicsDevice;
    
    public DesktopForm() {        
        initComponents();
        setLocationRelativeTo(null);        
        
        displayMode = DisplayMode.WINDOWED;
        oldDisplayMode = DisplayMode.BORDERLESSWINDOW;
        windowBounds = getBounds();
        graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        openMapBt = new javax.swing.JButton();
        openSettingsBt = new javax.swing.JButton();
        openSerialMonitorBt = new javax.swing.JButton();
        openLayersBt = new javax.swing.JButton();
        openFileBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        openMapBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        openMapBt.setText("Mapa");
        openMapBt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        openSettingsBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        openSettingsBt.setText("Opções");
        openSettingsBt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        openSerialMonitorBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        openSerialMonitorBt.setText("Monitor serial");
        openSerialMonitorBt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        openLayersBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        openLayersBt.setText("Marcadores");
        openLayersBt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        openFileBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        openFileBt.setText("Gravar");
        openFileBt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        desktop.setLayer(openMapBt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(openSettingsBt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(openSerialMonitorBt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(openLayersBt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(openFileBt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(openLayersBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(openSerialMonitorBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(openMapBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(openSettingsBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(openFileBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(1048, Short.MAX_VALUE))
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(openMapBt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(openLayersBt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(openSerialMonitorBt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(openFileBt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(openSettingsBt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(358, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
                
    public void showInFrame(JInternalFrame inFrame){        
        boolean added = false;        
        for(JInternalFrame f : desktop.getAllFrames()){
            if(f == inFrame){
                added = true;                
                break;
            }
        }
        if(!added) desktop.add(inFrame);
        
        if(!inFrame.isVisible()){
            inFrame.setLocation(
                    (desktop.getWidth() - inFrame.getWidth()) / 2, 
                    (desktop.getHeight() - inFrame.getHeight()) / 2
            );
        }
        
        inFrame.setVisible(true);        
        try {            
            inFrame.setIcon(false);        
            inFrame.setSelected(true);
            inFrame.toFront();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(DesktopForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void setDisplayMode(DisplayMode mode) {
        if(mode==null) return;
        if(mode==displayMode) return;        
        
        if(displayMode==DisplayMode.WINDOWED && !(getExtendedState()==JFrame.MAXIMIZED_BOTH)) 
            windowBounds = getBounds();
        
        switch(mode){            
            case WINDOWED -> {
                graphicsDevice.setFullScreenWindow(null);                
                dispose();
                setUndecorated(false);
                setExtendedState(JFrame.NORMAL);                
                if(windowBounds!=null) setBounds(windowBounds);               
                
                setVisible(true);
            }
            case BORDERLESSWINDOW -> {
                graphicsDevice.setFullScreenWindow(null);
                dispose();
                setUndecorated(true);
                setExtendedState(JFrame.MAXIMIZED_BOTH);

                setVisible(true);
            }
            case FULLSCREEN -> {
                dispose();
                setUndecorated(true);
                setVisible(true);

                graphicsDevice.setFullScreenWindow(this);
            }
        }
        oldDisplayMode = displayMode;
        displayMode = mode;
    }
        
    public DisplayMode getDisplayMode(){
        return displayMode;
    }
    
    public DisplayMode getOldDisplayMode(){
        return oldDisplayMode;
    }
    
    public void addOpenMapBtListener(ActionListener al){
        openMapBt.addActionListener(al);
    }
    
    public void addOpenLayersBtListener(ActionListener al){
        openLayersBt.addActionListener(al);
    }
    
    public void addOpenSerialMonitorBtListener(ActionListener al){
        openSerialMonitorBt.addActionListener(al);
    }
    
    public void addOpenFileBtListener(ActionListener al){
        openFileBt.addActionListener(al);
    }
    
    public void addOpenSettingsBtListener(ActionListener al){
        openSettingsBt.addActionListener(al);
    }
    
    public void addToggleFullscreenAction(Action action) {
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0),
                "toggleFullscreen"
        );
        getRootPane().getActionMap().put("toggleFullscreen", action);
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DesktopForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DesktopForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DesktopForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DesktopForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>        
        //</editor-fold>        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DesktopForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JButton openFileBt;
    private javax.swing.JButton openLayersBt;
    private javax.swing.JButton openMapBt;
    private javax.swing.JButton openSerialMonitorBt;
    private javax.swing.JButton openSettingsBt;
    // End of variables declaration//GEN-END:variables
}
