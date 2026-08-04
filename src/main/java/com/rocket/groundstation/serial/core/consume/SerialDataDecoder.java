package com.rocket.groundstation.serial.core.consume;


public interface SerialDataDecoder<T> {
    public T add(byte[] bytes);
}
