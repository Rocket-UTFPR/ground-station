package com.rocket.groundstation.map.view;

import com.rocket.groundstation.util.GpsUtils;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
    MouseListener ml;
    
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
        infoLb = new javax.swing.JLabel();
        trackCb = new javax.swing.JCheckBox();
        positionMarkerCb = new javax.swing.JCheckBox();
        copyBt = new javax.swing.JButton();
        satCb = new javax.swing.JCheckBox();
        latLb = new javax.swing.JLabel();
        lonLb = new javax.swing.JLabel();
        latTf = new javax.swing.JTextField();
        lonTf = new javax.swing.JTextField();
        centerMapBt = new javax.swing.JButton();
        trajectoryNameTf = new javax.swing.JTextField();
        trajectoryTb = new javax.swing.JToggleButton();
        coordOnClickCb = new javax.swing.JCheckBox();
        trajNameLb = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mapa");

        split.setDividerLocation(720);
        split.setResizeWeight(1.0);

        javax.swing.GroupLayout mapPanelLayout = new javax.swing.GroupLayout(mapPanel);
        mapPanel.setLayout(mapPanelLayout);
        mapPanelLayout.setHorizontalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
        mapPanelLayout.setVerticalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 627, Short.MAX_VALUE)
        );

        split.setLeftComponent(mapPanel);

        infoSp.setBorder(null);
        infoSp.setHorizontalScrollBar(null);
        infoSp.setVerifyInputWhenFocusTarget(false);

        infoLb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        infoLb.setText("Inicie a leitura serial");

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

        trajectoryNameTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        trajectoryNameTf.setToolTipText("Nome do trajeto");

        trajectoryTb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        trajectoryTb.setText("Iniciar Trajetória");

        coordOnClickCb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        coordOnClickCb.setText("Mostrar coordenadas com clique");

        trajNameLb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        trajNameLb.setText("Nome:");

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(trackCb)
                            .addComponent(satCb)
                            .addComponent(positionMarkerCb)
                            .addComponent(latLb)
                            .addComponent(lonLb)
                            .addComponent(infoLb)
                            .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(centerMapBt)
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lonTf, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(latTf)))
                            .addComponent(copyBt)
                            .addComponent(coordOnClickCb))
                        .addGap(97, 97, 97))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(trajNameLb)
                            .addComponent(trajectoryNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(trajectoryTb, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0))))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(infoLb)
                .addGap(18, 18, 18)
                .addComponent(copyBt)
                .addGap(37, 37, 37)
                .addComponent(positionMarkerCb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trackCb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(satCb)
                .addGap(34, 34, 34)
                .addComponent(trajNameLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trajectoryNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trajectoryTb)
                .addGap(43, 43, 43)
                .addComponent(latLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(latTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lonLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lonTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(centerMapBt)
                .addGap(26, 26, 26)
                .addComponent(coordOnClickCb)
                .addGap(26, 26, 26))
        );

        infoSp.setViewportView(infoPanel);

        split.setRightComponent(infoSp);

        javax.swing.GroupLayout splitPanelLayout = new javax.swing.GroupLayout(splitPanel);
        splitPanel.setLayout(splitPanelLayout);
        splitPanelLayout.setHorizontalGroup(
            splitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(split, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
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
        infoSp.getVerticalScrollBar().setUnitIncrement(20);
        
        GraphicFactory gf = AwtGraphicFactory.INSTANCE;

        Paint fill = gf.createPaint();
        fill.setColor(Color.RED);
        fill.setStyle(Style.FILL);

        Paint stroke = gf.createPaint();
        stroke.setColor(Color.BLACK);
        stroke.setStrokeWidth(2);
        stroke.setStyle(Style.STROKE);
        
        circleMarker = new Circle(
                new LatLong(0, 0),
                5, fill, stroke
        );
        circleMarker.setVisible(false);
        
        ml = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LatLong latLong = map.getMapViewProjection().fromPixels(e.getX(), e.getY());
                latTf.setText(GpsUtils.format(latLong.getLatitude()));
                lonTf.setText(GpsUtils.format(latLong.getLongitude()));
            }
        };
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
            circleMarker.setRadius((float) (4.4f / Math.pow(1.85, map.getModel().mapViewPosition.getZoomLevel() - 18)));
        });
        coordOnClickCb.addItemListener((e)->{
            if(e.getStateChange()==ItemEvent.SELECTED){
                map.addMouseListener(ml);
            } else{
                map.removeMouseListener(ml);
            }
        });
    }
    
    public void infoLbSetText(String alt, String lat, String lon, String vertV, String horV, String resV){
        infoLb.setText(
                "<html><table cellpadding='1' cellspacing='0'>"
                + "<tr><td style='width:90px'><b>Altitude:</b></td><td>" + alt + "</td></tr>"
                + "<tr><td style='width:90px'><b>Latitude:</b></td><td>" + lat + "</td></tr>"
                + "<tr><td style='width:90px'><b>Longitude:</b></td><td>" + lon + "</td></tr>"
                + "<tr><td style='width:90px'><b>Vel. vertical:</b></td><td>" + vertV + "</td></tr>"
                + "<tr><td style='width:90px'><b>Vel. horizontal:</b></td><td>" + horV + "</td></tr>"
                + "<tr><td style='width:90px'><b>Vel. resultante:</b></td><td>" + resV + "</td></tr>"
                + "</table></html>"
        );
    }
    
    public void mapSetCenter(double lat, double lon){
        map.getModel().mapViewPosition.setCenter(
                new LatLong(lat, lon)
        );
    }
    
    public void positionMarkerSetVisible(boolean visible){
        circleMarker.setVisible(visible);
        positionMarkerToFront();
    }
    
    public void positionMarkerToFront(){
        map.getLayerManager().getLayers().remove(circleMarker);
        map.getLayerManager().getLayers().add(circleMarker);
    }
    
    public void positionMarkerUpdate(double lat, double lon){
        circleMarker.setLatLong(new LatLong(lat, lon));
        circleMarker.requestRedraw();
    }
    
    public void trajectoryTbSetText(String text){
        trajectoryTb.setText(text);
    }
    
    public String trajectoryNameTfGetText(){
        return trajectoryNameTf.getText();
    }
    
    public void trajectoryNameTfSetEnabled(boolean enabled){
        trajectoryNameTf.setEnabled(enabled);
    }
    
    public String latTfGetText(){
        return latTf.getText();
    }
    
    public String lonTfGetText(){
        return lonTf.getText();
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
    
    public void addTrajectoryTbListener(ItemListener il){
        trajectoryTb.addItemListener(il);
    }
    
    public void addCenterMapBtActionListener(ActionListener al){
        centerMapBt.addActionListener(al);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton centerMapBt;
    private javax.swing.JCheckBox coordOnClickCb;
    private javax.swing.JButton copyBt;
    private javax.swing.JLabel infoLb;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JScrollPane infoSp;
    private javax.swing.JLabel latLb;
    private javax.swing.JTextField latTf;
    private javax.swing.JLabel lonLb;
    private javax.swing.JTextField lonTf;
    private javax.swing.JPanel mapPanel;
    private javax.swing.JCheckBox positionMarkerCb;
    private javax.swing.JCheckBox satCb;
    private javax.swing.JSplitPane split;
    private javax.swing.JPanel splitPanel;
    private javax.swing.JCheckBox trackCb;
    private javax.swing.JLabel trajNameLb;
    private javax.swing.JTextField trajectoryNameTf;
    private javax.swing.JToggleButton trajectoryTb;
    // End of variables declaration//GEN-END:variables
}
