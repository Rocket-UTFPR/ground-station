package com.rocket.groundstation.exceptions;


public class InvalidPathException extends Exception {
    String path;
    
    public InvalidPathException() {}
    
    public InvalidPathException(String msg, String path) {
        super(msg);
        this.path = path;
    }
    
    public String getPath(){
        return path;
    }
}
