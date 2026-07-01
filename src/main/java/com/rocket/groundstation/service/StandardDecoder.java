package com.rocket.groundstation.service;

import com.rocket.groundstation.serial.interfaces.SerialDataDecoder;


public class StandardDecoder<SerialData> implements SerialDataDecoder<SerialData>{
    SerialData decodedData;
    
    @Override
    public SerialData add(byte[] bytes) {
        return null;
    }
    
}
