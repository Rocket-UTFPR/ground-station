package com.rocket.groundstation.view;

import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;


public class SettingsInFrame extends javax.swing.JInternalFrame {
    
    public SettingsInFrame() {
        initComponents();
        displayModeCb.setModel(new DefaultComboBoxModel<>(new String[] { 
            "Janela", "Janela sem bordas", "Tela cheia"
        }));
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        displayModeCb = new javax.swing.JComboBox<>();
        displayModeLb = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Opções");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        displayModeLb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        displayModeLb.setText("Modo de exibição:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(displayModeLb)
                .addGap(18, 18, 18)
                .addComponent(displayModeCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(340, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayModeCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displayModeLb))
                .addContainerGap(296, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void addDisplayModeCbListener(ItemListener il){
        displayModeCb.addItemListener(il);
    }
    
    public void setDisplayModeCbSelected(int s){
        if(!(displayModeCb.getSelectedIndex()==s)) displayModeCb.setSelectedIndex(s);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> displayModeCb;
    private javax.swing.JLabel displayModeLb;
    // End of variables declaration//GEN-END:variables
}
