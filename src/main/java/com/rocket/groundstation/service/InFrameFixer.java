package com.rocket.groundstation.service;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;


public class InFrameFixer {
    public void fix(JInternalFrame inFrame){
        inFrame.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            @Override
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {}
            @Override
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {}
            @Override
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                try {
                    inFrame.setIcon(false);
                    inFrame.setMaximum(false);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(JInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            @Override
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {}
            @Override
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
                inFrame.setMaximizable(true);
            }
            @Override
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
                inFrame.setMaximizable(false);
            }
            @Override
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {}
        });
    }
}
