package com.rocket.groundstation.desktop;

import com.rocket.groundstation.settings.DisplayMode;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.KeyStroke;


public class DesktopForm extends javax.swing.JFrame {    
    private Rectangle windowBounds;
    private DisplayMode displayMode;
    private DisplayMode oldDisplayMode;
    private final GraphicsDevice graphicsDevice;
    private Image backgroundImage;
    
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

        desktop = new javax.swing.JDesktopPane(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage == null) {
                    return;
                }

                int panelWidth = getWidth();
                int panelHeight = getHeight();

                int imageWidth = backgroundImage.getWidth(this);
                int imageHeight = backgroundImage.getHeight(this);

                double scale = Math.max(
                    (double) panelWidth / imageWidth,
                    (double) panelHeight / imageHeight
                );

                int newWidth = (int) (imageWidth * scale);
                int newHeight = (int) (imageHeight * scale);

                // Centraliza a imagem
                int x = (panelWidth - newWidth) / 2;
                int y = (panelHeight - newHeight) / 2;

                g.drawImage(
                    backgroundImage,
                    x,
                    y,
                    newWidth,
                    newHeight,
                    this
                );
            }
        };
        openMapBt = new javax.swing.JButton();
        openSettingsBt = new javax.swing.JButton();
        openSerialMonitorBt = new javax.swing.JButton();
        openLayersBt = new javax.swing.JButton();
        openFileBt = new javax.swing.JButton();
        mapLb = new javax.swing.JLabel();
        layersLb = new javax.swing.JLabel();
        settingsLb = new javax.swing.JLabel();
        fileLb = new javax.swing.JLabel();
        serialMonitorLb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        openMapBt.setBackground(new Color(0x00000000));
        openMapBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        openMapBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/map.png"))); // NOI18N
        openMapBt.setBorder(null);
        openMapBt.setContentAreaFilled(false);
        openMapBt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        openSettingsBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        openSettingsBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/gear.png"))); // NOI18N
        openSettingsBt.setContentAreaFilled(false);
        openSettingsBt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        openSerialMonitorBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        openSerialMonitorBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/monitoring.png"))); // NOI18N
        openSerialMonitorBt.setContentAreaFilled(false);
        openSerialMonitorBt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        openLayersBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        openLayersBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/marker.png"))); // NOI18N
        openLayersBt.setContentAreaFilled(false);
        openLayersBt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        openFileBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        openFileBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/file.png"))); // NOI18N
        openFileBt.setContentAreaFilled(false);
        openFileBt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        mapLb.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        mapLb.setForeground(new java.awt.Color(255, 255, 255));
        mapLb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mapLb.setText("Mapa");

        layersLb.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        layersLb.setForeground(new java.awt.Color(255, 255, 255));
        layersLb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        layersLb.setText("Marcadores");

        settingsLb.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        settingsLb.setForeground(new java.awt.Color(255, 255, 255));
        settingsLb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        settingsLb.setText("Configurações");

        fileLb.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        fileLb.setForeground(new java.awt.Color(255, 255, 255));
        fileLb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fileLb.setText("Gravação");

        serialMonitorLb.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        serialMonitorLb.setForeground(new java.awt.Color(255, 255, 255));
        serialMonitorLb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        serialMonitorLb.setText("<html><div style='text-align:center'>Monitor<br>Serial</div></html>");

        desktop.setLayer(openMapBt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(openSettingsBt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(openSerialMonitorBt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(openLayersBt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(openFileBt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(mapLb, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(layersLb, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(settingsLb, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(fileLb, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(serialMonitorLb, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(openSerialMonitorBt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(openMapBt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(openLayersBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(openFileBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(layersLb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mapLb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(settingsLb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fileLb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(openSettingsBt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(serialMonitorLb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(1035, Short.MAX_VALUE))
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(openMapBt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mapLb)
                .addGap(40, 40, 40)
                .addComponent(openLayersBt, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(layersLb)
                .addGap(40, 40, 40)
                .addComponent(openSerialMonitorBt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(serialMonitorLb)
                .addGap(40, 40, 40)
                .addComponent(openFileBt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fileLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(openSettingsBt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(settingsLb)
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
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
    
    public void setBackgroundImage(String path){
        backgroundImage = new ImageIcon(path).getImage();
        desktop.repaint();
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
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DesktopForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JLabel fileLb;
    private javax.swing.JLabel layersLb;
    private javax.swing.JLabel mapLb;
    private javax.swing.JButton openFileBt;
    private javax.swing.JButton openLayersBt;
    private javax.swing.JButton openMapBt;
    private javax.swing.JButton openSerialMonitorBt;
    private javax.swing.JButton openSettingsBt;
    private javax.swing.JLabel serialMonitorLb;
    private javax.swing.JLabel settingsLb;
    // End of variables declaration//GEN-END:variables
}
