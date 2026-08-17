package com.rocket.groundstation.file;

import com.rocket.groundstation.util.InFrameFixer;
import java.io.File;


public class FileInFrameCtrl {
    FileInFrame fileInFrame;
    DataFileWriter dfw;
    
    public FileInFrameCtrl(FileInFrame fileInFrame, DataFileWriter dfw){
        this.fileInFrame = fileInFrame;
        this.dfw = dfw;
        
        InFrameFixer.fix(fileInFrame);
        
        addListeners();
    }
    
    public FileInFrame getFileInFrame(){
        return fileInFrame;
    }
    
    private void addListeners(){
        fileInFrame.getDecodedDataTb().addActionListener((e)->writeDecodedData());
        fileInFrame.getRawDataTb().addActionListener((e)->writeRawData());
    }
    
    private void writeDecodedData(){
        if(fileInFrame.getDecodedDataTb().isSelected()){
            File file = fileInFrame.showFileChooser();
            
            if(file==null){
                fileInFrame.getDecodedDataTb().setSelected(false);
                return;
            }
            
            dfw.writeDecodedData(file);
            fileInFrame.getDecodedDataTb().setText("Finalizar");
        } else{
            dfw.finishDecodedDataFile();
            fileInFrame.getDecodedDataTb().setText("Iniciar gravação");
        }
    }
    
    private void writeRawData(){
        if(fileInFrame.getRawDataTb().isSelected()){
            File file = fileInFrame.showFileChooser();
            
            if(file==null){
                fileInFrame.getRawDataTb().setSelected(false);
                return;
            }
            
            dfw.writeRawData(file);
            fileInFrame.getRawDataTb().setText("Finalizar");
        } else{
            dfw.finishRawDataFile();
            fileInFrame.getRawDataTb().setText("Iniciar gravação");
        }
    }
}
