package com.rocket.groundstation.view;

import java.awt.BorderLayout;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.map.awt.graphics.AwtGraphicFactory;
import org.mapsforge.map.awt.util.AwtUtil;
import org.mapsforge.map.awt.view.MapView;
import org.mapsforge.map.datastore.MapDataStore;
import org.mapsforge.map.layer.cache.TileCache;
import org.mapsforge.map.layer.renderer.TileRendererLayer;
import org.mapsforge.map.reader.MapFile;
import org.mapsforge.map.rendertheme.ExternalRenderTheme;
import org.mapsforge.map.rendertheme.internal.MapsforgeThemes;


public class MapInFrame extends javax.swing.JInternalFrame {
   
    public MapInFrame() {
        initComponents();
        initMap();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        split = new javax.swing.JSplitPane();
        mapPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mapa");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameDeiconified(evt);
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameIconified(evt);
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        split.setDividerLocation(700);
        split.setResizeWeight(0.5);

        javax.swing.GroupLayout mapPanelLayout = new javax.swing.GroupLayout(mapPanel);
        mapPanel.setLayout(mapPanelLayout);
        mapPanelLayout.setHorizontalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        mapPanelLayout.setVerticalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 557, Short.MAX_VALUE)
        );

        split.setLeftComponent(mapPanel);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBar(null);
        jScrollPane1.setVerifyInputWhenFocusTarget(false);
        split.setRightComponent(jScrollPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(split, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(split)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameIconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameIconified
        this.setMaximizable(false);
    }//GEN-LAST:event_formInternalFrameIconified

    private void formInternalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameDeiconified
        this.setMaximizable(true);
    }//GEN-LAST:event_formInternalFrameDeiconified

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        try {
            this.setIcon(false);
            this.setMaximum(false);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MapInFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formInternalFrameClosing

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
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mapPanel;
    private javax.swing.JSplitPane split;
    // End of variables declaration//GEN-END:variables
}
