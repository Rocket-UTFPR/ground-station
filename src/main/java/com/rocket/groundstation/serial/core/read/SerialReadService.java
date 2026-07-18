package com.rocket.groundstation.serial.core.read;

import com.fazecast.jSerialComm.SerialPort;
import com.rocket.groundstation.serial.core.dispatch.*;
import com.rocket.groundstation.serial.core.consume.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;


public class SerialReadService<T> {
    private ExecutorService es;
    private final LinkedBlockingQueue<byte[]> rawDataQueue;
    private final LinkedBlockingQueue<byte[]> decodedDataQueue;
    private DataDispatcher<byte[]> rawDataDispatcher;
    private DataDispatcher<T> decodedDataDispatcher;
    private SerialDataDecoder<T> decoder;
    private SerialPort port;
    private int bufferSize;
    
    public SerialReadService(){
        rawDataQueue = new LinkedBlockingQueue<>();
        decodedDataQueue = new LinkedBlockingQueue<>();
        rawDataDispatcher = new DataDispatchService<>();
        decodedDataDispatcher = new DataDispatchService<>();
        bufferSize = 0;
    }
    
    public DataDispatcher<byte[]> getRawDataDispatcher() {
        return rawDataDispatcher;
    }

    public DataDispatcher<T> getDecodedDataDispatcher() {
        return decodedDataDispatcher;
    }
    
    public void setRawDataDispatcher(DataDispatcher<byte[]> rawDataDispatcher) {
        this.rawDataDispatcher = rawDataDispatcher;
    }

    public void setDecodedDataDispatcher(DataDispatcher<T> decodedDataDispatcher) {
        this.decodedDataDispatcher = decodedDataDispatcher;
    }

    public void setDecoder(SerialDataDecoder<T> decoder) {
        this.decoder = decoder;
    }

    public void setPort(SerialPort port) {
        this.port = port;
    }
    
    public void setPort(SerialPort port, int timeOutMode, int readTimeOut, int baud) {
        this.port = port;
        if(port!=null){
            port.setComPortTimeouts(timeOutMode, readTimeOut, 0);
            port.setBaudRate(baud);
        }
    }

    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }
    
    public void portSetBaudRate(int baud){
        if(port!=null) port.setBaudRate(baud);
    }
    
    public void startSerialRead() throws IllegalArgumentException, CantOpenPortException{
        if(port==null) throw new IllegalArgumentException("port can't be null");
        if(rawDataDispatcher==null) throw new IllegalArgumentException("rawDataDispatcher can't be null");
        
        if(!port.openPort()) throw new CantOpenPortException();
        port.closePort();
        
        if(decodedDataDispatcher!=null && decoder!=null){
            es = Executors.newFixedThreadPool(3);
            es.submit(new DataQueueConsumer<>(rawDataQueue, rawDataDispatcher));
            es.submit(new DataQueueConsumer<>(decodedDataQueue, decodedDataDispatcher, decoder));
            es.submit(new SerialReader(rawDataQueue, decodedDataQueue, port, bufferSize));
        } else{
            es = Executors.newFixedThreadPool(2);
            es.submit(new DataQueueConsumer<>(rawDataQueue, rawDataDispatcher));
            es.submit(new SerialReader(rawDataQueue, decodedDataQueue, port, bufferSize));
        }
    }
    
    public void stopSerialRead(){
        es.shutdownNow();
    }
}
