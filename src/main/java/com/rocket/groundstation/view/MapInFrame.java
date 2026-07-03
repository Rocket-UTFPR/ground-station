package com.rocket.groundstation.view;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
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
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitPanel = new javax.swing.JPanel();
        split = new javax.swing.JSplitPane();
        mapPanel = new javax.swing.JPanel();
        infoSp = new javax.swing.JScrollPane();
        infoPanel = new javax.swing.JPanel();
        altLb = new javax.swing.JLabel();
        altTf = new javax.swing.JTextField();
        latTf = new javax.swing.JTextField();
        lonTf = new javax.swing.JTextField();
        latLb = new javax.swing.JLabel();
        lonLb = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mapa");

        split.setDividerLocation(700);
        split.setResizeWeight(0.5);

        javax.swing.GroupLayout mapPanelLayout = new javax.swing.GroupLayout(mapPanel);
        mapPanel.setLayout(mapPanelLayout);
        mapPanelLayout.setHorizontalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 713, Short.MAX_VALUE)
        );
        mapPanelLayout.setVerticalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
        );

        split.setLeftComponent(mapPanel);

        infoSp.setBorder(null);
        infoSp.setHorizontalScrollBar(null);
        infoSp.setVerifyInputWhenFocusTarget(false);

        altLb.setText("Altitude:");

        altTf.setEditable(false);

        latTf.setEditable(false);

        lonTf.setEditable(false);

        latLb.setText("Latitude:");

        lonLb.setText("Longitude:");

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(altLb)
                    .addComponent(altTf)
                    .addComponent(latTf)
                    .addComponent(lonTf)
                    .addComponent(latLb)
                    .addComponent(lonLb))
                .addGap(49, 49, 49))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(altLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(altTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(latLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(latTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lonLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lonTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(348, Short.MAX_VALUE))
        );

        infoSp.setViewportView(infoPanel);

        split.setRightComponent(infoSp);

        javax.swing.GroupLayout splitPanelLayout = new javax.swing.GroupLayout(splitPanel);
        splitPanel.setLayout(splitPanelLayout);
        splitPanelLayout.setHorizontalGroup(
            splitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(split, javax.swing.GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
        );
        splitPanelLayout.setVerticalGroup(
            splitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(split, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void initMap(File mapFile, File cacheDirectory, File renderThemeFile){
        MapView map = new MapView();
        
        mapPanel.setLayout(new BorderLayout());
        mapPanel.add(map, BorderLayout.CENTER);
                
        TileCache tileCache = AwtUtil.createTileCache(
            map.getModel().displayModel.getTileSize(),
            1.0,
            1024,
            cacheDirectory
        );
        
        MapDataStore mapDataStore = new MapFile(mapFile);
        
        TileRendererLayer tileRendererLayer = new TileRendererLayer(
                tileCache,
                mapDataStore,
                map.getModel().mapViewPosition,
                false, true, false,
                AwtGraphicFactory.INSTANCE                
        );
        
        try{
            tileRendererLayer.setXmlRenderTheme(new ExternalRenderTheme(renderThemeFile));
            map.getModel().displayModel.setUserScaleFactor(1.6f);
        } catch(FileNotFoundException | NullPointerException ex){
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
    
    public void setAltTfText(String txt){
        altTf.setText(txt);
    }
    
    public void setLatTfText(String txt){
        latTf.setText(txt);
    }
    
    public void setLonTfText(String txt){
        lonTf.setText(txt);
    }
    
    public void showErrorMsg(String msg, String title){        
        JOptionPane.showMessageDialog(
           this,
           msg,
           title,
           JOptionPane.ERROR_MESSAGE
        );
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel altLb;
    private javax.swing.JTextField altTf;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JScrollPane infoSp;
    private javax.swing.JLabel latLb;
    private javax.swing.JTextField latTf;
    private javax.swing.JLabel lonLb;
    private javax.swing.JTextField lonTf;
    private javax.swing.JPanel mapPanel;
    private javax.swing.JSplitPane split;
    private javax.swing.JPanel splitPanel;
    // End of variables declaration//GEN-END:variables
}
