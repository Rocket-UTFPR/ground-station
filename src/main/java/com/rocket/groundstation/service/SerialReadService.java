package com.rocket.groundstation.service;

import com.fazecast.jSerialComm.SerialPort;
import com.rocket.groundstation.runnables.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;


public class SerialReadService {
    private final ExecutorService es;
    private final LinkedTransferQueue queue;
    private final DispatchService dispatcher;
    private final SerialPort port;    
    private final int bufferSize;
    
    public SerialReadService(
            DispatchService dispatcher, 
            SerialPort port, int baudRate, int timeOutMode, int readTimeOut,
            int bufferSize
    ){
        es = Executors.newFixedThreadPool(2);
        queue = new LinkedTransferQueue();
        
        this.dispatcher = dispatcher;
        this.port = port;
        if(port!=null){ // jogar exceção
            this.port.setBaudRate(baudRate);
            this.port.setComPortTimeouts(timeOutMode, readTimeOut, 0);
        }
        this.bufferSize = bufferSize;
    }
    
    public void startSerialRead(){
        es.submit(new SerialReader(queue, port, bufferSize));
        es.submit(new QueueConsumer(queue, dispatcher));
    }
}
