package com.rocket.groundstation.view;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;
import javax.swing.event.PopupMenuListener;
import javax.swing.text.DefaultCaret;


public class SerialMonitorInFrame extends javax.swing.JInternalFrame {
    private boolean autoScroll;
    
    public SerialMonitorInFrame() {
        autoScroll = true;        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        serialSp = new javax.swing.JScrollPane();
        serialTa = new javax.swing.JTextArea();
        portsCb = new javax.swing.JComboBox<>();
        baudCb = new javax.swing.JComboBox<>();
        baudLb = new javax.swing.JLabel();
        portLb = new javax.swing.JLabel();
        clearSerialBt = new javax.swing.JButton();
        serialReadTb = new javax.swing.JToggleButton();
        autoScrollTb = new javax.swing.JToggleButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Monitor serial");

        serialTa.setEditable(false);
        serialTa.setColumns(20);
        serialTa.setRows(5);
        serialTa.setAutoscrolls(false);
        serialSp.setViewportView(serialTa);

        baudCb.setModel(new javax.swing.DefaultComboBoxModel<>(new Integer[] { 9600, 115200 }));
        baudCb.setSelectedItem(115200);

        baudLb.setText("Baud:");

        portLb.setText("Porta:");

        clearSerialBt.setText("❌");
        clearSerialBt.setToolTipText("Limpar");
        clearSerialBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearSerialBtActionPerformed(evt);
            }
        });

        serialReadTb.setText("Iniciar leitura");

        autoScrollTb.setSelected(true);
        autoScrollTb.setText("⏬");
        autoScrollTb.setToolTipText("Rolagem automática");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(serialSp)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(serialReadTb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
                                .addComponent(baudLb))
                            .addComponent(portLb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(baudCb, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(autoScrollTb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearSerialBt))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(portsCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(2, 2, 2)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(portsCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(portLb))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(baudCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(baudLb)
                    .addComponent(clearSerialBt)
                    .addComponent(serialReadTb)
                    .addComponent(autoScrollTb))
                .addGap(18, 18, 18)
                .addComponent(serialSp, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearSerialBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearSerialBtActionPerformed
        serialTa.setText(null);
    }//GEN-LAST:event_clearSerialBtActionPerformed

    public void appendBytes(byte[] bytes){
        for(byte b : bytes){
            serialTa.append(String.valueOf((char) b));
        }        
    }
    
    public void toggleAutoScroll(){
        autoScroll = !autoScroll;
        
        DefaultCaret caret = (DefaultCaret) serialTa.getCaret();       
        
        if(autoScroll){
            caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
            serialTa.setCaretPosition(serialTa.getDocument().getLength());
        }
        else caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
    }        
    
    public void updatePortsCb(String[] ports){
        portsCb.removeAllItems();
        for(String port : ports){
            if(port!=null) portsCb.addItem(port);
        }
    }
    
    public String getSelectedPort(){
        return (String) portsCb.getSelectedItem();
    }
     
    public int getSelectedBaud(){
        return (Integer) baudCb.getSelectedItem();
    }
    
    public void deselectSerialReadTb(){
        serialReadTb.setSelected(false);
    }
    
    public void portsCbSetEnabled(boolean enabled){
        portsCb.setEnabled(enabled);
    }                
    
    public void showErrorMsg(String msg, String title){        
        JOptionPane.showMessageDialog(
           this,
           msg,
           title,
           JOptionPane.ERROR_MESSAGE
        );
    }
    
    public void addPortsCbListener(PopupMenuListener pml){
        portsCb.addPopupMenuListener(pml);
    }
    
    public void addSerialReadTbListener(ItemListener il){
        serialReadTb.addItemListener(il);
    }
    
    public void addAutoScrollTbListener(ActionListener al){
        autoScrollTb.addActionListener(al);
    }
    
    public void addBaudCbListener(ItemListener il){
        baudCb.addItemListener(il);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton autoScrollTb;
    private javax.swing.JComboBox<Integer> baudCb;
    private javax.swing.JLabel baudLb;
    private javax.swing.JButton clearSerialBt;
    private javax.swing.JLabel portLb;
    private javax.swing.JComboBox<String> portsCb;
    private javax.swing.JToggleButton serialReadTb;
    private javax.swing.JScrollPane serialSp;
    private javax.swing.JTextArea serialTa;
    // End of variables declaration//GEN-END:variables
}
