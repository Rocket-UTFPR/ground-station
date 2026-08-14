package com.rocket.groundstation.telemetry;

import com.rocket.groundstation.serial.core.consume.SerialDataDecoder;


public class StandardDecoder implements SerialDataDecoder<TelemetryModel>{
    private StringBuilder data;
    
    public StandardDecoder(){
        data = new StringBuilder();
    }
    
    @Override
    public TelemetryModel add(byte[] bytes) {
        TelemetryModel decodedData = null;
        
        for(byte b : bytes){
            char c = (char) b;
            
            if(c=='<') data.setLength(0);
            
            data.append(c);
            
            if(c=='>') decodedData = buildDecodedData();
        }
        
        return decodedData;
    }
    
    private TelemetryModel buildDecodedData(){
        String s = data.toString().replace("<", "").replace(">", "");
        String[] values = s.split(";");
        
        if(values.length!=6){
            return null;
        }
        
        try{
            return new TelemetryModel(
                    Double.parseDouble(values[0]),
                    Double.parseDouble(values[1]),
                    Double.parseDouble(values[2]),
                    Boolean.parseBoolean(values[3]),
                    Boolean.parseBoolean(values[4]),
                    Long.parseLong(values[5]),
                    null, // atualizar quando tiver
                    null // atualizar quando tiver
            );
        } catch(NumberFormatException ex){
            return null;
        }
    }
}
