package com.rocket.groundstation.serial.core.dispatch;


public interface DataListener<T> {
    public void onData(T oldData, T newdata);
}
