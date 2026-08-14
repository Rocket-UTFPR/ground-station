package com.rocket.groundstation.map.view;

import com.rocket.groundstation.custom.raven.TableActionEvent;
import com.rocket.groundstation.map.model.Marker;
import com.rocket.groundstation.map.model.Trajectory;
import com.rocket.groundstation.telemetry.TelemetryModel;
import com.rocket.groundstation.util.GpsUtils;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Locale;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class LayersInFrame extends javax.swing.JInternalFrame {

    public LayersInFrame() {
        initComponents();
        init();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPane = new javax.swing.JTabbedPane();
        markersPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        markersTable = new javax.swing.JTable();
        newMarkerBt = new javax.swing.JButton();
        trajectoriesPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        trajectoriesTable = new javax.swing.JTable();
        detailPanel = new javax.swing.JPanel();
        trajNameLb = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        detailLb = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Pontos e Trajetórias");

        markersTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        markersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "Posição", "Cor", "Opções", "instance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        markersTable.setRowHeight(40);
        markersTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(markersTable);
        if (markersTable.getColumnModel().getColumnCount() > 0) {
            markersTable.getColumnModel().getColumn(2).setPreferredWidth(50);
            markersTable.getColumnModel().getColumn(2).setMaxWidth(50);
            markersTable.getColumnModel().getColumn(3).setPreferredWidth(180);
            markersTable.getColumnModel().getColumn(3).setMaxWidth(180);
            markersTable.getColumnModel().getColumn(4).setResizable(false);
            markersTable.getColumnModel().getColumn(4).setPreferredWidth(10);
        }
        markersTable.getColumnModel().getColumn(0).setCellRenderer(
            new DefaultTableCellRenderer(){{setHorizontalAlignment(SwingConstants.CENTER);}}
        );
        markersTable.getColumnModel().getColumn(1).setCellRenderer(
            new DefaultTableCellRenderer(){{setHorizontalAlignment(SwingConstants.CENTER);}}
        );
        markersTable.getColumnModel().getColumn(2).setCellRenderer(
            new DefaultTableCellRenderer(){{setHorizontalAlignment(SwingConstants.CENTER);}}
        );
        markersTable.getColumnModel().getColumn(3).setCellRenderer(
            new DefaultTableCellRenderer(){{setHorizontalAlignment(SwingConstants.CENTER);}}
        );
        markersTable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {{
            setHorizontalAlignment(SwingConstants.CENTER);
        }});
        markersTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));

        newMarkerBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        newMarkerBt.setText("Adicionar");

        javax.swing.GroupLayout markersPanelLayout = new javax.swing.GroupLayout(markersPanel);
        markersPanel.setLayout(markersPanelLayout);
        markersPanelLayout.setHorizontalGroup(
            markersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(markersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(markersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, markersPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(newMarkerBt)))
                .addContainerGap())
        );
        markersPanelLayout.setVerticalGroup(
            markersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(markersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newMarkerBt)
                .addGap(14, 14, 14))
        );

        tabPane.addTab("Pontos", markersPanel);

        trajectoriesTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        trajectoriesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Cor", "Opções", "instance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        trajectoriesTable.setRowHeight(40);
        trajectoriesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(trajectoriesTable);
        if (trajectoriesTable.getColumnModel().getColumnCount() > 0) {
            trajectoriesTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            trajectoriesTable.getColumnModel().getColumn(1).setMaxWidth(50);
            trajectoriesTable.getColumnModel().getColumn(2).setPreferredWidth(180);
            trajectoriesTable.getColumnModel().getColumn(2).setMaxWidth(180);
            trajectoriesTable.getColumnModel().getColumn(3).setResizable(false);
            trajectoriesTable.getColumnModel().getColumn(3).setPreferredWidth(10);
        }
        trajectoriesTable.getColumnModel().getColumn(0).setCellRenderer(
            new DefaultTableCellRenderer(){{setHorizontalAlignment(SwingConstants.CENTER);}}
        );
        trajectoriesTable.getColumnModel().getColumn(1).setCellRenderer(
            new DefaultTableCellRenderer(){{setHorizontalAlignment(SwingConstants.CENTER);}}
        );
        trajectoriesTable.getColumnModel().getColumn(2).setCellRenderer(
            new DefaultTableCellRenderer(){{setHorizontalAlignment(SwingConstants.CENTER);}}
        );
        trajectoriesTable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {{
            setHorizontalAlignment(SwingConstants.CENTER);
        }});
        trajectoriesTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));

        javax.swing.GroupLayout trajectoriesPanelLayout = new javax.swing.GroupLayout(trajectoriesPanel);
        trajectoriesPanel.setLayout(trajectoriesPanelLayout);
        trajectoriesPanelLayout.setHorizontalGroup(
            trajectoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trajectoriesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                .addContainerGap())
        );
        trajectoriesPanelLayout.setVerticalGroup(
            trajectoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trajectoriesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabPane.addTab("Trajetórias", trajectoriesPanel);

        trajNameLb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        trajNameLb.setText("Selecione uma trajetória");

        detailLb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        detailLb.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        detailLb.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 102, 102)));
        jScrollPane3.setViewportView(detailLb);

        javax.swing.GroupLayout detailPanelLayout = new javax.swing.GroupLayout(detailPanel);
        detailPanel.setLayout(detailPanelLayout);
        detailPanelLayout.setHorizontalGroup(
            detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(detailPanelLayout.createSequentialGroup()
                        .addComponent(trajNameLb)
                        .addGap(0, 542, Short.MAX_VALUE)))
                .addContainerGap())
        );
        detailPanelLayout.setVerticalGroup(
            detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(trajNameLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane3.getVerticalScrollBar().setUnitIncrement(20);
        jScrollPane3.getHorizontalScrollBar().setUnitIncrement(20);

        tabPane.addTab("Detalhes", detailPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // <editor-fold defaultstate="collapsed" desc="init">
    private void init(){
        trajectoriesTable.getColumnModel().removeColumn(trajectoriesTable.getColumnModel().getColumn(3));
        trajectoriesTable.getColumnModel().getColumn(1).setCellRenderer(new com.rocket.groundstation.custom.app.ColorRenderer());
        trajectoriesTable.getColumnModel().getColumn(2).setCellRenderer(new com.rocket.groundstation.custom.raven.TableActionCellRender());
        markersTable.getColumnModel().removeColumn(markersTable.getColumnModel().getColumn(4));
        markersTable.getColumnModel().getColumn(2).setCellRenderer(new com.rocket.groundstation.custom.app.ColorRenderer());
        markersTable.getColumnModel().getColumn(3).setCellRenderer(new com.rocket.groundstation.custom.raven.TableActionCellRender());
    }
    // </editor-fold>

    public void setTabIndex(int index){
        tabPane.setSelectedIndex(index);
    }
    
    public int getTabIndex(){
        return tabPane.getSelectedIndex();
    }
    
    public void stopCellEditing(){
        if(trajectoriesTable.isEditing()) trajectoriesTable.getCellEditor().stopCellEditing();
        if(markersTable.isEditing()) markersTable.getCellEditor().stopCellEditing();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Tab 1 - Markers">
    public void updateMarkersTable(List<Marker> markers){
        DefaultTableModel model = (DefaultTableModel) markersTable.getModel();
        model.setRowCount(0);
        
        int row = 0;
        
        for(Marker m : markers){
            model.insertRow(row, new Object[]{
                m.getName(), 
                String.format(Locale.US, "%.6f, %.6f", m.getCircle().getPosition().getLatitude(), m.getCircle().getPosition().getLongitude()),
                m.getColor(), null, m
            });
            row++;
        }
    }
    
    public Marker getSelectedMarker(){
        return (Marker) markersTable.getModel().getValueAt(markersTable.getSelectedRow(), 4);
    }
    
    public Marker getMarker(int row){
        return (Marker) markersTable.getModel().getValueAt(row, 4);
    }
    
    public boolean markersTableColorCellSelected(){
        return (markersTable.getSelectedColumn()==2 && markersTable.getSelectedRow()>=0);
    }
    
    public boolean markersTablePositionCellSelected(){
        return (markersTable.getSelectedColumn()==1 && markersTable.getSelectedRow()>=0);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Tab 2 - Trajectories">
    public void updateTrajectoryTable(List<Trajectory> trajectories){
        DefaultTableModel model = (DefaultTableModel) trajectoriesTable.getModel();
        model.setRowCount(0);
        
        int row = 0;
        
        for(Trajectory t : trajectories){
            model.insertRow(row, new Object[]{
                t.getName(), t.getColor(), null, t
            });
            row++;
        }
    }
    
    public Trajectory getSelectedTrajectory(){
        return (Trajectory) trajectoriesTable.getModel().getValueAt(trajectoriesTable.getSelectedRow(), 3);
    }
    
    public Trajectory getTrajectory(int row){
        return (Trajectory) trajectoriesTable.getModel().getValueAt(row, 3);
    }
    
    public boolean trajTableColorCellSelected(){
        return (trajectoriesTable.getSelectedColumn()==1 && trajectoriesTable.getSelectedRow()>=0);
    }
    
    public boolean trajTableNameCellSelected(){
        return (trajectoriesTable.getSelectedColumn()==0 && trajectoriesTable.getSelectedRow()>=0);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Tab 3 - Details">
    public void updateDetailTab(Trajectory t, TelemetryModel launch, TelemetryModel apogee, TelemetryModel impact, double ascentV, double descentV){
        if(t==null) return;
        
        trajNameLb.setText("Trajetória: " + t.getName());
        
        double rtApogee = (apogee.getUptime()-launch.getUptime()) / 1000.0;
        if(rtApogee<0) rtApogee = 0;
        double rtImpact = (apogee.getUptime()-launch.getUptime()) / 1000.0;
        if(rtImpact<0) rtImpact = 0;
        
        detailLb.setText(
            "<html>" +
            "<div style='margin: 6px 10px;'>" +

            "<table cellpadding='5' cellspacing='0'>" +

            "<tr>" +
                "<td width='100'></td>" +
                "<td width='150' align='right'><b>LANÇAMENTO</b></td>" +
                "<td width='150' align='right'><b>APOGEU</b></td>" +
                "<td width='150' align='right'><b>IMPACTO</b></td>" +
            "</tr>" +

            "<tr>" +
                "<td><b>Altitude</b></td>" +
                "<td align='right'>" + String.format("%.1f m", launch.getAltitude()) + "</td>" +
                "<td align='right'>" + String.format("%.1f m", apogee.getAltitude()) + "</td>" +
                "<td align='right'>" + String.format("%.1f m", impact.getAltitude()) + "</td>" +
            "</tr>" +

            "<tr>" +
                "<td><b>Latitude</b></td>" +
                "<td align='right'>" + GpsUtils.format(launch.getLatitude()) + "</td>" +
                "<td align='right'>" + GpsUtils.format(apogee.getLatitude()) + "</td>" +
                "<td align='right'>" + GpsUtils.format(impact.getLatitude()) + "</td>" +
            "</tr>" +

            "<tr>" +
                "<td><b>Longitude</b></td>" +
                "<td align='right'>" + GpsUtils.format(launch.getLongitude()) + "</td>" +
                "<td align='right'>" + GpsUtils.format(apogee.getLongitude()) + "</td>" +
                "<td align='right'>" + GpsUtils.format(impact.getLongitude()) + "</td>" +
            "</tr>" +

            "<tr>" +
                "<td><b>Uptime</b></td>" +
                "<td align='right'>" + String.format("%.2f s", launch.getUptime() / 1000.0) + "</td>" +
                "<td align='right'>" + String.format("%.2f s", apogee.getUptime() / 1000.0) + "</td>" +
                "<td align='right'>" + String.format("%.2f s", impact.getUptime() / 1000.0) + "</td>" +
            "</tr>" +
                        
            "<tr>" +
                "<td><b>Tempo relativo</b></td>" +
                "<td align='right'>" + String.format("%.2f s", 0) + "</td>" +
                "<td align='right'>" + String.format("%.2f s", rtApogee) + "</td>" +
                "<td align='right'>" + String.format("%.2f s", rtImpact) + "</td>" +
            "</tr>" +

            "</table>" +

            "<br><br>" +

            "<table cellpadding='5' cellspacing='0'>" +
            "<tr>" +
                "<td width='250'><b>Velocidade média de subida</b></td>" +
                "<td>" + String.format("%.2f m/s", ascentV) + "</td>" +
            "</tr>" +
            "<tr>" +
                "<td><b>Velocidade média de descida</b></td>" +
                "<td>" + String.format("%.2f m/s", descentV) + "</td>" +
            "</tr>" +
            "</table>" +

            "</div>" +
            "</html>"
        );
    }
    // </editor-fold>
    
    public Color showColorChooser(Color initialColor){
        return JColorChooser.showDialog(
                this,
                "Escolha a cor",
                initialColor
        );
    }
    
    public boolean showConfirmDialog(String msg, String title, int messageType){
        return JOptionPane.showConfirmDialog(
                this,
                msg,
                title,
                JOptionPane.YES_NO_OPTION,
                messageType
        ) == 0;
    }
    
    public String showNameInputDialog(){
        return JOptionPane.showInputDialog(
                this,
                "Digite o novo nome:",
                "Alterar nome",
                JOptionPane.PLAIN_MESSAGE
        );
    }
    
    // <editor-fold defaultstate="collapsed" desc="Listeners">
    public void addTabPaneListener(ChangeListener cl){
        tabPane.addChangeListener(cl);
    }
    
    public void addNewMarkerBtListener(ActionListener al){
        newMarkerBt.addActionListener(al);
    }
    
    public void addMarkersTableActionBtListener(TableActionEvent tae){
        markersTable.getColumnModel().getColumn(3).setCellEditor(
                new com.rocket.groundstation.custom.raven.TableActionCellEditor(tae)
        );
    }
    
    public void addMarkersTableListener(MouseListener ml){
        markersTable.addMouseListener(ml);
    }
    
    public void addTrajTableActionBtListener(TableActionEvent tae){
        trajectoriesTable.getColumnModel().getColumn(2).setCellEditor(
                new com.rocket.groundstation.custom.raven.TableActionCellEditor(tae)
        );
    }
    
    public void addTrajectoriesTableListener(MouseListener ml){
        trajectoriesTable.addMouseListener(ml);
    }
    // </editor-fold>
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel detailLb;
    private javax.swing.JPanel detailPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel markersPanel;
    private javax.swing.JTable markersTable;
    private javax.swing.JButton newMarkerBt;
    private javax.swing.JTabbedPane tabPane;
    private javax.swing.JLabel trajNameLb;
    private javax.swing.JPanel trajectoriesPanel;
    private javax.swing.JTable trajectoriesTable;
    // End of variables declaration//GEN-END:variables
}
