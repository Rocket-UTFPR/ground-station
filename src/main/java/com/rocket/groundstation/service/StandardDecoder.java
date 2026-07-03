package com.rocket.groundstation.service;

import com.rocket.groundstation.model.SerialData;
import com.rocket.groundstation.serial.interfaces.SerialDataDecoder;
import java.util.Arrays;


public class StandardDecoder implements SerialDataDecoder<SerialData>{
    private StringBuilder data;
    
    public StandardDecoder(){
        data = new StringBuilder();
    }
    
    @Override
    public SerialData add(byte[] bytes) {
        SerialData decodedData = null;
        
        for(byte b : bytes){
            char c = (char) b;
            
            if(c=='<') data.setLength(0);
            
            data.append(c);
            
            if(c=='>') decodedData = buildDecodedData();
        }
        
        return decodedData;
    }
    
    private SerialData buildDecodedData(){
        SerialData decodedData = new SerialData();
        
        String s = data.toString().replace("<", "").replace(">", "");
        String[] values = s.split(";");
        
        if(values.length!=3){
            return null;
        }
        
        try{
            decodedData.setAltitude(Double.parseDouble(values[0]));
            decodedData.setLatitude(Double.parseDouble(values[1]));
            decodedData.setLongitude(Double.parseDouble(values[2]));
            
            return decodedData;
        } catch(NumberFormatException ex){
            return null;
        }
    }
}
