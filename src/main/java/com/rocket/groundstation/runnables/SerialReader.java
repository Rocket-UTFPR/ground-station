package com.rocket.groundstation.runnables;

import com.fazecast.jSerialComm.SerialPort;
import java.util.concurrent.LinkedTransferQueue;


public class SerialReader implements Runnable{
    private final LinkedTransferQueue queue;
    private final SerialPort port;    
    private final int bufferSize;
    
    public SerialReader(LinkedTransferQueue queue, SerialPort port, int bufferSize){
        this.queue = queue;
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
                queue.put(readBuffer);
                
//                System.out.println("Read " + numRead + " bytes.");                
//                for(byte b : readBuffer){
//                    System.out.print((char)b);
//                }                
//                System.out.println("");                
            }
        }catch(Exception e){
            System.out.println(e);
        }
        port.closePort();
    }
    
}
