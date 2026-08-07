package com.rocket.groundstation.file;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JToggleButton;


public class FileInFrame extends javax.swing.JInternalFrame {

    public FileInFrame() {
        initComponents();
    }

    public JToggleButton getDecodedDataTb(){
        return decodedDataTb;
    }
    
    public JToggleButton getRawDataTb(){
        return rawDataTb;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        decodedDataLb = new javax.swing.JLabel();
        rawDataLb = new javax.swing.JLabel();
        decodedDataTb = new javax.swing.JToggleButton();
        rawDataTb = new javax.swing.JToggleButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gravação em arquivo");

        decodedDataLb.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        decodedDataLb.setText("Dados tratados");

        rawDataLb.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rawDataLb.setText("Dados serial");

        decodedDataTb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        decodedDataTb.setText("Iniciar gravação");

        rawDataTb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rawDataTb.setText("Iniciar gravação");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rawDataLb)
                    .addComponent(decodedDataLb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(decodedDataTb)
                    .addComponent(rawDataTb))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(decodedDataLb)
                    .addComponent(decodedDataTb))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rawDataLb)
                    .addComponent(rawDataTb))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public File showFileChooser(){
        JFileChooser jfc = new JFileChooser();
        
        if(jfc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION) return jfc.getSelectedFile();
        else return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel decodedDataLb;
    private javax.swing.JToggleButton decodedDataTb;
    private javax.swing.JLabel rawDataLb;
    private javax.swing.JToggleButton rawDataTb;
    // End of variables declaration//GEN-END:variables
}
