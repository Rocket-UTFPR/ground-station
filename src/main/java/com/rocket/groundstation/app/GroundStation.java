package com.rocket.groundstation.app;

import com.fazecast.jSerialComm.SerialPort;
import com.rocket.groundstation.view.MapForm;
import java.io.*;
import java.net.*;


public class GroundStation {
    public static Socket client = null;
    
    public static void main(String[] args) {

        //TelemetryModel model = new TelemetryModel();
        
        MapForm view = new MapForm();
        
        //TelemetryController controller = new TelemetryController(model, view);

        //controller.start();

        //view.setVisible(true);
        
        
        //Serial
//        for(SerialPort sp : SerialPort.getCommPorts()){
//            System.out.println(sp);
//        }
//        SerialPort comPort = SerialPort.getCommPorts()[0];
//        comPort.setBaudRate(115200);
//        comPort.openPort();
//        try {
//            while (true){
//                while (comPort.bytesAvailable() == 0) Thread.sleep(90);
//                
//                byte[] readBuffer = new byte[comPort.bytesAvailable()];
//                int numRead = comPort.readBytes(readBuffer, readBuffer.length);
//                System.out.println("Read " + numRead + " bytes.");
//                
//                for(byte b : readBuffer){
//                    System.out.print((char)b);
//                }                
//                System.out.println("");                
//            }
//        }catch(Exception e){
//            System.out.println(e);
//        }
//        comPort.closePort();
        

        // WiFi
        try{
            client = new Socket("192.168.4.1", 3333);
            
            BufferedReader input = new BufferedReader(
                new InputStreamReader(client.getInputStream())
            );
            
            view.setVisible(true);
            
            while(true){
                String line = input.readLine();
                
                if(line == null){
                    System.out.println("disconnected");
                    break;
                }                
                System.out.println(line);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }finally{
            try {
                if(client != null) client.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }
    
    public static void sendPing(){
        PrintWriter output;
        try {
            output = new PrintWriter(client.getOutputStream(), true);
            output.println("ping");
        } catch (IOException ex) {
            System.out.println(ex);
        }        
    }
}
