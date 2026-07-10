package com.rocket.groundstation.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;
import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.graphics.Color;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.Style;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.map.awt.graphics.AwtGraphicFactory;
import org.mapsforge.map.awt.view.MapView;
import org.mapsforge.map.layer.overlay.Circle;


public class MapInFrame extends javax.swing.JInternalFrame {
    MapView map;
    Circle circleMarker;
    
    public MapInFrame() {
        initComponents();
        initDefaults();
    }
    
    public MapView getMap(){
        return map;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitPanel = new javax.swing.JPanel();
        split = new javax.swing.JSplitPane();
        mapPanel = new javax.swing.JPanel();
        infoSp = new javax.swing.JScrollPane();
        infoPanel = new javax.swing.JPanel();
        coordinatesLb = new javax.swing.JLabel();
        trackCb = new javax.swing.JCheckBox();
        drawCb = new javax.swing.JCheckBox();
        positionMarkerCb = new javax.swing.JCheckBox();
        copyBt = new javax.swing.JButton();
        satCb = new javax.swing.JCheckBox();

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
            .addGap(0, 671, Short.MAX_VALUE)
        );
        mapPanelLayout.setVerticalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );

        split.setLeftComponent(mapPanel);

        infoSp.setBorder(null);
        infoSp.setHorizontalScrollBar(null);
        infoSp.setVerifyInputWhenFocusTarget(false);

        coordinatesLb.setText("Inicie a leitura serial");

        trackCb.setText("Seguir");

        drawCb.setText("Desenhar rota");

        positionMarkerCb.setText("Mostrar no mapa");

        copyBt.setText("Copiar \"latitude, longitude\"");

        satCb.setText("Imagem de satélite");

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(coordinatesLb)
                        .addContainerGap(205, Short.MAX_VALUE))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(positionMarkerCb)
                            .addComponent(drawCb)
                            .addComponent(trackCb)
                            .addComponent(copyBt)
                            .addComponent(satCb))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(coordinatesLb)
                .addGap(18, 18, 18)
                .addComponent(copyBt)
                .addGap(100, 100, 100)
                .addComponent(positionMarkerCb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trackCb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(drawCb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(satCb)
                .addContainerGap(304, Short.MAX_VALUE))
        );

        infoSp.setViewportView(infoPanel);

        split.setRightComponent(infoSp);

        javax.swing.GroupLayout splitPanelLayout = new javax.swing.GroupLayout(splitPanel);
        splitPanel.setLayout(splitPanelLayout);
        splitPanelLayout.setHorizontalGroup(
            splitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(split, javax.swing.GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE)
        );
        splitPanelLayout.setVerticalGroup(
            splitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(split, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
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
    // <editor-fold defaultstate="collapsed" desc="initDefaults">
    private void initDefaults(){
        GraphicFactory gf = AwtGraphicFactory.INSTANCE;

        Paint fill = gf.createPaint();
        fill.setColor(Color.RED);
        fill.setStyle(Style.FILL);

        Paint stroke = gf.createPaint();
        stroke.setColor(Color.BLACK);
        stroke.setStrokeWidth(1);
        stroke.setStyle(Style.STROKE);
        
        circleMarker = new Circle(
                new LatLong(0, 0),
                5, fill, stroke
        );
        circleMarker.setVisible(false);
    }
    // </editor-fold> 

    public void setMap(MapView mapView){
        map = mapView;
        
        mapPanel.setLayout(new BorderLayout());
        mapPanel.add(map, BorderLayout.CENTER);
        
        mapPanel.revalidate();
        mapPanel.repaint();
        
        map.getLayerManager().getLayers().add(circleMarker);
        map.getModel().mapViewPosition.addObserver(()->{
            circleMarker.setRadius((float) (4 / Math.pow(1.8, map.getModel().mapViewPosition.getZoomLevel() - 18)));
        });
    }
    
    public void setCoordinatesLbText(String alt, String lat, String lon){
        coordinatesLb.setText(
                "<html>"
                        + "Altitude: " + alt + "<br>"
                        + "Latitude: " + lat + "<br>"
                        + "Longitude: " + lon +
                "</html>"
        );
    }
    
    public void mapSetCenter(double lat, double lon){
        map.getModel().mapViewPosition.setCenter(
                new LatLong(lat, lon)
        );
    }
    
    public void setPositionMarkerVisible(boolean visible){
        circleMarker.setVisible(visible);
    }
    
    public void updatePositionMarker(double lat, double lon){
        circleMarker.setLatLong(new LatLong(lat, lon));
        circleMarker.requestRedraw();
    }
    
    public void showErrorMsg(String msg, String title){        
        JOptionPane.showMessageDialog(
           this,
           msg,
           title,
           JOptionPane.ERROR_MESSAGE
        );
    }
    
    public void addCopyBtListener(ActionListener al){
        copyBt.addActionListener(al);
    }
    
    public void addPositionMarkerCbListener(ItemListener il){
        positionMarkerCb.addItemListener(il);
    }
    
    public void addTrackCbListener(ItemListener il){
        trackCb.addItemListener(il);
    }
    
    public void addSatCbListener(ItemListener il){
        satCb.addItemListener(il);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel coordinatesLb;
    private javax.swing.JButton copyBt;
    private javax.swing.JCheckBox drawCb;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JScrollPane infoSp;
    private javax.swing.JPanel mapPanel;
    private javax.swing.JCheckBox positionMarkerCb;
    private javax.swing.JCheckBox satCb;
    private javax.swing.JSplitPane split;
    private javax.swing.JPanel splitPanel;
    private javax.swing.JCheckBox trackCb;
    // End of variables declaration//GEN-END:variables
}
