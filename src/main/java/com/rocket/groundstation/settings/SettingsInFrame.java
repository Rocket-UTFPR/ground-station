package com.rocket.groundstation.settings;

import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


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
        wpPathLb = new javax.swing.JLabel();
        wpPathTf = new javax.swing.JTextField();
        wpPathBt = new javax.swing.JButton();
        mapPanel = new javax.swing.JPanel();
        mapApplyBt = new javax.swing.JButton();
        mapPathBt = new javax.swing.JButton();
        mapPathLb = new javax.swing.JLabel();
        mapPathTf = new javax.swing.JTextField();
        mapRestoreBt = new javax.swing.JButton();
        themePathLb = new javax.swing.JLabel();
        themePathTf = new javax.swing.JTextField();
        themePathBt = new javax.swing.JButton();
        satThemePathLb = new javax.swing.JLabel();
        satThemePathTf = new javax.swing.JTextField();
        satThemePathBt = new javax.swing.JButton();
        serialPanel = new javax.swing.JPanel();
        serialApplyBt = new javax.swing.JButton();
        serialRestoreBt = new javax.swing.JButton();
        bufferLb = new javax.swing.JLabel();
        bufferSizeSpnr = new javax.swing.JSpinner();
        bytesLb = new javax.swing.JLabel();
        timeOutModeLb = new javax.swing.JLabel();
        timeOutModeCb = new javax.swing.JComboBox<>();
        readTimeOutLb = new javax.swing.JLabel();
        readTimeOutSpnr = new javax.swing.JSpinner();
        msLb = new javax.swing.JLabel();

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

        wpPathLb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        wpPathLb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        wpPathLb.setText("Plano de fundo:");

        wpPathBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/File-explorer_22.png"))); // NOI18N

        javax.swing.GroupLayout generalPanelLayout = new javax.swing.GroupLayout(generalPanel);
        generalPanel.setLayout(generalPanelLayout);
        generalPanelLayout.setHorizontalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(generalPanelLayout.createSequentialGroup()
                        .addContainerGap(421, Short.MAX_VALUE)
                        .addComponent(generalRestoreBt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(generalApplyBt))
                    .addGroup(generalPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(displayModeLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(wpPathLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(generalPanelLayout.createSequentialGroup()
                                .addComponent(wpPathTf, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wpPathBt))
                            .addComponent(displayModeCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        generalPanelLayout.setVerticalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(generalPanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(displayModeLb))
                    .addComponent(displayModeCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(generalPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(wpPathTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wpPathLb)))
                    .addComponent(wpPathBt))
                .addGap(0, 230, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, generalPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generalApplyBt)
                    .addComponent(generalRestoreBt))
                .addContainerGap())
        );

        tabbedPane.addTab("Geral", generalPanel);

        mapApplyBt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        mapApplyBt.setText("Aplicar");

        mapPathBt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mapPathBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/File-explorer_22.png"))); // NOI18N

        mapPathLb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mapPathLb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mapPathLb.setText("Mapa:");

        mapRestoreBt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        mapRestoreBt.setText("Restaurar");

        themePathLb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        themePathLb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        themePathLb.setText("Tema:");

        themePathBt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        themePathBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/File-explorer_22.png"))); // NOI18N

        satThemePathLb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        satThemePathLb.setText("Tema sat.:");

        satThemePathBt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        satThemePathBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/File-explorer_22.png"))); // NOI18N

        javax.swing.GroupLayout mapPanelLayout = new javax.swing.GroupLayout(mapPanel);
        mapPanel.setLayout(mapPanelLayout);
        mapPanelLayout.setHorizontalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(mapPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mapPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(mapRestoreBt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mapApplyBt))
                    .addGroup(mapPanelLayout.createSequentialGroup()
                        .addGroup(mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(satThemePathLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mapPathLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(themePathLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(mapPanelLayout.createSequentialGroup()
                                    .addComponent(mapPathTf, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(mapPathBt))
                                .addGroup(mapPanelLayout.createSequentialGroup()
                                    .addComponent(themePathTf, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(themePathBt)))
                            .addGroup(mapPanelLayout.createSequentialGroup()
                                .addComponent(satThemePathTf, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(satThemePathBt)))
                        .addGap(0, 320, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mapPanelLayout.setVerticalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mapPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mapPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mapPathTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mapPathLb)))
                    .addComponent(mapPathBt))
                .addGap(12, 12, 12)
                .addGroup(mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mapPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(themePathTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(themePathLb)))
                    .addComponent(themePathBt))
                .addGap(12, 12, 12)
                .addGroup(mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mapPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(satThemePathLb)
                            .addComponent(satThemePathTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(satThemePathBt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
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

        bufferLb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bufferLb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bufferLb.setText("Buffer:");

        bufferSizeSpnr.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        bytesLb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bytesLb.setText("bytes");

        timeOutModeLb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        timeOutModeLb.setText("Modo de time out:");

        readTimeOutLb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        readTimeOutLb.setText("Time out de leitura:");

        readTimeOutSpnr.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        msLb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        msLb.setText("ms");

        javax.swing.GroupLayout serialPanelLayout = new javax.swing.GroupLayout(serialPanel);
        serialPanel.setLayout(serialPanelLayout);
        serialPanelLayout.setHorizontalGroup(
            serialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serialPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(serialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, serialPanelLayout.createSequentialGroup()
                        .addGap(0, 406, Short.MAX_VALUE)
                        .addComponent(serialRestoreBt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(serialApplyBt))
                    .addGroup(serialPanelLayout.createSequentialGroup()
                        .addGroup(serialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(readTimeOutLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(timeOutModeLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bufferLb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(serialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(serialPanelLayout.createSequentialGroup()
                                .addGroup(serialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(serialPanelLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(readTimeOutSpnr, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, serialPanelLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(bufferSizeSpnr, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(serialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(msLb)
                                    .addComponent(bytesLb, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(serialPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(timeOutModeCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        serialPanelLayout.setVerticalGroup(
            serialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, serialPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(serialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bufferLb)
                    .addComponent(bufferSizeSpnr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bytesLb))
                .addGap(18, 18, 18)
                .addGroup(serialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeOutModeLb)
                    .addComponent(timeOutModeCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(serialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(readTimeOutLb)
                    .addComponent(readTimeOutSpnr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(msLb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
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
        
        timeOutModeCb.setModel(new DefaultComboBoxModel<>(new String[] { 
            "Não Bloqueante", "Semi Bloqueante", "Bloqueante"
        }));
        
        wpPathBt.addActionListener((e)->{
            JFileChooser jfc = new JFileChooser();
            if(jfc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
                wpPathTf.setText(jfc.getSelectedFile().toString());
        });
        
        mapPathBt.addActionListener((e)->{
            JFileChooser jfc = new JFileChooser();
            if(jfc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
                mapPathTf.setText(jfc.getSelectedFile().toString());
        });
        
        themePathBt.addActionListener((e)->{
            JFileChooser jfc = new JFileChooser();
            if(jfc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
                themePathTf.setText(jfc.getSelectedFile().toString());
        });
        
        satThemePathBt.addActionListener((e)->{
            JFileChooser jfc = new JFileChooser();
            if(jfc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
                satThemePathTf.setText(jfc.getSelectedFile().toString());
        });
    }
    // </editor-fold>
    
    // --------------- general --------------- //
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
    
    public String wpPathTfGetText(){
        return wpPathTf.getText();
    }
    
    public void wpPathTfSetText(String t){
        wpPathTf.setText(t);
    }
    
    
    // ---------------- map ---------------- //
    public String mapPathTfGetText(){
        return mapPathTf.getText();
    }
    public void mapPathTfSetText(String t){
        mapPathTf.setText(t);
    }
    
    public String themePathTfGetText(){
        return themePathTf.getText();
    }
    public void themePathTfSetText(String t){
        themePathTf.setText(t);
    }
    
    public String satThemePathTfGetText(){
        return satThemePathTf.getText();
    }
    public void satThemePathTfSetText(String t){
        satThemePathTf.setText(t);
    }
    
    
    // --------------- serial --------------- //
    public int bufferSizeSpnrGetValue(){
        return (int) bufferSizeSpnr.getValue();
    }
    public void bufferSizeSpnrSetValue(int v){
        bufferSizeSpnr.setValue(v);
    }
    
    public String timeOutModeCbGetSelected(){
        return timeOutModeCb.getSelectedItem().toString();
    }
    public void timeOutModeCbSetMode(String tom){
        if(null!=tom) switch (tom) {
            case "Não Bloqueante" -> timeOutModeCb.setSelectedIndex(0);
            case "Semi Bloqueante" -> timeOutModeCb.setSelectedIndex(1);
            case "Bloqueante" -> timeOutModeCb.setSelectedIndex(2);
        }
    }
    
    public int readTimeOutSpnrGetValue(){
        return (int) readTimeOutSpnr.getValue();
    }
    public void readTimeOutSpnrSetValue(int v){
        readTimeOutSpnr.setValue(v);
    }
    
    
    // --------------- the rest is history --------------- //
    public void showErrorMsg(String msg, String title){        
        JOptionPane.showMessageDialog(
           this,
           msg,
           title,
           JOptionPane.ERROR_MESSAGE
        );
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
    private javax.swing.JLabel bufferLb;
    private javax.swing.JSpinner bufferSizeSpnr;
    private javax.swing.JLabel bytesLb;
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
    private javax.swing.JLabel msLb;
    private javax.swing.JLabel readTimeOutLb;
    private javax.swing.JSpinner readTimeOutSpnr;
    private javax.swing.JButton satThemePathBt;
    private javax.swing.JLabel satThemePathLb;
    private javax.swing.JTextField satThemePathTf;
    private javax.swing.JButton serialApplyBt;
    private javax.swing.JPanel serialPanel;
    private javax.swing.JButton serialRestoreBt;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JButton themePathBt;
    private javax.swing.JLabel themePathLb;
    private javax.swing.JTextField themePathTf;
    private javax.swing.JComboBox<String> timeOutModeCb;
    private javax.swing.JLabel timeOutModeLb;
    private javax.swing.JButton wpPathBt;
    private javax.swing.JLabel wpPathLb;
    private javax.swing.JTextField wpPathTf;
    // End of variables declaration//GEN-END:variables
}
