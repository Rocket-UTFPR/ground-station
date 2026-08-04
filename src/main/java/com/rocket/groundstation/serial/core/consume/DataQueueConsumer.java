package com.rocket.groundstation.serial.core.consume;

import com.rocket.groundstation.serial.core.dispatch.DataDispatcher;
import java.util.concurrent.LinkedBlockingQueue;


public class DataQueueConsumer<T> implements Runnable{    
    private final LinkedBlockingQueue<byte[]> queue;
    private final DataDispatcher dispatcher;
    private final SerialDataDecoder<T> decoder;
    
    public DataQueueConsumer(LinkedBlockingQueue<byte[]> queue, DataDispatcher<byte[]> dispatcher){
        if(queue==null||dispatcher==null) throw new IllegalArgumentException("Nothing can be null");
        this.queue = queue;
        this.dispatcher = dispatcher;
        this.decoder = null;
    }
    
    public DataQueueConsumer(LinkedBlockingQueue<byte[]> queue, DataDispatcher<T> dispatcher, SerialDataDecoder<T> decoder) throws IllegalArgumentException{
        if(queue==null||dispatcher==null||decoder==null) throw new IllegalArgumentException("Nothing can be null");
        this.queue = queue;
        this.dispatcher = dispatcher;
        this.decoder = decoder;
    }
    
    @Override
    public void run() {
        if(decoder==null) consume();
        else consumeAndDecode();
    }
    
    private void consume(){
        try {
            while(true){
                dispatcher.dispatch(queue.take());
            }
        } catch(InterruptedException ex){}
    }
    
    private void consumeAndDecode(){
        try {
            while(true){
                T decodedData = decoder.add(queue.take());
                if(decodedData!=null) dispatcher.dispatch(decodedData);
            }
        } catch(InterruptedException ex){}
    }
}
