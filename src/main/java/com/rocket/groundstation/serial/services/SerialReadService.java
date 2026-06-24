package com.rocket.groundstation.serial.services;

import com.rocket.groundstation.serial.runnables.*;
import com.rocket.groundstation.serial.interfaces.*;
import com.fazecast.jSerialComm.SerialPort;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;


public class SerialReadService<T> {
    private final ExecutorService es;
    private final LinkedBlockingQueue<byte[]> rawDataQueue;
    private final LinkedBlockingQueue<T> decodedDataQueue;
    private final SerialDataDecoder<T> decoder;    
    private final DataDispatcher<byte[]> rawDataDispatcher;
    private final DataDispatcher<T> decodedDataDispatcher;
    private final SerialPort port;    
    private final int bufferSize;
    
    public SerialReadService(
            SerialDataDecoder<T> decoder,
            DataDispatcher<byte[]> rawDataDispatcher, DataDispatcher<T> decodedDataDispatcher,
            SerialPort port, int baudRate, int timeOutMode, int readTimeOut,
            int bufferSize
    )  {
        //if(port==null) throw new Exception("Porta não selecionada");
        //if(rawDataDispatcher==null || decodedDataDispatcher==null) throw new Exception("Dispatcher nulo");
        
        es = Executors.newFixedThreadPool(3);
        rawDataQueue = new LinkedBlockingQueue<>();
        decodedDataQueue = new LinkedBlockingQueue<>();
        
        this.decoder = decoder;
        
        this.rawDataDispatcher = rawDataDispatcher;
        this.decodedDataDispatcher = decodedDataDispatcher;
        
        this.port = port;        
        this.port.setBaudRate(baudRate);
        this.port.setComPortTimeouts(timeOutMode, readTimeOut, 0);
        
        this.bufferSize = bufferSize;
    }
    
    public void startSerialRead(){
        es.submit(new DataQueueConsumer<byte[]>(rawDataQueue, rawDataDispatcher));
        es.submit(new DataQueueConsumer<T>(decodedDataQueue, decodedDataDispatcher));
        es.submit(new SerialReader<T>(rawDataQueue, decodedDataQueue, decoder, port, bufferSize));
    }
}
