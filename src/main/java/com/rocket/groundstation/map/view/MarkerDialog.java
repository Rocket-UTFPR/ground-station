package com.rocket.groundstation.map.view;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class MarkerDialog extends javax.swing.JDialog {

    public MarkerDialog(java.awt.Window parent, String title) {
        super(parent, title);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameTf = new javax.swing.JTextField();
        nameLb = new javax.swing.JLabel();
        latTf = new javax.swing.JTextField();
        latLb = new javax.swing.JLabel();
        lonTf = new javax.swing.JTextField();
        lonLb = new javax.swing.JLabel();
        confirmBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Marcador");

        nameTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        nameLb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameLb.setText("Nome");

        latTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        latLb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        latLb.setText("Latitude");

        lonTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lonLb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lonLb.setText("Longitude");

        confirmBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        confirmBt.setText("Confirmar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 129, Short.MAX_VALUE)
                        .addComponent(confirmBt))
                    .addComponent(lonTf)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLb)
                            .addComponent(latLb)
                            .addComponent(lonLb))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(latTf)
                    .addComponent(nameTf))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(nameLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(latLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(latTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lonLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lonTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 19, Short.MAX_VALUE)
                .addComponent(confirmBt)
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public String nameTfGetText(){
        return nameTf.getText();
    }
    public String latTfGetText(){
        return latTf.getText();
    }
    public String lonTfGetText(){
        return lonTf.getText();
    }
    
    public void nameTfSetText(String t){
        nameTf.setText(t);
    }
    public void latTfSetText(String t){
        latTf.setText(t);
    }
    public void lonTfSetText(String t){
        lonTf.setText(t);
    }
    
    public void showErrorMsg(String msg, String title){        
        JOptionPane.showMessageDialog(
           this,
           msg,
           title,
           JOptionPane.ERROR_MESSAGE
        );
    }
    
    public void addConfirmBtListener(ActionListener al){
        confirmBt.addActionListener(al);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmBt;
    private javax.swing.JLabel latLb;
    private javax.swing.JTextField latTf;
    private javax.swing.JLabel lonLb;
    private javax.swing.JTextField lonTf;
    private javax.swing.JLabel nameLb;
    private javax.swing.JTextField nameTf;
    // End of variables declaration//GEN-END:variables
}
