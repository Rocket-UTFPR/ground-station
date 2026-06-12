package com.rocket.groundstation.controller;

import com.rocket.groundstation.view.MainForm;
import com.rocket.groundstation.view.MapInFrame;
import java.awt.event.ActionEvent;


public class MainController {    
        
    private final MainForm mainForm;        
    private MapInFrameController mapInFrameCntrl;

    public MainController(MainForm mainForm) {       
        this.mainForm = mainForm;
        
        mainForm.addOpenMapBtListener((e)->openMapInFrame(e));
    }

    public void start() {
        mainForm.setVisible(true);
        
    }
    
    private void openMapInFrame(ActionEvent e){
        if(mapInFrameCntrl==null) mapInFrameCntrl = new MapInFrameController(new MapInFrame());
        mainForm.showInFrame(mapInFrameCntrl.getMapInFrame());
    }
    
}
