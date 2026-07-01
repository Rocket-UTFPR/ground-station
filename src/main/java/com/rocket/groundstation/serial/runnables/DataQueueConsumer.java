package com.rocket.groundstation.serial.runnables;

import com.rocket.groundstation.serial.interfaces.DataDispatcher;
import java.util.concurrent.LinkedBlockingQueue;


public class DataQueueConsumer<T> implements Runnable{    
    private final LinkedBlockingQueue<T> queue;
    private final DataDispatcher<T> dispatcher;
    
    public DataQueueConsumer(LinkedBlockingQueue queue, DataDispatcher dispatcher){
        this.queue = queue;
        this.dispatcher = dispatcher;
    }
    
    @Override
    public void run() {        
        try {
            while(true){
                dispatcher.dispatch(queue.take());
            }
        } catch(InterruptedException ex){}
    }
}
