package com.rocket.groundstation.serial.interfaces;


public interface DataListener<T> {
    public void onData(T oldData, T newdata);
}
