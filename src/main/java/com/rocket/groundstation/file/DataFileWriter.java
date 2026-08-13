package com.rocket.groundstation.file;

import com.rocket.groundstation.telemetry.TelemetryModel;
import com.rocket.groundstation.serial.core.dispatch.DataDispatcher;
import com.rocket.groundstation.serial.core.dispatch.DataListener;
import com.rocket.groundstation.util.GpsUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


public class DataFileWriter {
    private final DataDispatcher<byte[]> rdd;
    private final DataDispatcher<TelemetryModel> ddd;
    
    private DataListener<TelemetryModel> decodedQueueWriter;
    private LinkedBlockingQueue<TelemetryModel> decodedQueue;
    private ExecutorService esDecoded;
    private BufferedWriter bwDecoded;
    private boolean writingDecoded;
    
    private DataListener<byte[]> rawQueueWriter;
    private LinkedBlockingQueue<byte[]> rawQueue;
    private ExecutorService esRaw;
    private BufferedWriter bwRaw;
    private boolean writingRaw;
    
    public DataFileWriter(DataDispatcher<byte[]> rdd, DataDispatcher<TelemetryModel> ddd) {
        this.rdd = rdd;
        this.ddd = ddd;
        
        dataListenersSetup();
    }
    
    private void dataListenersSetup(){
        decodedQueueWriter = (oldData, newData) -> {
            try {
                decodedQueue.put(newData);
            } catch (InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        };
        
        rawQueueWriter = (oldData, newData) -> {
            try {
                rawQueue.put(newData);
            } catch (InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        };
    }
    
    public boolean writeDecodedData(File file){
        if(writingDecoded) return false;
        
        try {
            bwDecoded = new BufferedWriter(new FileWriter(file));
            bwDecoded.write("alt;lat;lon;newGPSdata;uptime");
            bwDecoded.newLine();
        } catch (IOException ex) {
            return false;
        }
        
        esDecoded = Executors.newSingleThreadExecutor();
        decodedQueue = new LinkedBlockingQueue<>();
        
        writingDecoded = true;
        
        ddd.addDataListener(decodedQueueWriter);
        
        esDecoded.submit(() -> {
            long lastFlush = System.currentTimeMillis();
            while(!Thread.currentThread().isInterrupted()){
                try{
                    TelemetryModel data = decodedQueue.take();
                    
                    bwDecoded.write(
                        GpsUtils.format(data.getAltitude())
                        +";"+GpsUtils.format(data.getLatitude())
                        +";"+ GpsUtils.format(data.getLongitude())
                        +";"+ data.isNewGpsData()
                        +";"+ data.getUptime()
                    );
                    bwDecoded.newLine();
                    
                    long now = System.currentTimeMillis();
                    if(now - lastFlush >= 5000){
                        bwDecoded.flush();
                        lastFlush = now;
                    }
                } catch (InterruptedException ex){
                    Thread.currentThread().interrupt();
                    break;
                } catch (IOException ex){
                    break;
                }
            }
        });
        
        return true;
    }
    
    public void finishDecodedDataFile() {
        if(bwDecoded==null || esDecoded==null || !writingDecoded) return;
        
        ddd.removeDataListener(decodedQueueWriter);
        esDecoded.shutdownNow();
        
        try{
            esDecoded.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        
        try{
            bwDecoded.flush();
            bwDecoded.close();
        } catch (IOException ex) {}
        
        writingDecoded = false;
    }
    
    public boolean writeRawData(File file){
        if(writingRaw) return false;
        
        try {
            bwRaw = new BufferedWriter(new FileWriter(file));
        } catch (IOException ex) {
            return false;
        }
        
        esRaw = Executors.newSingleThreadExecutor();
        rawQueue = new LinkedBlockingQueue<>();
        
        writingRaw = true;
        
        rdd.addDataListener(rawQueueWriter);
        
        esRaw.submit(() -> {
            long lastFlush = System.currentTimeMillis();
            while(!Thread.currentThread().isInterrupted()){
                try{
                    String data = new String(rawQueue.take(), StandardCharsets.US_ASCII);
                    
                    bwRaw.write(String.valueOf(data));
                    
                    long now = System.currentTimeMillis();
                    if(now - lastFlush >= 5000){
                        bwRaw.flush();
                        lastFlush = now;
                    }
                } catch (InterruptedException ex){
                    Thread.currentThread().interrupt();
                    break;
                } catch (IOException ex){
                    break;
                }
            }
        });
        
        return true;
    }
    
    public void finishRawDataFile() {
        if(bwRaw==null || esRaw==null || !writingRaw) return;
        
        rdd.removeDataListener(rawQueueWriter);
        esRaw.shutdownNow();
        
        try{
            esRaw.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        
        try{
            bwRaw.flush();
            bwRaw.close();
        } catch (IOException ex) {}
        
        writingRaw = false;
    }
}
