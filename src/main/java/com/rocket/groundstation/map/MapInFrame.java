package com.rocket.groundstation.map;

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
import org.mapsforge.map.layer.overlay.Polyline;


public class MapInFrame extends javax.swing.JInternalFrame {
    MapView map;
    Circle circleMarker;
    Polyline route;
    
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
        positionMarkerCb = new javax.swing.JCheckBox();
        copyBt = new javax.swing.JButton();
        satCb = new javax.swing.JCheckBox();
        latLb = new javax.swing.JLabel();
        lonLb = new javax.swing.JLabel();
        latTf = new javax.swing.JTextField();
        lonTf = new javax.swing.JTextField();
        centerMapBt = new javax.swing.JButton();
        routeNameTf = new javax.swing.JTextField();
        routeTb = new javax.swing.JToggleButton();

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
            .addGap(0, 651, Short.MAX_VALUE)
        );
        mapPanelLayout.setVerticalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 627, Short.MAX_VALUE)
        );

        split.setLeftComponent(mapPanel);

        infoSp.setBorder(null);
        infoSp.setHorizontalScrollBar(null);
        infoSp.setVerifyInputWhenFocusTarget(false);

        coordinatesLb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        coordinatesLb.setText("Inicie a leitura serial");

        trackCb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        trackCb.setText("Seguir");

        positionMarkerCb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        positionMarkerCb.setText("Mostrar no mapa");

        copyBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        copyBt.setText("Copiar \"latitude, longitude\"");

        satCb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        satCb.setText("Imagem de satélite");

        latLb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        latLb.setText("Latitude:");

        lonLb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lonLb.setText("Longitude:");

        latTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lonTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        centerMapBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        centerMapBt.setText("Centralizar");

        routeNameTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        routeNameTf.setToolTipText("Nome da rota");

        routeTb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        routeTb.setText("Iniciar nova rota");

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(trackCb)
                    .addComponent(copyBt)
                    .addComponent(satCb)
                    .addComponent(positionMarkerCb)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(routeNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(routeTb))
                    .addComponent(latLb)
                    .addComponent(latTf, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(centerMapBt)
                        .addComponent(lonTf, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lonLb)
                    .addComponent(coordinatesLb))
                .addGap(0, 93, Short.MAX_VALUE))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(coordinatesLb)
                .addGap(18, 18, 18)
                .addComponent(copyBt)
                .addGap(41, 41, 41)
                .addComponent(positionMarkerCb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trackCb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(satCb)
                .addGap(41, 41, 41)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(routeNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(routeTb))
                .addGap(68, 68, 68)
                .addComponent(latLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(latTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lonLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lonTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(centerMapBt)
                .addGap(21, 21, 21))
        );

        infoSp.setViewportView(infoPanel);

        split.setRightComponent(infoSp);

        javax.swing.GroupLayout splitPanelLayout = new javax.swing.GroupLayout(splitPanel);
        splitPanel.setLayout(splitPanelLayout);
        splitPanelLayout.setHorizontalGroup(
            splitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(split, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
        );
        splitPanelLayout.setVerticalGroup(
            splitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(split)
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
        stroke.setStrokeWidth(1.7f);
        route = new Polyline(
                stroke, gf
        );
    }
    // </editor-fold> 

    public void setMap(MapView mapView){
        map = mapView;
        
        mapPanel.setLayout(new BorderLayout());
        mapPanel.add(map, BorderLayout.CENTER);
        
        mapPanel.revalidate();
        mapPanel.repaint();
        
        map.getLayerManager().getLayers().add(route);
        map.getLayerManager().getLayers().add(circleMarker);
        map.getModel().mapViewPosition.addObserver(()->{
            circleMarker.setRadius((float) (4 / Math.pow(1.8, map.getModel().mapViewPosition.getZoomLevel() - 18)));
        });
    }
    
    public void coordinatesLbSetText(String alt, String lat, String lon){
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
    
    public void positionMarkerSetVisible(boolean visible){
        circleMarker.setVisible(visible);
    }
    
    public void positionMarkerUpdate(double lat, double lon){
        circleMarker.setLatLong(new LatLong(lat, lon));
        circleMarker.requestRedraw();
    }
    
    public void routeTbSetText(String text){
        routeTb.setText(text);
    }
    
    public String latTfGetText(){
        return latTf.getText();
    }
    
    public String lonTfGetText(){
        return lonTf.getText();
    }
    
    public void routeAddPoint(double lat, double lon){
        route.addPoint(new LatLong(lat, lon));
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
    
    public void addRouteTbListener(ItemListener il){
        routeTb.addItemListener(il);
    }
    
    public void addCenterMapBtActionListener(ActionListener al){
        centerMapBt.addActionListener(al);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton centerMapBt;
    private javax.swing.JLabel coordinatesLb;
    private javax.swing.JButton copyBt;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JScrollPane infoSp;
    private javax.swing.JLabel latLb;
    private javax.swing.JTextField latTf;
    private javax.swing.JLabel lonLb;
    private javax.swing.JTextField lonTf;
    private javax.swing.JPanel mapPanel;
    private javax.swing.JCheckBox positionMarkerCb;
    private javax.swing.JTextField routeNameTf;
    private javax.swing.JToggleButton routeTb;
    private javax.swing.JCheckBox satCb;
    private javax.swing.JSplitPane split;
    private javax.swing.JPanel splitPanel;
    private javax.swing.JCheckBox trackCb;
    // End of variables declaration//GEN-END:variables
}
