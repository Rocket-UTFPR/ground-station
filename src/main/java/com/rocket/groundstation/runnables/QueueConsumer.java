package com.rocket.groundstation.runnables;

import com.rocket.groundstation.model.SerialData;
import com.rocket.groundstation.service.DispatchService;
import java.util.concurrent.LinkedTransferQueue;
import java.util.logging.Level;
import java.util.logging.Logger;


public class QueueConsumer implements Runnable{    
    private LinkedTransferQueue queue;
    private DispatchService dispatcher;
    
    public QueueConsumer(LinkedTransferQueue queue, DispatchService dispatcher){
        this.queue = queue;
        this.dispatcher = dispatcher;
    }
    
    @Override
    public void run() {
//        try {
//            SerialData data = (SerialData) queue.take();
//            dispatcher.dispatch(data);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(QueueConsumer.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }
    
}
