package com.rocket.groundstation.serial.core.read;

import com.fazecast.jSerialComm.SerialPort;
import com.rocket.groundstation.serial.core.dispatch.DataDispatcher;
import com.rocket.groundstation.serial.core.consume.SerialDataDecoder;
import com.rocket.groundstation.serial.core.consume.DataQueueConsumer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;


public class SerialReadService<T> {
    private final ExecutorService es;
    private final LinkedBlockingQueue<byte[]> rawDataQueue;
    private final LinkedBlockingQueue<byte[]> decodedDataQueue;
    private final DataDispatcher<byte[]> rawDataDispatcher;
    private final DataDispatcher<T> decodedDataDispatcher;
    private final SerialDataDecoder<T> decoder;
    private final SerialPort port;
    private final int bufferSize;
    private final boolean decoderMode;
    
    public SerialReadService(
            DataDispatcher<byte[]> rawDataDispatcher,
            SerialPort port, int baudRate, int timeOutMode, int readTimeOut,
            int bufferSize
    ) throws IllegalArgumentException{
        if(port==null) throw new IllegalArgumentException("Port can't be null");
        
        if(rawDataDispatcher==null) throw new IllegalArgumentException("Dispatcher can't be null");
        
        es = Executors.newFixedThreadPool(2);
        rawDataQueue = new LinkedBlockingQueue<>();
        
        this.rawDataDispatcher = rawDataDispatcher;
        
        this.port = port;
        this.port.setBaudRate(baudRate);
        this.port.setComPortTimeouts(timeOutMode, readTimeOut, 0);

        this.bufferSize = bufferSize;
        
        decodedDataQueue = null;
        this.decodedDataDispatcher = null;
        this.decoder = null;
        
        decoderMode=false;
    } 
    
    public SerialReadService(
            DataDispatcher<byte[]> rawDataDispatcher, DataDispatcher<T> decodedDataDispatcher,
            SerialDataDecoder<T> decoder,
            SerialPort port, int baudRate, int timeOutMode, int readTimeOut,
            int bufferSize
    ) throws IllegalArgumentException{
        if(port==null) throw new IllegalArgumentException("Port can't be null");
        
        if(rawDataDispatcher==null || decodedDataDispatcher==null) throw new IllegalArgumentException("Dispatcher can't be null");
        
        if(decoder==null) throw new IllegalArgumentException("Decoder can't be null");
        
        es = Executors.newFixedThreadPool(3);
        rawDataQueue = new LinkedBlockingQueue<>();
        decodedDataQueue = new LinkedBlockingQueue<>();
        
        this.rawDataDispatcher = rawDataDispatcher;
        this.decodedDataDispatcher = decodedDataDispatcher;
        this.decoder = decoder;
        
        this.port = port;
        this.port.setBaudRate(baudRate);
        this.port.setComPortTimeouts(timeOutMode, readTimeOut, 0);
        
        this.bufferSize = bufferSize;
        
        decoderMode=true;
    }
    
    public void startSerialRead() throws CantOpenPortException{
        if(!port.openPort()) throw new CantOpenPortException();
        port.closePort();
        
        if(decoderMode){
            es.submit(new DataQueueConsumer<>(rawDataQueue, rawDataDispatcher));
            es.submit(new DataQueueConsumer<>(decodedDataQueue, decodedDataDispatcher, decoder));
            es.submit(new SerialReader(rawDataQueue, decodedDataQueue, port, bufferSize));
        } else{
            es.submit(new DataQueueConsumer<>(rawDataQueue, rawDataDispatcher));
            es.submit(new SerialReader(rawDataQueue, decodedDataQueue, port, bufferSize));
        }
    }
    
    public void stopSerialRead(){
        es.shutdownNow();
    }
    
    public void setPortBaudRate(int baud){
        port.setBaudRate(baud);
    }
}
