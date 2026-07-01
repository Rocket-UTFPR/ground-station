package com.rocket.groundstation.serial.interfaces;


public interface SerialDataDecoder<T> {
    public T add(byte[] bytes);
}
