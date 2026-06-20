package com.rocket.groundstation.view;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SerialMonitorInFrame extends javax.swing.JInternalFrame {
    
    public SerialMonitorInFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SerialSp = new javax.swing.JScrollPane();
        SerialTa = new javax.swing.JTextArea();
        portsCb = new javax.swing.JComboBox<>();
        baudCb = new javax.swing.JComboBox<>();
        baudLb = new javax.swing.JLabel();
        portLb = new javax.swing.JLabel();
        clearSerialBt = new javax.swing.JButton();
        toggleSerialReadTb = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Monitor serial");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameDeiconified(evt);
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameIconified(evt);
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        SerialTa.setColumns(20);
        SerialTa.setRows(5);
        SerialTa.setEnabled(false);
        SerialSp.setViewportView(SerialTa);

        baudLb.setText("Baud:");

        portLb.setText("Porta:");

        clearSerialBt.setText("❌");
        clearSerialBt.setToolTipText("Limpar");

        toggleSerialReadTb.setText("Iniciar leitura");

        jToggleButton1.setSelected(true);
        jToggleButton1.setText("⏬");
        jToggleButton1.setToolTipText("Rolagem automática");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SerialSp)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(toggleSerialReadTb)
                                .addGap(438, 438, 438)
                                .addComponent(baudLb))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(269, 269, 269)
                                .addComponent(portLb)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(baudCb, 0, 86, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(jToggleButton1)
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
                    .addComponent(toggleSerialReadTb)
                    .addComponent(jToggleButton1))
                .addGap(18, 18, 18)
                .addComponent(SerialSp, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameIconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameIconified
        this.setMaximizable(false);
    }//GEN-LAST:event_formInternalFrameIconified

    private void formInternalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameDeiconified
        this.setMaximizable(true);
    }//GEN-LAST:event_formInternalFrameDeiconified

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        try {
            this.setIcon(false);
            this.setMaximum(false);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MapInFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formInternalFrameClosing

        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane SerialSp;
    private javax.swing.JTextArea SerialTa;
    private javax.swing.JComboBox<String> baudCb;
    private javax.swing.JLabel baudLb;
    private javax.swing.JButton clearSerialBt;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel portLb;
    private javax.swing.JComboBox<String> portsCb;
    private javax.swing.JToggleButton toggleSerialReadTb;
    // End of variables declaration//GEN-END:variables
}
