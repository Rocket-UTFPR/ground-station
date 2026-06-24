package com.rocket.groundstation.app;

import com.rocket.groundstation.serial.services.DispatchService;


public class AppCommons {
    private DispatchService<byte[]> rawDataDispatcher;
    private DispatchService decodedDataDispatcher; // definir tipo se der problema

    public AppCommons(DispatchService<byte[]> rawDataDispatcher, DispatchService decodedDataDispatcher) {
        this.rawDataDispatcher = rawDataDispatcher;
        this.decodedDataDispatcher = decodedDataDispatcher;
    }

    public DispatchService<byte[]> getRawDataDispatcher() {
        return rawDataDispatcher;
    }

    public DispatchService getDecodedDataDispatcher() {
        return decodedDataDispatcher;
    }
    
}
