package com.rocket.groundstation.settings;


import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;


public class SettingsInFrame extends javax.swing.JInternalFrame {
    
    public SettingsInFrame() {
        initComponents();
        setup();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        generalPanel = new javax.swing.JPanel();
        displayModeLb = new javax.swing.JLabel();
        displayModeCb = new javax.swing.JComboBox<>();
        generalApplyBt = new javax.swing.JButton();
        generalRestoreBt = new javax.swing.JButton();
        mapPanel = new javax.swing.JPanel();
        mapApplyBt = new javax.swing.JButton();
        mapPathBt = new javax.swing.JButton();
        mapPathLb = new javax.swing.JLabel();
        mapPathTf = new javax.swing.JTextField();
        mapRestoreBt = new javax.swing.JButton();
        serialPanel = new javax.swing.JPanel();
        serialApplyBt = new javax.swing.JButton();
        serialRestoreBt = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Configurações");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        displayModeLb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        displayModeLb.setText("Modo de exibição:");

        generalApplyBt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        generalApplyBt.setText("Aplicar");

        generalRestoreBt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        generalRestoreBt.setText("Restaurar");

        javax.swing.GroupLayout generalPanelLayout = new javax.swing.GroupLayout(generalPanel);
        generalPanel.setLayout(generalPanelLayout);
        generalPanelLayout.setHorizontalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(displayModeLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayModeCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(402, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, generalPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(generalRestoreBt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(generalApplyBt)
                .addContainerGap())
        );
        generalPanelLayout.setVerticalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayModeLb)
                    .addComponent(displayModeCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generalApplyBt)
                    .addComponent(generalRestoreBt))
                .addContainerGap())
        );

        tabbedPane.addTab("Geral", generalPanel);

        mapApplyBt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        mapApplyBt.setText("Aplicar");

        mapPathBt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mapPathBt.setText("Escolher");

        mapPathLb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mapPathLb.setText("Mapa:");

        mapRestoreBt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        mapRestoreBt.setText("Restaurar");

        javax.swing.GroupLayout mapPanelLayout = new javax.swing.GroupLayout(mapPanel);
        mapPanel.setLayout(mapPanelLayout);
        mapPanelLayout.setHorizontalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(mapPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mapRestoreBt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mapApplyBt)
                .addContainerGap())
            .addGroup(mapPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mapPathLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mapPathTf, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mapPathBt)
                .addContainerGap(317, Short.MAX_VALUE))
        );
        mapPanelLayout.setVerticalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mapPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mapPathBt)
                    .addComponent(mapPathLb)
                    .addComponent(mapPathTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                .addGroup(mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mapApplyBt)
                    .addComponent(mapRestoreBt))
                .addContainerGap())
        );

        tabbedPane.addTab("Mapa", mapPanel);

        serialApplyBt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        serialApplyBt.setText("Aplicar");

        serialRestoreBt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        serialRestoreBt.setText("Restaurar");

        javax.swing.GroupLayout serialPanelLayout = new javax.swing.GroupLayout(serialPanel);
        serialPanel.setLayout(serialPanelLayout);
        serialPanelLayout.setHorizontalGroup(
            serialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, serialPanelLayout.createSequentialGroup()
                .addContainerGap(416, Short.MAX_VALUE)
                .addComponent(serialRestoreBt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(serialApplyBt)
                .addContainerGap())
        );
        serialPanelLayout.setVerticalGroup(
            serialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, serialPanelLayout.createSequentialGroup()
                .addContainerGap(287, Short.MAX_VALUE)
                .addGroup(serialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serialApplyBt)
                    .addComponent(serialRestoreBt))
                .addContainerGap())
        );

        tabbedPane.addTab("Serial", serialPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // <editor-fold defaultstate="collapsed" desc="setup">
    private void setup(){
        displayModeCb.setModel(new DefaultComboBoxModel<>(new String[] { 
            "Janela", "Janela sem bordas", "Tela cheia"
        }));
        
        mapPathBt.addActionListener((e)->{
            JFileChooser jfc = new JFileChooser();
            if(jfc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
                mapPathTf.setText(jfc.getSelectedFile().toString());
        });
    }
    // </editor-fold>
    
    public DisplayMode displayModeCbGetDisplayMode(){
        return DisplayMode.valueOf(displayModeCb.getSelectedItem());
    }
    
    public void displayModeCbSetDisplayMode(DisplayMode dm){
        if(null!=dm) switch (dm) {
            case WINDOWED -> displayModeCb.setSelectedIndex(0);
            case BORDERLESSWINDOW -> displayModeCb.setSelectedIndex(1);
            case FULLSCREEN -> displayModeCb.setSelectedIndex(2);
        }
    }
    
    public String mapPathTfGetText(){
        return mapPathTf.getText();
    }
    
    public void mapPathTfSetText(String t){
        mapPathTf.setText(t);
    }
    
    public void addGeneralApplyBtListener(ActionListener al){
        generalApplyBt.addActionListener(al);
    }
    
    public void addMapApplyBtListener(ActionListener al){
        mapApplyBt.addActionListener(al);
    }
    
    public void addSerialApplyBtListener(ActionListener al){
        serialApplyBt.addActionListener(al);
    }
    
    public void addGeneralRestoreBtListener(ActionListener al){
        generalRestoreBt.addActionListener(al);
    }
    
    public void addMapRestoreBtListener(ActionListener al){
        mapRestoreBt.addActionListener(al);
    }
    
    public void addSerialRestoreBtListener(ActionListener al){
        serialRestoreBt.addActionListener(al);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> displayModeCb;
    private javax.swing.JLabel displayModeLb;
    private javax.swing.JButton generalApplyBt;
    private javax.swing.JPanel generalPanel;
    private javax.swing.JButton generalRestoreBt;
    private javax.swing.JButton mapApplyBt;
    private javax.swing.JPanel mapPanel;
    private javax.swing.JButton mapPathBt;
    private javax.swing.JLabel mapPathLb;
    private javax.swing.JTextField mapPathTf;
    private javax.swing.JButton mapRestoreBt;
    private javax.swing.JButton serialApplyBt;
    private javax.swing.JPanel serialPanel;
    private javax.swing.JButton serialRestoreBt;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}
