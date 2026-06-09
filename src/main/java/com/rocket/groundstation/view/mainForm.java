package com.rocket.groundstation.view;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.map.awt.graphics.*;
import org.mapsforge.map.awt.util.*;
import org.mapsforge.map.awt.view.*;
import org.mapsforge.map.datastore.MapDataStore;
import org.mapsforge.map.rendertheme.internal.MapsforgeThemes;
import org.mapsforge.map.rendertheme.ExternalRenderTheme;
import org.mapsforge.map.reader.MapFile;
import org.mapsforge.map.layer.cache.TileCache;
import org.mapsforge.map.layer.renderer.TileRendererLayer;


public class mainForm extends javax.swing.JFrame {

    
    public mainForm() {
        initComponents();
        setLocationRelativeTo(null);
        initMap();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mapPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout mapPanelLayout = new javax.swing.GroupLayout(mapPanel);
        mapPanel.setLayout(mapPanelLayout);
        mapPanelLayout.setHorizontalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        mapPanelLayout.setVerticalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mapPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mapPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        
    private void initMap(){
        MapView map = new MapView();
        
        mapPanel.setLayout(new BorderLayout());
        mapPanel.add(map, BorderLayout.CENTER);
                
        TileCache tileCache = AwtUtil.createTileCache(
            map.getModel().displayModel.getTileSize(),
            1.0,
            1024,
            new File("maps/cache")
        );
        
        MapDataStore mapDataStore = new MapFile(new File("maps/Brasil-Coast-South_oam.osm.map"));
        
        TileRendererLayer tileRendererLayer = new TileRendererLayer(
                tileCache,
                mapDataStore,
                map.getModel().mapViewPosition,
                false, true, false,
                AwtGraphicFactory.INSTANCE                
        );
        
        try{
            tileRendererLayer.setXmlRenderTheme(new ExternalRenderTheme(new File("maps/themes/elevate/Elevate.xml")));
            map.getModel().displayModel.setUserScaleFactor(1.6f);
        } catch(FileNotFoundException e){
            tileRendererLayer.setXmlRenderTheme(MapsforgeThemes.BIKER);
            map.getModel().displayModel.setUserScaleFactor(1.3f);
        }
        
        map.getLayerManager().getLayers().add(tileRendererLayer);        
        
        map.getModel().mapViewPosition.setCenter(
                new LatLong(-21.886998, -49.083419)
        );
        
        map.getModel().mapViewPosition.setZoomLevelMin((byte) 6);
        
        map.getModel().mapViewPosition.setZoomLevel((byte) 10);                
        
        mapPanel.revalidate();
        mapPanel.repaint();
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
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mapPanel;
    // End of variables declaration//GEN-END:variables
}
