package com.rocket.groundstation.view;

import java.awt.BorderLayout;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.map.awt.view.MapView;


public class MapInFrame extends javax.swing.JInternalFrame {
    MapView map;
    
    public MapInFrame() {
        initComponents();
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
        altLb = new javax.swing.JLabel();
        altTf = new javax.swing.JTextField();
        latTf = new javax.swing.JTextField();
        lonTf = new javax.swing.JTextField();
        latLb = new javax.swing.JLabel();
        lonLb = new javax.swing.JLabel();
        trackCb = new javax.swing.JCheckBox();
        drawCb = new javax.swing.JCheckBox();
        centerPointCb = new javax.swing.JCheckBox();

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
            .addGap(0, 798, Short.MAX_VALUE)
        );
        mapPanelLayout.setVerticalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
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

        trackCb.setText("Seguir");

        drawCb.setText("Desenhar rota");

        centerPointCb.setText("Ponto central");

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(altLb)
                            .addComponent(altTf, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(latTf)
                            .addComponent(lonTf)
                            .addComponent(latLb)
                            .addComponent(lonLb))
                        .addGap(49, 49, 49))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(trackCb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(drawCb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(centerPointCb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                .addGap(18, 18, 18)
                .addComponent(trackCb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(centerPointCb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(drawCb)
                .addContainerGap(330, Short.MAX_VALUE))
        );

        infoSp.setViewportView(infoPanel);

        split.setRightComponent(infoSp);

        javax.swing.GroupLayout splitPanelLayout = new javax.swing.GroupLayout(splitPanel);
        splitPanel.setLayout(splitPanelLayout);
        splitPanelLayout.setHorizontalGroup(
            splitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(split, javax.swing.GroupLayout.DEFAULT_SIZE, 972, Short.MAX_VALUE)
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

    public void showMap(MapView mapView){
        map = mapView;
        
        mapPanel.setLayout(new BorderLayout());
        mapPanel.add(map, BorderLayout.CENTER);
        
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
    
    public void mapSetCenter(double lat, double lon){
        map.getModel().mapViewPosition.setCenter(
                new LatLong(lat, lon)
        );
    }
    
    public void showErrorMsg(String msg, String title){        
        JOptionPane.showMessageDialog(
           this,
           msg,
           title,
           JOptionPane.ERROR_MESSAGE
        );
    }
    
    public void addTrackCbListener(ItemListener il){
        trackCb.addItemListener(il);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel altLb;
    private javax.swing.JTextField altTf;
    private javax.swing.JCheckBox centerPointCb;
    private javax.swing.JCheckBox drawCb;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JScrollPane infoSp;
    private javax.swing.JLabel latLb;
    private javax.swing.JTextField latTf;
    private javax.swing.JLabel lonLb;
    private javax.swing.JTextField lonTf;
    private javax.swing.JPanel mapPanel;
    private javax.swing.JSplitPane split;
    private javax.swing.JPanel splitPanel;
    private javax.swing.JCheckBox trackCb;
    // End of variables declaration//GEN-END:variables
}
