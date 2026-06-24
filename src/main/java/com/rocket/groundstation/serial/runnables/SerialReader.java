package com.rocket.groundstation.serial.runnables;

import com.fazecast.jSerialComm.SerialPort;
import com.rocket.groundstation.serial.interfaces.SerialDataDecoder;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;


public class SerialReader<T> implements Runnable{
    private final LinkedBlockingQueue<byte[]> rawDataQueue;
    private final LinkedBlockingQueue<T> decodedDataQueue;
    private final SerialDataDecoder<T> decoder;
    private final SerialPort port;    
    private final int bufferSize;    
    
    public SerialReader(
            LinkedBlockingQueue rawDataQueue, LinkedBlockingQueue decodedDataQueue, 
            SerialDataDecoder decoder,
            SerialPort port, int bufferSize
    ){
        this.rawDataQueue = rawDataQueue;
        this.decodedDataQueue = decodedDataQueue;
        this.decoder = decoder;
        this.port = port;
        this.bufferSize = bufferSize;
    }
    
    @Override
    public void run() {        
        port.openPort();
        try {
            while(true){
                byte[] readBuffer = new byte[bufferSize];
                int numRead = port.readBytes(readBuffer, bufferSize);
                
                rawDataQueue.put(Arrays.copyOf(readBuffer, numRead));
                
                T decodedData = decoder.add(readBuffer);
                if(decodedData != null) decodedDataQueue.put(decodedData);
            }
        }catch(Exception e){
            System.out.println("exceção do SerialReader");
            System.out.println(e);
        }
        port.closePort();
    }
    
}
