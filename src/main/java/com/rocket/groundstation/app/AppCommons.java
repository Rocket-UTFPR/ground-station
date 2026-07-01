package com.rocket.groundstation.app;

import com.rocket.groundstation.model.SerialData;
import com.rocket.groundstation.serial.services.DispatchService;


public class AppCommons {
    private DispatchService<byte[]> rawDataDispatcher;
    private DispatchService<SerialData> decodedDataDispatcher;

    public AppCommons(DispatchService<byte[]> rawDataDispatcher, DispatchService<SerialData> decodedDataDispatcher) {
        this.rawDataDispatcher = rawDataDispatcher;
        this.decodedDataDispatcher = decodedDataDispatcher;
    }

    public DispatchService<byte[]> getRawDataDispatcher() {
        return rawDataDispatcher;
    }

    public DispatchService<SerialData> getDecodedDataDispatcher() {
        return decodedDataDispatcher;
    }
    
}
