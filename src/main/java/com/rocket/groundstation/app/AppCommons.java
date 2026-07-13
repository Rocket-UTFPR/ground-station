package com.rocket.groundstation.app;

import com.rocket.groundstation.serial.core.dispatch.DataDispatchService;


public class AppCommons {
    private DataDispatchService<byte[]> rawDataDispatcher;
    private DataDispatchService<TelemetryModel> decodedDataDispatcher;

    public AppCommons(DataDispatchService<byte[]> rawDataDispatcher, DataDispatchService<TelemetryModel> decodedDataDispatcher) {
        this.rawDataDispatcher = rawDataDispatcher;
        this.decodedDataDispatcher = decodedDataDispatcher;
    }

    public DataDispatchService<byte[]> getRawDataDispatcher() {
        return rawDataDispatcher;
    }

    public DataDispatchService<TelemetryModel> getDecodedDataDispatcher() {
        return decodedDataDispatcher;
    }
    
}
