package com.rocket.groundstation.serial.core.read;

import com.fazecast.jSerialComm.SerialPort;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;


public class SerialReader implements Runnable{
    private final LinkedBlockingQueue<byte[]> rawDataQueue;
    private final LinkedBlockingQueue<byte[]> decodedDataQueue;
    private final SerialPort port;    
    private final int bufferSize;    
    
    public SerialReader(
            LinkedBlockingQueue rawDataQueue, LinkedBlockingQueue decodedDataQueue, 
            SerialPort port, int bufferSize
    ){
        this.rawDataQueue = rawDataQueue;
        this.decodedDataQueue = decodedDataQueue;
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
                
                byte[] data = Arrays.copyOf(readBuffer, numRead);
                
                rawDataQueue.put(data);
                decodedDataQueue.put(data);
            }
        } catch(NegativeArraySizeException ex){ // erro de leitura na porta
        } catch(InterruptedException ex){
        } finally{
            port.closePort();
        }
    }
    
}
